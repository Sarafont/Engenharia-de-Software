/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.view.modelo;

/**
 *
 * @author sara
 */
public class LoginDTO {
    private String utilizador;
    private String senha;

    public LoginDTO(String utilizador, String senha) {
        this.utilizador = utilizador;
        this.senha = senha;
    }
    
    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
