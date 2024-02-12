/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.controller;

import com.restauranteezequiel.stock.restaurante.modelo.conexao.Conexao;
import com.restauranteezequiel.stock.restaurante.modelo.conexao.ConexaoMySql;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author sara
 */
public class Main {
    
    public static void main(String[] args) throws SQLException{
       String sql = "select * from Utilizador";
        
       Conexao conexao = new ConexaoMySql();
       
       ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
       
       while (result.next()) {
           System.out.println(result.getString("nome"));
       }
       
    }
    
    
}
