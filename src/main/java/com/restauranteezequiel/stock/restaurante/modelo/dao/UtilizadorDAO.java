/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.modelo.dao;

import com.restauranteezequiel.stock.restaurante.modelo.conexao.Conexao;
import com.restauranteezequiel.stock.restaurante.modelo.conexao.ConexaoMySql;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Utilizador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author sara
 */
public class UtilizadorDAO {
    
    //chamar a conexao interface
    private final Conexao conexao;

    public UtilizadorDAO() {
        this.conexao = new ConexaoMySql();
    }
    
    public String salvar(Utilizador utilizador) {
        String resultado;
        if (utilizador.getId() == 0){
            utilizador.setEstado(true);
            resultado = adicionar(utilizador);
        } else {
            utilizador.setEstado(true);
            resultado = editar(utilizador);   
        }
        return resultado;
        //return utilizador.getId() == 0  ? adicionar(utilizador) : editar(utilizador);
    }

  
    private String adicionar(Utilizador utilizador) {
        String sql = "INSERT INTO Utilizador (nome, tipo_utilizador, username, senha, estado) VALUES (?, ?, ?, ?, ?)";

        Utilizador utilizadorTemp = buscarUtilizadorPeloUsername(utilizador.getUsername());

        if(utilizadorTemp != null) {
            return String.format("Error: username %s já existe na base de dados", utilizador.getUsername());
        }

        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preencherValoresPreparedStatement(preparedStatement, utilizador);

            int resultado = preparedStatement.executeUpdate();

            if (resultado == 1) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int novoId = generatedKeys.getInt(1);
                    utilizador.setId(novoId);
                }
                return "Utilizador adicionado com sucesso.";
            } else {
                return "Não foi possível adicionar utilizador";
            }
        } catch (SQLException e) {
            return String.format(" Error: %s", e.getMessage());
        }
    }




    private String editar(Utilizador utilizador) {
        String sql = "UPDATE Utilizador SET nome = ?, tipo_utilizador = ?, username = ?, senha = ?, estado = ? WHERE id = ?";
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedStatement, utilizador);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Utilizador editado com sucesso." : "Não foi possível editar utilizador";
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    
    private void preencherValoresPreparedStatement(PreparedStatement preparedStatement, Utilizador utilizador) throws SQLException {
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String senhaCript = passwordEncoder.encode(utilizador.getSenha());
        
        preparedStatement.setString(1, utilizador.getNome());
        preparedStatement.setString(2, utilizador.getTipo_utilizador());
        preparedStatement.setString(3, utilizador.getUsername());
        preparedStatement.setString(4, senhaCript);
        preparedStatement.setBoolean(5, utilizador.isEstado());
        
        if(utilizador.getId() != 0) {
            preparedStatement.setInt(6, utilizador.getId());
        }
    }
    
    
    public List<Utilizador> buscarTodosUtilizadores(){
        String sql = "SELECT * FROM Utilizador";
        List<Utilizador> utilizadores = new ArrayList<>();
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();

            while(result.next()) {
                //chamar os dados
                utilizadores.add(getUtilizador(result));
            }   
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        
        return utilizadores;
    }

    private Utilizador getUtilizador(ResultSet result) throws SQLException {
        Utilizador utilizador = new Utilizador();
        
        utilizador.setId((int) result.getInt("id"));
        utilizador.setNome(result.getString("nome"));
        utilizador.setTipo_utilizador(result.getString("tipo_utilizador"));
        utilizador.setUsername(result.getString("username"));
        utilizador.setSenha(result.getString("senha"));
        utilizador.setEstado(result.getBoolean("estado"));
        utilizador.setUltimo_login(result.getObject("ultimo_login", LocalDateTime.class));

        return utilizador;
    }
    
    public Utilizador buscarUtilizadorPeloId(int id){
        String sql = String.format("SELECT * FROM Utilizador WHERE id = %d", id);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();

            if(result.next()){
                return getUtilizador(result);
            }  
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        
        return null;
    }
    
    
    public Utilizador buscarUtilizadorPeloUsername(String username) {
        String sql = String.format("SELECT * FROM Utilizador WHERE username = '%s'", username);

        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            //preparedStatement.setString(1, username);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                return getUtilizador(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(String.format("Error: %s", e.getMessage()));
        }

        return null;
    }
    
    
    //Método que elimina um utilizador
    public String deleteUtilizadorPeloId(int id) {
        String sql = String.format("DELETE FROM Utilizador WHERE id = %d", id);
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Utilizador apagado com sucesso" : "Não foi possível apagar";
            
        } catch (SQLException e) {
            return String.format("Erro a apagar: %s", e.getMessage());
        }
    }
    
    
    public void actualizarUltimoLogin(Utilizador utilizador) {
        String sql = "UPDATE Utilizador SET ultimo_login = ? WHERE id = ?";
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preparedStatement.setString(1, LocalDateTime.now().toString());
            preparedStatement.setInt(2, utilizador.getId());
            
            int resultado = preparedStatement.executeUpdate();
            
            System.out.println(String.format("Atualizacao do ultimo login: %s", 
                    resultado == 1 ? "Com sucesso!" : "Sem Sucesso.")); 
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
    }
    
    public List<Utilizador> todosUtilizadores() {
        String sql = "SELECT * FROM Utilizador";
        List<Utilizador> utilizadores = new ArrayList<>();
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                utilizadores.add(getUtilizador(result));
            }
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        
        return utilizadores;
    }

    
}
