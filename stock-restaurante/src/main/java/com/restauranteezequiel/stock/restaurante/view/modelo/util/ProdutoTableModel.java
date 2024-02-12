package com.restauranteezequiel.stock.restaurante.view.modelo.util;


import com.restauranteezequiel.stock.restaurante.modelo.dominio.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sara
 */
public class ProdutoTableModel extends AbstractTableModel{
    
    private List<Produto> produtos;
    private final String [] colunas = {"ID", "NOME", "DESCRIÇÃO","PREÇO UNITÁRIO", "QUANTIDADE", "CATEGORIA", "FORNECEDOR", "UTILIZADOR QUE INSERIU", "DATA"};
    
    public ProdutoTableModel(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Produto produto = produtos.get(linha);
        
        switch(coluna) {
            case 0: return produto.getId();
            case 1: return produto.getNome();
            case 2: return produto.getDescricao();
            case 3: return produto.getPreco_unitario();
            case 4: return produto.getQuantidade();
            case 5: return produto.getCategoria_id().getDescricao();
            case 6: return produto.getFornecedor_id().getDesignacao();
            case 7: return produto.getUtilizador_id().getNome();
            case 8: return produto.getData_hora_registo();
            default: return "";
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}
