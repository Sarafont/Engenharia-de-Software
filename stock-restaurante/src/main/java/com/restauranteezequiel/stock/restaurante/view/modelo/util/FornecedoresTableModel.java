/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.view.modelo.util;

import com.restauranteezequiel.stock.restaurante.modelo.dominio.Fornecedores;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sara
 */
public class FornecedoresTableModel extends AbstractTableModel{
    
    private List<Fornecedores> fornecedores;
    private String [] colunas = {"ID", "DESIGNAÇÃO", "CONTATO", "CONTRIBUINTE", "CODIGO POSTAL", "LOCALIDADE", "MORADA", "EMAIL", "TELEFONE"};

    public FornecedoresTableModel(List<Fornecedores> fornecedores) {
        this.fornecedores = fornecedores;
    }
    
    //retorna número de linhas da tabela
    public int getRowCount() {
        return fornecedores.size();
    }

    //retorna num de colunas
    public int getColumnCount() {
        return colunas.length;
    }
    
    //retorna o valor em cada célula da tabela
    public Object getValueAt(int linha, int coluna) {
        Fornecedores fornecedor = fornecedores.get(linha);
        
        switch(coluna) {
            case 0: return fornecedor.getId();
            case 1: return fornecedor.getDesignacao();
            case 2: return fornecedor.getContato();
            case 3: return fornecedor.getContribuinte();
            case 4: return fornecedor.getCodPostal();
            case 5: return fornecedor.getLocalidade();
            case 6: return fornecedor.getMorada();
            case 7: return fornecedor.getEmail();
            case 8: return fornecedor.getTelefone();
            default: return "";
        }
    }
    
    public String getColumnName(int column) {
        return colunas[column];
    }

    //Define se uma célula específica pode ser editada. 
    //No caso, retorna sempre false, indicando que as células não são editáveis.
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; 
    }

    public List<Fornecedores> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedores> fornecedores) {
        this.fornecedores = fornecedores;
    }

}
