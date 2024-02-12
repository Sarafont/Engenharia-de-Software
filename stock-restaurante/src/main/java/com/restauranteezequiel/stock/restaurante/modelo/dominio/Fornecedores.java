/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.modelo.dominio;

import java.util.Objects;

/**
 *
 * @author sara
 */
public class Fornecedores {
    
    private int id;
    private String designacao;
    private String contato;
    private String contribuinte;
    private String codPostal;
    private String localidade;
    private String morada;
    private String email;
    private String telefone;
    
    public Fornecedores(){
    }

    public Fornecedores(int id, String designacao, String contato, String contribuinte, String codPostal, String localidade, String morada, String email, String telefone) {
        this.id = id;
        this.designacao = designacao;
        this.contato = contato;
        this.contribuinte = contribuinte;
        this.codPostal = codPostal;
        this.localidade = localidade;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(String contribuinte) {
        this.contribuinte = contribuinte;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.designacao);
        hash = 17 * hash + Objects.hashCode(this.contato);
        hash = 17 * hash + Objects.hashCode(this.contribuinte);
        hash = 17 * hash + Objects.hashCode(this.codPostal);
        hash = 17 * hash + Objects.hashCode(this.localidade);
        hash = 17 * hash + Objects.hashCode(this.morada);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.telefone);
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
        final Fornecedores other = (Fornecedores) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.designacao, other.designacao)) {
            return false;
        }
        if (!Objects.equals(this.contato, other.contato)) {
            return false;
        }
        if (!Objects.equals(this.codPostal, other.codPostal)) {
            return false;
        }
        if (!Objects.equals(this.localidade, other.localidade)) {
            return false;
        }
        if (!Objects.equals(this.morada, other.morada)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.contribuinte, other.contribuinte);
    }
    
    
    
}
