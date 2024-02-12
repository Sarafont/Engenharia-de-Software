/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.modelo.dao;

import com.restauranteezequiel.stock.restaurante.modelo.conexao.Conexao;
import com.restauranteezequiel.stock.restaurante.modelo.conexao.ConexaoMySql;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Fornecedores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sara
 */
public class FornecedoresDAO {
    //chamar a conexao interface
    private final Conexao conexao;

    public FornecedoresDAO() {
        this.conexao = new ConexaoMySql();
    }
    
    public String salvar(Fornecedores fornecedores) {
        String resultado;
        if (fornecedores.getId() == 0){
            resultado = adicionar(fornecedores);
        } else {
            resultado = editar(fornecedores);
        }
        return resultado;
    }

    private String adicionar(Fornecedores fornecedores) {
        String sql = "INSERT INTO Fornecedores (designação, contato, contribuinte, codPostal, morada, localidade, email, telefone) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
        Fornecedores fornecedoresTemp = buscarFornecedoresPeloDesignacao(fornecedores.getDesignacao());
        
        if(fornecedoresTemp != null) {
            return String.format("Error: %s já existe na base de dados", fornecedores.getDesignacao());
        }
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);

            preencherValoresPreparedStatement(preparedStatement, fornecedores);

            int resultado = preparedStatement.executeUpdate();
            return resultado == 1 ? "Fornecedor adicionado com sucesso." : "Não possível adicionar a fornecedor.";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
        
    }

    private String editar(Fornecedores fornecedores) {
        String sql = "UPDATE Fornecedores SET designação = ?, contato = ?, contribuinte = ?, codPostal = ?, localidade = ?, morada = ?, email = ?, telefone = ? WHERE id = ?";
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedStatement, fornecedores);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Fornecedor editado com sucesso." : "Não foi possível editar fornecedor";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    public Fornecedores buscarFornecedoresPeloDesignacao(String designacao) {
        String sql = String.format("SELECT * FROM Fornecedores WHERE designação = '%s'", designacao);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();

            if (result.next()) {
                return getFornecedores(result);
            }
            
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }

        return null;
    }
    

    private void preencherValoresPreparedStatement(PreparedStatement preparedStatement, Fornecedores fornecedores) throws SQLException {
        preparedStatement.setString(1, fornecedores.getDesignacao());
        preparedStatement.setString(2, fornecedores.getContato());
        preparedStatement.setString(3, fornecedores.getContribuinte());
        preparedStatement.setString(4, fornecedores.getCodPostal());
        preparedStatement.setString(5, fornecedores.getLocalidade());
        preparedStatement.setString(6, fornecedores.getMorada());
        preparedStatement.setString(7, fornecedores.getEmail());
        preparedStatement.setString(8, fornecedores.getTelefone());

        if(fornecedores.getId() != 0) {
            preparedStatement.setInt(9, fornecedores.getId());
        }
    }


    
    private Fornecedores getFornecedores(ResultSet result) throws SQLException {
        Fornecedores fornecedores = new Fornecedores();
        
        fornecedores.setId((int) result.getInt("id"));
        fornecedores.setDesignacao(result.getString("designação"));
        fornecedores.setContato(result.getString("contato"));
        fornecedores.setContribuinte( result.getString("contribuinte"));
        fornecedores.setCodPostal(result.getString("codPostal"));
        fornecedores.setLocalidade(result.getString("localidade"));
        fornecedores.setMorada(result.getString("morada"));
        fornecedores.setEmail(result.getString("email"));
        fornecedores.setTelefone(result.getString("telefone"));
        

        return fornecedores;
    }
    
    
    public List<Fornecedores> todasFornecedores() {
        String sql = "SELECT * FROM Fornecedores";
        
        List<Fornecedores> fornecedores = new ArrayList<>();

        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();

            while (result.next()) {
                fornecedores.add(getFornecedores(result));
            }
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }

        return fornecedores;
    }
    
    

    public Fornecedores buscarFornecedoresPeloId(int id) {
        String sql = String.format("SELECT * FROM Fornecedores WHERE id = %d", id);
        
        try { 
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();

            if (result.next()) {
                return getFornecedores(result);
            }
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }

        return null;
    }
    
    public String deleteFornecedoresPeloId(int id) {
        String sql = String.format("DELETE FROM Fornecedores WHERE id = %d", id);
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);

            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Fornecedor apagado com sucesso." : "Não foi possível apagar fornecedor";
            
        } catch (SQLException e) {
            
            System.out.println(String.format("Error: %s", e.getMessage()));
            
            if(e.getMessage().startsWith("Cannot delete or update a parent row")) {
                return "Não foi possível apagar - Fornecedor associado ao produto";
            }
            return String.format("Error: %s", e.getMessage());
        }
    }
    
    
    public List<Fornecedores> todosFornecedores() {
        String sql = "SELECT * FROM Fornecedores";
        List<Fornecedores> fornecedores = new ArrayList<>();
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                fornecedores.add(getFornecedores(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return fornecedores;
    }
    
}