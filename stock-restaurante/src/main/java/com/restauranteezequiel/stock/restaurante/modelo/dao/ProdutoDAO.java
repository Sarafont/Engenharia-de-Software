/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.modelo.dao;

import com.restauranteezequiel.stock.restaurante.modelo.conexao.Conexao;
import com.restauranteezequiel.stock.restaurante.modelo.conexao.ConexaoMySql;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Categoria;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Fornecedores;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Produto;
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
public class ProdutoDAO {
    private final Conexao conexao;
    
    public ProdutoDAO() {
        this.conexao = new ConexaoMySql();
    }
    
    public String salvar(Produto produto) {
        String resultado;
        if (produto.getId() == 0){
            resultado = adicionar(produto);
        } else {
            resultado = editar(produto);
        }
        return resultado;
    }
    
    
    private String adicionar(Produto produto) {
        String sql = "INSERT INTO Produto (nome, descricao, preco_unitario, quantidade, categoria_id, fornecedor_id, utilizador_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        Produto produtoTemp = buscarProdutoPeloNome(produto.getDescricao());
        
        if(produtoTemp != null) {
            return String.format("Error: %s já existe na base de dados", produto.getDescricao());
        }
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);

            preencherValoresPreparedStatement(preparedStatement, produto);

            int resultado = preparedStatement.executeUpdate();
            return resultado == 1 ? "Produto adicionado com sucesso." : "Não possível adicionar a produto.";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
        
    }

    
    private String editar(Produto produto) {
        String sql = "UPDATE Produto SET nome = ?, descricao = ?, preco_unitario = ?, quantidade = ?, categoria_id = ?, fornecedor_id = ?, utilizador_id = ?  WHERE id = ?";
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedStatement, produto);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Produto editado com sucesso." : "Não foi possível editar produto";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    
    
    public String actualizarQuantidade(int idProduto, int quantidade, int utilizadorId) {
        String sql = "UPDATE Produto SET quantidade = ?, utilizador_id = ? WHERE id  = ?";
        System.out.println("Uso: " + idProduto + "qtd: " +quantidade + "Utilizador: "+utilizadorId);
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preparedStatement.setInt(1, quantidade);
            preparedStatement.setLong(2, utilizadorId);
            preparedStatement.setLong(3, idProduto);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Quantidade do produto editada com sucesso" : "Não foi possivel editar quantidade do produto";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    
    
    private void preencherValoresPreparedStatement(PreparedStatement preparedStatement, Produto produto) throws SQLException {
        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setString(2, produto.getDescricao());
        preparedStatement.setDouble(3, produto.getPreco_unitario());
        preparedStatement.setInt(4, produto.getQuantidade());
        preparedStatement.setInt(5, produto.getCategoria_id().getId());
        preparedStatement.setInt(6, produto.getFornecedor_id().getId());
        preparedStatement.setInt(7, produto.getUtilizador_id().getId());

        if (produto.getId() != 0) {
            preparedStatement.setInt(8, produto.getId());
        }
    }

    
    
    public List<Produto> todosProdutos() {
        String sql = "SELECT * FROM Produto p, Categoria c, Fornecedores f, Utilizador u WHERE p.categoria_id = c.id AND p.fornecedor_id = f.id AND p.utilizador_id = u.id";
        List<Produto> produtos = new ArrayList<>();
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                produtos.add(getProduto(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return produtos;
    }
    
    
    public Produto buscarProdutoPeloId(int id) {
        String sql = String.format("SELECT * FROM Produto p, Categoria c, Fornecedores f, Utilizador u WHERE p.categoria_id = c.id AND p.fornecedor_id = f.id AND p.utilizador_id = u.id AND p.id = %d", id);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if(result.next()) {
                return getProduto(result);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return null;
    }
    
    
    public List<Produto> buscarProdutosPeloCategoria(String categoria) {
        String sql = String.format("SELECT * FROM Produto p, Categoria c, Fornecedores f, Utilizador u WHERE p.categoria_id = c.id AND Fornecedores f, Utilizador u WHERE p.categoria_id = c.id AND p.fornecedor_id = f.id AND p.utilizador_id = u.id AND c.nome = '%s'", categoria);
        List<Produto> produtos = new ArrayList<>();
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                 produtos.add(getProduto(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return produtos;
    }
    
    public List<Produto> buscarProdutosPeloFornecedor (String fornecedor) {
        String sql = String.format("SELECT * FROM Produto p, Categoria c, Fornecedores f, Utilizador u WHERE p.fornecedor_id = f.id AND Categoria c, Utilizador u WHERE p.categoria_id = c.id AND p.fornecedor_id = f.id AND p.utilizador_id = u.id AND c.nome = '%s'", fornecedor);
        List<Produto> produtos = new ArrayList<>();
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                 produtos.add(getProduto(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return produtos;
    }
    
    
    public Produto buscarProdutoPeloNome(String nome) {
        String sql = String.format("SELECT * FROM Produto p, Categoria c, Fornecedores f, Utilizador u WHERE p.categoria_id = c.id AND p.fornecedor_id AND p.utilizador_id = u.id AND p.nome = '%s'", nome);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if(result.next()) {
                return getProduto(result);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return null;
    }
    
    
    private Produto getProduto(ResultSet result) throws SQLException {
        Produto produto = new Produto();
        Categoria categoria = new Categoria();
        Utilizador utilizador = new Utilizador();
        Fornecedores fornecedor = new Fornecedores();
        
        categoria.setId(result.getInt("c.id"));
        categoria.setDescricao(result.getString("c.descricao"));
        
        utilizador.setId(result.getInt("u.id"));
        utilizador.setNome(result.getString("u.nome"));
        
        fornecedor.setId(result.getInt("f.id"));
        fornecedor.setContato(result.getString("f.contato"));
        
        produto.setId(result.getInt("p.id"));
        produto.setNome(result.getString("p.nome"));
        produto.setDescricao(result.getString("p.descricao"));
        produto.setPreco_unitario(result.getDouble("p.preco_unitario"));
        produto.setQuantidade(result.getInt("p.quantidade"));
        produto.setData_hora_registo(result.getObject("p.data_hora_registo", LocalDateTime.class));
        produto.setCategoria_id(categoria);
        produto.setFornecedor_id(fornecedor);
        produto.setUtilizador_id(utilizador);

        return produto;
    }
    
    
    public String deletaProdutoPeloId(int id) {
        String sql = String.format("DELETE FROM Produto WHERE id = %d", id);
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Produto apagado com sucesso" : "Não foi possível apagar produto";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    
}
