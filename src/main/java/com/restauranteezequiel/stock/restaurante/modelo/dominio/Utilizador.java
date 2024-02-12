/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.modelo.dominio;
import java.time.LocalDateTime;
import java.util.Objects;
/**
 *
 * @author sara
 */
public class Utilizador {
    
    private int id;
    private String nome;
    private String tipo_utilizador;
    private String username;
    private String senha;
    private boolean estado;
    private LocalDateTime ultimo_login;
    
    public Utilizador() {
        this.estado = true;
    }


    public Utilizador(int id, String nome, String tipo_utilizador, String username, String senha, LocalDateTime ultimo_login) {
        this.id = id;
        this.nome = nome;
        this.tipo_utilizador = tipo_utilizador;
        this.username = username;
        this.senha = senha;
        this.ultimo_login = ultimo_login;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_utilizador() {
        return tipo_utilizador;
    }

    public void setTipo_utilizador(String tipo_utilizador) {
        this.tipo_utilizador = tipo_utilizador;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void mudarEstado() {
        this.estado = !this.estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getUltimo_login() {
        return ultimo_login;
    }

    public void setUltimo_login(LocalDateTime ultimo_login) {
        this.ultimo_login = ultimo_login;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.tipo_utilizador);
        hash = 89 * hash + Objects.hashCode(this.senha);
        hash = 89 * hash + (this.estado ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.ultimo_login);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilizador other = (Utilizador) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tipo_utilizador, other.tipo_utilizador)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return Objects.equals(this.ultimo_login, other.ultimo_login);
    }
 
}
