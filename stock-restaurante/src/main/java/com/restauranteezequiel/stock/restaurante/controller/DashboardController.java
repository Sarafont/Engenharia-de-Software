/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.controller;

import com.restauranteezequiel.stock.restaurante.modelo.dao.AutenticacaoDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dao.ProdutoDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dao.UtilizadorDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Produto;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Utilizador;
import com.restauranteezequiel.stock.restaurante.view.formulario.Dashboard;
import com.restauranteezequiel.stock.restaurante.view.modelo.util.ProdutoTableModel;
import com.restauranteezequiel.stock.restaurante.view.modelo.util.UtilizadorTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author sara
 */
public class DashboardController implements ActionListener{
    
    private Dashboard dashboard;
    private UtilizadorDAO utilizadorDao;
    private UtilizadorTableModel utilizadorTableModel;
    private ProdutoTableModel produtoTableModel;
    private ProdutoDAO produtoDao;
    private RelatorioController relatorioController;
    private AutenticacaoDAO autenticacaoDao;

    public DashboardController(Dashboard dashboard) {
        this.dashboard = dashboard;
        this.utilizadorDao = new UtilizadorDAO();
        this.produtoDao = new ProdutoDAO();
        this.autenticacaoDao = new AutenticacaoDAO();
        relatorioController = new RelatorioController(this.dashboard);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao) {
            case "home": 
                panelHome(); 
                break;
            case "fornecedores": 
                panelFornecedores(); 
                break;
            case "produtos": panelProdutos(); break;
            case "categorias": panelCategorias(); break;
            case "utilizadores": panelUtilizadores(); break;
            case "relatório": emiteRelatorio(); break;
            case "sair": sair(); break;            
        }
    }
    
    //Método para o relatório
    private void actualizarLabels() {
        LocalDateTime dataAtual = LocalDateTime.now();
        dashboard.getDataEmissao().setText(dataAtual.toString());

        int totalProdutos = produtoDao.todosProdutos().size();
        dashboard.getTotalProdutosStock().setText(Integer.toString(totalProdutos));
    }
    
    private void emiteRelatorio(){
        Utilizador u = utilizadorLogado();
        if(autenticacaoDao.temPermissaoChefe(u)){
            actualizarLabels();
            relatorioController.abrirDialogRelatorio();
        }
    }
    
    private Utilizador utilizadorLogado() {
        int utilizadorLogadoId = Integer.parseInt(this.dashboard.getLabelUtilizadorLogadoId().getText());
        return utilizadorDao.buscarUtilizadorPeloId(utilizadorLogadoId);
    }
    
    private void ordenarTabelaProdutoPorIdCrescente() {
        List<Produto> produtos = produtoTableModel.getProdutos();
        Collections.sort(produtos, Comparator.comparing(Produto::getId));
        produtoTableModel.fireTableDataChanged();
    }
    
    
    private void painelComponentes(JPanel panel) {
        this.dashboard.getPanelBody().removeAll();
        this.dashboard.getPanelBody().repaint();
        this.dashboard.getPanelBody().revalidate();
        this.dashboard.getPanelBody().add(panel);
        this.dashboard.getPanelBody().repaint();
        this.dashboard.getPanelBody().revalidate();
    }

    
    private void panelFornecedores() {
        painelComponentes(this.dashboard.getPanelFornecedores());
    }
    
    
    private void panelProdutos() {
        painelComponentes(this.dashboard.getPanelProduto());
    }
    
    
    private void sair() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem a certeza que deseja sair?","Sair do login", JOptionPane.YES_NO_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION) System.exit(0);
    }

    
    private void panelUtilizadores() {
        painelComponentes(this.dashboard.getPanelUtilizador());
    }
    
    
    private void panelCategorias() {
        painelComponentes(this.dashboard.getPanelCategorias());
    }

    private void panelHome() {
        painelComponentes(this.dashboard.getPanelHome());
    }
}
