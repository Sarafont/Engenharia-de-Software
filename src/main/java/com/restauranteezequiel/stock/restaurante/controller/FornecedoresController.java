/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.controller;

import com.restauranteezequiel.stock.restaurante.modelo.conexao.Conexao;
import com.restauranteezequiel.stock.restaurante.modelo.conexao.ConexaoMySql;
import com.restauranteezequiel.stock.restaurante.modelo.dao.AutenticacaoDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dao.FornecedoresDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dao.UtilizadorDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Fornecedores;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Utilizador;
import com.restauranteezequiel.stock.restaurante.view.formulario.Dashboard;
import com.restauranteezequiel.stock.restaurante.view.modelo.exception.NegocioException;
import com.restauranteezequiel.stock.restaurante.view.modelo.util.FornecedoresTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author sara
 */
public class FornecedoresController implements ActionListener, MouseListener, KeyListener{
    
    private Conexao conexao;
    private Dashboard dashboard;
    private AutenticacaoDAO autenticacaoDao;
    private FornecedoresDAO fornecedoresDao;
    private UtilizadorDAO utilizadorDao;
    private FornecedoresTableModel fornecedoresTableModel;
    private List<Fornecedores> fornecedores;
    private Fornecedores fornecedor;
    
    public FornecedoresController (Dashboard dashboard){
        this.conexao = new ConexaoMySql();
        this.dashboard = dashboard;
        this.autenticacaoDao = new AutenticacaoDAO();
        this.fornecedoresDao = new FornecedoresDAO();
        this.utilizadorDao = new UtilizadorDAO();
        atualizarTabelaFornecedores(fornecedoresDao.todosFornecedores());
        inicializarComboBoxFornecedorNoProduto();
    }
    
    
    private void inicializarComboBoxFornecedorNoProduto() {
        this.dashboard.getComboBoxProdutoFornecedores().removeAllItems();
        this.dashboard.getComboBoxProdutoFornecedores().addItem("Selecione o fornecedor");
        fornecedores.stream().forEach(c -> {
            this.dashboard.getComboBoxProdutoFornecedores().addItem(c.getDesignacao());
        });
    }
    
    
    private void atualizarTabelaFornecedores(List<Fornecedores> fornecedores) {
        this.fornecedores = fornecedoresDao.todasFornecedores();
        this.fornecedoresTableModel = new FornecedoresTableModel(fornecedores);
        this.dashboard.getTabelaFornecedor().setModel(fornecedoresTableModel);
        this.dashboard.getLabelHomeFornecedores().setText(String.format("%d", fornecedores.size()));
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao) {
            case "adicionar": adicionar(); break;
            case "editar": editar(); break;
            case "apagar": apagar(); break;
            case "salvar": salvar(); break;
            case "limpar": limpar(); break;
            case "cancelar": cancelar(); break;
        }
    }
    
    private void adicionar() {
        Utilizador utilizador = utilizadorLogado();
        if(autenticacaoDao.temPermissao(utilizador)){
            mostrarTelaFornecedor();
        }
    }
    
    private void editar() {
        Utilizador utilizador = utilizadorLogado();
        if(autenticacaoDao.temPermissao(utilizador)){
            System.out.println(this.fornecedor);
            if(this.fornecedor != null) {
                preencherValoresNoFormulario();
                mostrarTelaFornecedor();
            } else {
                JOptionPane.showMessageDialog(dashboard, "Deve selecionar um fornecedor na tabela", "Seleciona um fornecedor", 0);
            }
        }
    }
    
    private Utilizador utilizadorLogado() {
        int utilizadorLogadoId = Integer.parseInt(this.dashboard.getLabelUtilizadorLogadoId().getText());
        return utilizadorDao.buscarUtilizadorPeloId(utilizadorLogadoId);
    }
    
    private void mostrarTelaFornecedor() {
        this.dashboard.getDialogFornecedor().pack();
        this.dashboard.getDialogFornecedor().setLocationRelativeTo(dashboard);
        this.dashboard.getDialogFornecedor().setVisible(true);
    }
    
    
    public void salvar() {
        Fornecedores fornecedorTemp = pegarValoresDoFormulario();
        
        String mensagem = fornecedoresDao.salvar(fornecedorTemp);
        
        if(mensagem.startsWith("Fornecedor")) {
            mensagemNaTela(mensagem, Color.GREEN);
            atualizarTabelaFornecedores(fornecedoresDao.todasFornecedores());
            limpaCampos();
        } else {
            mensagemNaTela(mensagem, Color.RED);
        }
    }
    
    
    private void limpaCampos() {
        this.dashboard.getTxtFornecedorId().setText("0");
        this.dashboard.getTxtFornecedorDesigncao().setText("");
        this.dashboard.getTxtFornecedorContato().setText("");
        this.dashboard.getTxtFornecedorContribuinte().setText("");
        this.dashboard.getTxtFornecedorCodPostal().setText("");
        this.dashboard.getTxtFornecedorLocalidade().setText("");
        this.dashboard.getTxtFornecedorMorada().setText("");
        this.dashboard.getTxtFornecedorEmail().setText("");
        this.dashboard.getTxtFornecedorTelefone().setText("");
        this.fornecedor = null;
        atualizarTabelaFornecedores(fornecedoresDao.todosFornecedores());
        inicializarComboBoxFornecedorNoProduto();
    }
    
    
    private void validacaoDoCampo(String campo) {
        if(campo.isEmpty()) {
            String mensagem = "Deves preencher o campo designação";
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        } 
    }
    
    
    private void mensagemNaTela(String mensagem, Color color) {
       this.dashboard.getLabelFornecedorMensagem().setText(mensagem);
        this.dashboard.getLabelFornecedorMensagem().setBackground(color);
    }
    
    
    private Fornecedores pegarValoresDoFormulario() {
        String idString = this.dashboard.getTxtFornecedorId().getText();
        String designacao = this.dashboard.getTxtFornecedorDesigncao().getText();
        String contato = this.dashboard.getTxtFornecedorContato().getText();
        String contribuinte = this.dashboard.getTxtFornecedorContribuinte().getText();
        String codPostal = this.dashboard.getTxtFornecedorCodPostal().getText();
        String localidade = this.dashboard.getTxtFornecedorLocalidade().getText();
        String morada = this.dashboard.getTxtFornecedorMorada().getText();
        String email = this.dashboard.getTxtFornecedorEmail().getText();
        String telefone = this.dashboard.getTxtFornecedorTelefone().getText();
        
        int id = Integer.parseInt(idString);
        
        validacaoDoCampo(designacao);
        validacaoDoCampo(contato);
        validacaoDoCampo(codPostal);
        validacaoDoCampo(localidade);
        validacaoDoCampo(morada);
        validacaoDoCampo(telefone);
        
        return new Fornecedores(id, designacao, contato, contribuinte, codPostal, localidade, morada, email, telefone);
    }
    
    
    private void preencherValoresNoFormulario() {
        this.dashboard.getTxtFornecedorId().setText(Long.toString(this.fornecedor.getId()));
        this.dashboard.getTxtFornecedorDesigncao().setText(this.fornecedor.getDesignacao());
        this.dashboard.getTxtFornecedorContato().setText(this.fornecedor.getContato());
        this.dashboard.getTxtFornecedorContribuinte().setText(this.fornecedor.getContribuinte());
        this.dashboard.getTxtFornecedorCodPostal().setText(this.fornecedor.getCodPostal());
        this.dashboard.getTxtFornecedorLocalidade().setText(this.fornecedor.getLocalidade());
        this.dashboard.getTxtFornecedorMorada().setText(this.fornecedor.getMorada());
        this.dashboard.getTxtFornecedorEmail().setText(this.fornecedor.getEmail());
        this.dashboard.getTxtFornecedorTelefone().setText(this.fornecedor.getTelefone());
    }
    
    
    private void apagar() {
        Utilizador utilizador = utilizadorLogado();
        if(autenticacaoDao.temPermissao(utilizador)){
            if(this.fornecedor != null) {
                int confirmar = JOptionPane.showConfirmDialog(dashboard, 
                        String.format("Tem certeza que deseja apagar? \nNome: %s", this.fornecedor.getDesignacao()), 
                        "Apagar fornecedor", JOptionPane.YES_NO_OPTION);
                
                    if(confirmar == JOptionPane.YES_OPTION) {
                        String mensagem = fornecedoresDao.deleteFornecedoresPeloId(this.fornecedor.getId());
                        JOptionPane.showMessageDialog(dashboard, mensagem);
                        limpaCampos();
                    }
            } else {
                JOptionPane.showMessageDialog(dashboard, "Deve selecionar um fornecedor na tabela", "Seleciona um fornecedor", 0);
            }
        }
    }
    
    
     private void limpar() {
        limpaCampos();
        mensagemNaTela("", Color.WHITE);
    }
     
     private void cancelar() {
        this.dashboard.getDialogFornecedor().setVisible(false);
        this.dashboard.getDialogProduto().setVisible(true);
        limpar();
    }
    
    public void mouseClicked(MouseEvent me) {
        int linhaSelecionada = this.dashboard.getTabelaFornecedor().getSelectedRow();
        this.fornecedor = this.fornecedoresTableModel.getFornecedores().get(linhaSelecionada);
        preencherValoresNoFormulario();
    }

    public void mousePressed(MouseEvent me) {}

    public void mouseReleased(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {}

    public void mouseExited(MouseEvent me) {}

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {
        String pesquisar = this.dashboard.getTxtFornecedoresPesquisar().getText();
        
        if(pesquisar.isEmpty()) {
            atualizarTabelaFornecedores(fornecedoresDao.todosFornecedores());
        } else {
            List<Fornecedores> fornecedorTemp = this.fornecedoresDao.todosFornecedores()
                    .stream()
                    .filter((Fornecedores f) -> {
                        return f.getDesignacao().toLowerCase().contains(pesquisar.toLowerCase());
                    })
                    .collect(Collectors.toList());
            
            atualizarTabelaFornecedores(fornecedorTemp);
        }
    }
  
}
