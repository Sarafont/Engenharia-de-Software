/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.view.modelo.util;

import com.restauranteezequiel.stock.restaurante.modelo.dominio.Utilizador;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/*
É uma implementação específica de um TableModel utilizado em interfaces gráficas Java (como o JTable), especialmente quando se trabalha com o padrão de 
projeto MVC (Model-View-Controller).
O objetivo principal desta classe é fornecer uma estrutura de dados que permite a exibição e manipulação de uma lista de utilizadores numa tabela.
*/


/**
 *
 * @author sara
 */
public class UtilizadorTableModel extends AbstractTableModel{
    
    private List<Utilizador> utilizadores;
    private String [] colunas = {"ID", "NOME", "USERNAME", "TIPO DE UTILIZADOR", "ESTADO", "ULTIMO LOGIN"};

    public UtilizadorTableModel(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }
    
    //retorna número de linhas da tabela
    public int getRowCount() {
        return utilizadores.size();
    }

    //retorna num de colunas
    public int getColumnCount() {
        return colunas.length;
    }

    //retorna o valor em cada célula da tabela
    public Object getValueAt(int linha, int coluna) {
        Utilizador utilizador = utilizadores.get(linha);
        
        switch(coluna) {
            case 0: return utilizador.getId();
            case 1: return utilizador.getNome();
            case 2: return utilizador.getUsername();
            case 3: return utilizador.getTipo_utilizador();
            case 4: return utilizador.isEstado();
            case 5: return utilizador.getUltimo_login();
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

    public List<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }
}
