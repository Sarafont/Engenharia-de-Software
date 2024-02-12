/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.modelo.dao;

import com.restauranteezequiel.stock.restaurante.modelo.conexao.Conexao;
import com.restauranteezequiel.stock.restaurante.modelo.conexao.ConexaoMySql;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Categoria;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Utilizador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sara
 */
public class CategoriaDAO {
    
    //chamar a conexao interface
    private final Conexao conexao;

    public CategoriaDAO() {
        this.conexao = new ConexaoMySql();
    }
    
    public String salvar(Categoria categoria) {
        String resultado;
        if (categoria.getId() == 0){
            resultado = adicionar(categoria);
        } else {
            resultado = editar(categoria);
        }
        return resultado;
    }

    private String adicionar(Categoria categoria) {
        String sql = "INSERT INTO Categoria (descricao) VALUES(?)";
        
        Categoria categoriaTemp = buscarCategoriaPeloDescricao(categoria.getDescricao());
        
        if(categoriaTemp != null) {
            return String.format("Error: %s já existe na base de dados", categoria.getDescricao());
        }
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);

            preencherValoresPreparedStatement(preparedStatement, categoria);

            int resultado = preparedStatement.executeUpdate();
            return resultado == 1 ? "Categoria adicionada com sucesso." : "Não possível adicionar a categoria.";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
        
    }

    private String editar(Categoria categoria) {
        String sql = "UPDATE Categoria SET descricao = ? WHERE id = ?";
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedStatement, categoria);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Categoria editada com sucesso." : "Não foi possível editar categoria";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    public Categoria buscarCategoriaPeloDescricao(String descricao) {
        String sql = String.format("SELECT * FROM Categoria WHERE descricao = '%s'", descricao);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();

            if (result.next()) {
                return getCategoria(result);
            }
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }

        return null;
    }
    

    private void preencherValoresPreparedStatement(PreparedStatement preparedStatement, Categoria categoria) throws SQLException {
        preparedStatement.setString(1, categoria.getDescricao());
        
        if(categoria.getId() != 0) {
            preparedStatement.setInt(2, categoria.getId());
        }
    }

    private Categoria getCategoria(ResultSet result) throws SQLException {
        Categoria categoria = new Categoria();
        
        categoria.setId((int) result.getInt("id"));
        categoria.setDescricao(result.getString("descricao"));

        return categoria;
    }
    
    public List<Categoria> todasCategorias() {
        String sql = "SELECT * FROM Categoria";
        
        List<Categoria> categorias = new ArrayList<>();

        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();

            while (result.next()) {
                categorias.add(getCategoria(result));
            }
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }

        return categorias;
    }
    
    

    public Categoria buscarCategoriaPeloId(int id) {
        String sql = String.format("SELECT * FROM Categoria WHERE id = %d", id);
        
        try { 
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();

            if (result.next()) {
                return getCategoria(result);
            }
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }

        return null;
    }
    
    public String deleteCategoriaPeloId(int id) {
        String sql = String.format("DELETE FROM Categoria WHERE id = %d", id);
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);

            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Categoria apagada com sucesso." : "Não foi possível apagar categoria";
            
        } catch (SQLException e) {
            
            System.out.println(String.format("Error: %s", e.getMessage()));
            
            if(e.getMessage().startsWith("Cannot delete or update a parent row")) {
                return "Não foi possível apagar - Categoria associado ao produto";
            }
            return String.format("Error: %s", e.getMessage());
        }
    }
    
    
     public List<Categoria> todosCategria() {
        String sql = "SELECT * FROM Categoria";
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                categorias.add(getCategoria(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return categorias;
    }
    
    
}
