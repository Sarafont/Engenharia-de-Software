/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.modelo.dominio;

import java.util.Objects;
import java.time.LocalDateTime;


/**
 *
 * @author sara
 */
public class Produto {
    
    private int id;
    private String nome;
    private String descricao;
    private double preco_unitario;
    private int quantidade;
    private Categoria categoria_id;
    private Fornecedores fornecedor_id;
    private Utilizador utilizador_id;
    private LocalDateTime data_hora_registo;
    
    public Produto(){}

    public Produto(int id, String nome, String descricao, double preco_unitario, int quantidade, Categoria categoria_id, Fornecedores fornecedor_id, Utilizador utilizador_id, LocalDateTime data_hora_registo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_unitario = preco_unitario;
        this.quantidade = quantidade;
        this.categoria_id = categoria_id;
        this.fornecedor_id = fornecedor_id;
        this.utilizador_id = utilizador_id;
        this.data_hora_registo = data_hora_registo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Categoria categoria_id) {
        this.categoria_id = categoria_id;
    }

    public Fornecedores getFornecedor_id() {
        return fornecedor_id;
    }

    public void setFornecedor_id(Fornecedores fornecedor_id) {
        this.fornecedor_id = fornecedor_id;
    }

    public Utilizador getUtilizador_id() {
        return utilizador_id;
    }

    public void setUtilizador_id(Utilizador utilizador_id) {
        this.utilizador_id = utilizador_id;
    }

    public LocalDateTime getData_hora_registo() {
        return data_hora_registo;
    }

    public void setData_hora_registo(LocalDateTime data_hora_registo) {
        this.data_hora_registo = data_hora_registo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.descricao);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.preco_unitario) ^ (Double.doubleToLongBits(this.preco_unitario) >>> 32));
        hash = 53 * hash + this.quantidade;
        hash = 53 * hash + Objects.hashCode(this.categoria_id);
        hash = 53 * hash + Objects.hashCode(this.fornecedor_id);
        hash = 53 * hash + Objects.hashCode(this.utilizador_id);
        hash = 53 * hash + Objects.hashCode(this.data_hora_registo);
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
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco_unitario) != Double.doubleToLongBits(other.preco_unitario)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.categoria_id, other.categoria_id)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor_id, other.fornecedor_id)) {
            return false;
        }
        if (!Objects.equals(this.utilizador_id, other.utilizador_id)) {
            return false;
        }
        return Objects.equals(this.data_hora_registo, other.data_hora_registo);
    }
    
 
}
