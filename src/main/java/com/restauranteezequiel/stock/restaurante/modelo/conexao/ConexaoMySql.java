/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.modelo.conexao;

import java.sql.Connection; 
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author sara
 */
public class ConexaoMySql implements Conexao {
    
    private Connection connection;
    private final String Utilizador = "root";
    private final String Senha = "Sara123_";
    private final String URL = "jdbc:mysql://localhost/restaurante_Ezekiel?useTimezone=true&serverTimezone=Europe/Lisbon";
    
    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public Connection obterConexao() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(URL, Utilizador, Senha);
        }
        return connection;
    }
    
    public void fecharConexao() throws SQLException {
        if(connection != null)
            connection.close();
    }
    
}
