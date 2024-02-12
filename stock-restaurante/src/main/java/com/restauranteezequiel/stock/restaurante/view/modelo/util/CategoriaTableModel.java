/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.view.modelo.util;

import com.restauranteezequiel.stock.restaurante.modelo.dominio.Categoria;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sara
 */
public class CategoriaTableModel  extends AbstractTableModel{
    
    private List<Categoria> categorias;
    private String [] colunas = {"ID", "DESCRICAO"};

    public CategoriaTableModel(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    

    @Override
    public int getRowCount() {
        return categorias.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Categoria categoria = categorias.get(linha);
        
        switch(coluna) {
            case 0: return categoria.getId();
            case 1: return categoria.getDescricao();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
}
