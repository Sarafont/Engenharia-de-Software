/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.controller;

import com.restauranteezequiel.stock.restaurante.modelo.conexao.Conexao;
import com.restauranteezequiel.stock.restaurante.modelo.conexao.ConexaoMySql;
import com.restauranteezequiel.stock.restaurante.modelo.dao.AutenticacaoDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dao.CategoriaDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dao.FornecedoresDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dao.ProdutoDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dao.UtilizadorDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Fornecedores;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Produto;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Utilizador;
import com.restauranteezequiel.stock.restaurante.view.formulario.Dashboard;
import com.restauranteezequiel.stock.restaurante.view.modelo.util.ProdutoTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sara
 */
public class RelatorioController implements ActionListener, MouseListener, KeyListener{
    private Conexao conexao;
    private Dashboard dashboard;
    private DashboardController dashboardController;
    private AutenticacaoDAO autenticacaoDao;
    private UtilizadorDAO utilizadorDao;
    private CategoriaDAO categoriaDao;
    private FornecedoresDAO fornecedoresDao;
    private ProdutoDAO produtoDao;
    private ProdutoTableModel produtoTableModel;
    private Produto produto;
    
    public RelatorioController(Dashboard dashboard){
        this.conexao = new ConexaoMySql();
        this.utilizadorDao = new UtilizadorDAO();
        this.autenticacaoDao = new AutenticacaoDAO();
        this.dashboard = dashboard;
        this.dashboardController = dashboardController;
        this.categoriaDao = new CategoriaDAO();
        this.produtoDao = new ProdutoDAO();
        this.fornecedoresDao = new FornecedoresDAO();
        
        actualizarTabela(produtoDao.todosProdutos());
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        System.out.println("ENTROU NO ACTION");
        Utilizador usuario = utilizadorLogado();
        if(autenticacaoDao.temPermissao(usuario)){

            DefaultTableModel modeloTabela = new DefaultTableModel();
            modeloTabela.setColumnIdentifiers(new String[]{"ID", "Nome", "Descrição", "Preço", "Quantidade", "Categoria", "Fornecedor"});

            List<Produto> produtos = produtoDao.todosProdutos();
            for (Produto produto : produtos) {
                Object[] linha = new Object[]{
                    produto.getId(),
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco_unitario(),
                    produto.getQuantidade(),
                    produto.getCategoria_id().getDescricao(),
                    produto.getFornecedor_id().getDesignacao()
                };
                modeloTabela.addRow(linha);
            }

            this.dashboard.getTabelaProdutoRel().setModel(modeloTabela);
        }
    }
    
    public void abrirDialogRelatorio() {
        this.dashboard.getDialogRelatorio().pack();
        this.dashboard.getDialogRelatorio().setLocationRelativeTo(dashboard);
        this.dashboard.getDialogRelatorio().setVisible(true);
    }
    
    
    //Para verificar a permissão
    private Utilizador utilizadorLogado() {
        int utilizadorLogadoId = Integer.parseInt(this.dashboard.getLabelUtilizadorLogadoId().getText());
        return utilizadorDao.buscarUtilizadorPeloId(utilizadorLogadoId);
    }
    
    
    private void actualizarTabela(List<Produto> produtos) {
        this.produtoTableModel = new ProdutoTableModel(produtos);
        
        for (Produto p : produtos) {
            Fornecedores fornecedor = fornecedoresDao.buscarFornecedoresPeloId(p.getFornecedor_id().getId());
            p.setFornecedor_id(fornecedor);
        }
        
        this.dashboard.getTabelaProdutoRel().setModel(produtoTableModel);
        this.dashboard.getLabelHomeProduto().setText(String.format("%d", produtos.size()));
        
    }
    

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("O botão foi clicado!");

        LocalDateTime dataAtual = LocalDateTime.now();
        this.dashboard.getDataEmissao().setText(dataAtual.toString());

        int totalProdutos = produtoDao.todosProdutos().size();
        this.dashboard.getTotalProdutosStock().setText(Integer.toString(totalProdutos));

        // Atualizar a tabela com os produtos
        this.actualizarTabela(produtoDao.todosProdutos());

        // Abrir a janela de diálogo do relatório
        this.abrirDialogRelatorio();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
