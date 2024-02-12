/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.modelo.dao;

import com.restauranteezequiel.stock.restaurante.modelo.dominio.Utilizador;

/**
 *
 * @author sara
 */
public class teste {
    
    public static void main(String args[]){
        Utilizador utilizador = new Utilizador(6, "Jorge", "Funcionario", "jorge006", "F3245", null);
    
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        String mensagem = utilizadorDAO.salvar(utilizador);
        System.out.println(mensagem);
    }
    
}
