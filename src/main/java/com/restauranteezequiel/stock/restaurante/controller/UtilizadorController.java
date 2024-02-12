/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.controller;

import com.restauranteezequiel.stock.restaurante.modelo.dao.AutenticacaoDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dao.UtilizadorDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Utilizador;
import com.restauranteezequiel.stock.restaurante.view.formulario.Dashboard;
import com.restauranteezequiel.stock.restaurante.view.modelo.exception.NegocioException;
import com.restauranteezequiel.stock.restaurante.view.modelo.util.UtilizadorTableModel;
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
public class UtilizadorController implements ActionListener, MouseListener, KeyListener {
    
    private Dashboard dashboard;
    private AutenticacaoDAO autenticacaoDao;
    private UtilizadorTableModel utilizadorTableModel;
    private UtilizadorDAO utilizadorDao;
    private Utilizador utilizador;
    
    
    public UtilizadorController(Dashboard dashboard) {
        this.dashboard = dashboard;
        this.autenticacaoDao = new AutenticacaoDAO();
        this.utilizadorDao = new UtilizadorDAO();
        inicializaComboBoxTipoUtilizador();
        actualizarTabelaUtilizador(utilizadorDao.todosUtilizadores());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao) {
            case "adicionar": adicionar(); break;
            case "editar": editar(); break;
            case "apagar": remover(); break;
            case "salvar": salvar(); break;
            case "cancelar": ocultaTelaUtilizador(); break;
        }
    }

    private void inicializaComboBoxTipoUtilizador() {
        this.dashboard.getComboBoxUtilizadorTipoUtilizador().removeAll();
        this.dashboard.getComboBoxUtilizadorTipoUtilizador().addItem("Seleciona o tipo de utilizador");
        
        
        if(this.utilizador != null) {
            this.dashboard.getComboBoxUtilizadorTipoUtilizador().addItem(this.utilizador.getTipo_utilizador());
        }
    }
    
    private void mostrarTelaUtilizador() {
        this.dashboard.getDialogUtilizador().pack();
        this.dashboard.getDialogUtilizador().setLocationRelativeTo(dashboard);
        this.dashboard.getDialogUtilizador().setVisible(true);
    }
    
    private void ocultaTelaUtilizador() {
        this.dashboard.getDialogUtilizador().pack();
        this.dashboard.getDialogUtilizador().setLocationRelativeTo(dashboard);
        this.dashboard.getDialogUtilizador().setVisible(false);
        limpaCampos();
        mensagemNaTela("", Color.WHITE);
    }
    
    //FEITO
    private Utilizador utilizadorLogado() {
        int utilizadorLogadoId = Integer.valueOf(this.dashboard.getLabelUtilizadorLogadoId().getText());
        return utilizadorDao.buscarUtilizadorPeloId(utilizadorLogadoId);
    }

    //FEITO
    private void adicionar() {
        Utilizador utilizadorLogado = utilizadorLogado();
        if(autenticacaoDao.temPermissao(utilizadorLogado)) 
            mostrarTelaUtilizador();
    }

    //FEITO
    private void editar() {
        Utilizador utilizadorLogado = utilizadorLogado();
        if(autenticacaoDao.temPermissao(utilizadorLogado)) {
            if(this.utilizador != null) {
                preencherOsValoresNoFormularioUtilizador();
                mostrarTelaUtilizador();
            } else {
                JOptionPane.showMessageDialog(dashboard, "Deve selecionar um utilizador na tabela", "Selecione um utilizador", 0);
            }
        }
            
    }

    //FEITO
    private void remover() {
        Utilizador utilizadorLogado = utilizadorLogado();
        if(autenticacaoDao.temPermissao(utilizadorLogado)) {
            if(this.utilizador != null) {
                if(this.utilizador.equals(utilizadorLogado)) {
                    JOptionPane.showMessageDialog(dashboard, "Utilizador logado não pode ser removido", "Utilizador logado", 0);
                } else {
                    int confirmar = JOptionPane.showConfirmDialog(dashboard, 
                        String.format("Tem a certeza que deseja apagar? \nNome: %s", this.utilizador.getNome()), 
                        "Apagar utilizador", JOptionPane.YES_NO_OPTION);
                
                    if(confirmar == JOptionPane.YES_OPTION) {
                        String mensagem = utilizadorDao.deleteUtilizadorPeloId(this.utilizador.getId());
                        JOptionPane.showMessageDialog(dashboard, mensagem);
                        limpaCampos();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(dashboard, "Deve selecionar um utilizador na tabela", "Selecione um utilizador", 0);
            }
        }
    }
    
    //FALTA VER OS MÉTODOS
    private void limpaCampos(){
        this.dashboard.getTxtUtilizadorId().setText("0");
        this.dashboard.getTxtUtilizadorNome().setText("");
        this.dashboard.getTxtUtilizadorUsername().setText("");
        this.dashboard.getTxtUtilizadorSenha().setText("");
        this.dashboard.getComboBoxUtilizadorTipoUtilizador().setSelectedIndex(0);
        this.dashboard.getRadioBotaoAtivo().setSelected(true);
        actualizarTabelaUtilizador(utilizadorDao.todosUtilizadores());
        this.utilizador = null;
    }
    
    //FEITO
    private void validacaoDosCampos(String campo, String nomeDaVariavel) {
        if(campo.isEmpty()) {
            String mensagem = String.format("Deve preencher o campo %s", nomeDaVariavel);
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }        
    }
    
    //FALTA VER O MÉTODO GETSELECTEDINDEX
    private void validacaoDoPerfil() {
        if(this.dashboard.getComboBoxUtilizadorTipoUtilizador().getSelectedIndex() == 0) {
            String mensagem = "Deves preencher o perfil";
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }
    }
    
    
    //FEITO FALTA VER OS MÉTODOS GET
    private void preencherOsValoresNoFormularioUtilizador() {
        this.dashboard.getTxtUtilizadorId().setText(Integer.toString(this.utilizador.getId())); 
        this.dashboard.getTxtUtilizadorNome().setText(this.utilizador.getNome());
        this.dashboard.getTxtUtilizadorUsername().setText(this.utilizador.getUsername());
        this.dashboard.getTxtUtilizadorSenha().setText("");
        this.dashboard.getComboBoxUtilizadorTipoUtilizador().setSelectedItem(this.utilizador.getTipo_utilizador());
        
        if(utilizador.isEstado()) {
            this.dashboard.getRadioBotaoAtivo().setSelected(true);
        }else{
            this.dashboard.getRadioBotaoDesativo().setSelected(true);
        }
    }
    
    // FEITO => VER METODOS GET
    private Utilizador pegarOsValoresDoFormularioUtilizador() {
        String idString = this.dashboard.getTxtUtilizadorId().getText();
        String nome = this.dashboard.getTxtUtilizadorNome().getText();
        String username = this.dashboard.getTxtUtilizadorUsername().getText();
        String senha = this.dashboard.getTxtUtilizadorSenha().getText();
        String tipo_utilizador = this.dashboard.getComboBoxUtilizadorTipoUtilizador().getSelectedItem().toString();
         
        
        int id = Integer.valueOf(idString);
        
        validacaoDosCampos(nome, "nome");
        validacaoDosCampos(username, "username");
        validacaoDosCampos(senha, "senha");
        validacaoDoPerfil();
        
        Utilizador utilizadorTemp = new Utilizador(id, nome, tipo_utilizador,  username, senha, null);
        
        if(this.dashboard.getRadioBotaoDesativo().isSelected()) {
            utilizadorTemp.mudarEstado();
        }
        
        return utilizadorTemp;
    }    

    
    //FEITO
    private void salvar() {
        Utilizador utilizadorTemp = pegarOsValoresDoFormularioUtilizador();
        String mensagem = utilizadorDao.salvar(utilizadorTemp);
        
        if(mensagem.startsWith("Utilizador")) {
            mensagemNaTela(mensagem, Color.GREEN);
            
            limpaCampos();
        } else {
            mensagemNaTela(mensagem, Color.RED);
        }
    }
    
    
    public void mensagemNaTela(String mensagem, Color color) {
        this.dashboard.getLabelUtilizadorMensagem().setText(mensagem);
        this.dashboard.getLabelUtilizadorMensagem().setBackground(color);
    }
    
    private void actualizarTabelaUtilizador(List<Utilizador> utilizadores) {
        this.utilizadorTableModel = new UtilizadorTableModel(utilizadores);
        this.dashboard.getTabelaUtilizador().setModel(utilizadorTableModel);
        this.dashboard.getLabelHomeUtilizadores().setText(String.format("%d", utilizadores.size()));
    }

    //FEITO
    @Override
    public void mouseClicked(MouseEvent me) {
        int linhaSelecionada = this.dashboard.getTabelaUtilizador().getSelectedRow();
        this.utilizador = utilizadorTableModel.getUtilizadores().get(linhaSelecionada);
    }

    //TODOS FEITOS
    @Override
    public void mousePressed(MouseEvent me) { }

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {}

    //FALTA SO O GET
    @Override
    public void keyReleased(KeyEvent ke) {
        String pesquisar = this.dashboard.getTxtUtilizadorPesquisar().getText();
        
        if(pesquisar.isEmpty()) {
            actualizarTabelaUtilizador(utilizadorDao.todosUtilizadores());
        } else {
            List<Utilizador> utilizadoresTemp = this.utilizadorDao.todosUtilizadores()
                    .stream()
                    .filter((Utilizador u) -> {
                        return u.getNome().toLowerCase().contains(pesquisar.toLowerCase()) || 
                                u.getUsername().toLowerCase().contains(pesquisar.toLowerCase()) ||
                                u.getTipo_utilizador().toLowerCase().contains(pesquisar.toLowerCase());
                    })
                    .collect(Collectors.toList());
            
            actualizarTabelaUtilizador(utilizadoresTemp);
        }
        
    }

}
