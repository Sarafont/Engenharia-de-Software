/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.controller;

import com.restauranteezequiel.stock.restaurante.modelo.conexao.Conexao;
import com.restauranteezequiel.stock.restaurante.modelo.conexao.ConexaoMySql;
import com.restauranteezequiel.stock.restaurante.modelo.dao.AutenticacaoDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dao.CategoriaDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dao.UtilizadorDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Categoria;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Utilizador;
import com.restauranteezequiel.stock.restaurante.view.formulario.Dashboard;
import com.restauranteezequiel.stock.restaurante.view.modelo.exception.NegocioException;
import com.restauranteezequiel.stock.restaurante.view.modelo.util.CategoriaTableModel;
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
public class CategoriaController implements ActionListener, MouseListener, KeyListener{
    
    private Conexao conexao;
    private Dashboard dashboard;
    private AutenticacaoDAO autenticacaoDao;
    private CategoriaDAO categoriaDao;
    private UtilizadorDAO utilizadorDao;
    private CategoriaTableModel categoriaTableModel;
    private List<Categoria> categorias;
    private Categoria categoria;
    
    public CategoriaController(Dashboard dashboard) {
        this.conexao = new ConexaoMySql();
        this.dashboard = dashboard;
        this.categoriaDao = new CategoriaDAO();
        this.autenticacaoDao = new AutenticacaoDAO();
        this.utilizadorDao = new UtilizadorDAO();
        this.dashboard = dashboard;
        actualizarTabelaCategoria(categoriaDao.todasCategorias()); 
        inicializarComboBoxCategoriaNoProduto();
    }

    private void inicializarComboBoxCategoriaNoProduto() {
        this.dashboard.getComboBoxProdutoCategoria().removeAllItems();
        this.dashboard.getComboBoxProdutoCategoria().addItem("Selecione a categoria");
        categorias.stream().forEach(c -> {
            this.dashboard.getComboBoxProdutoCategoria().addItem(c.getDescricao());
        });
    }    
    
    private void actualizarTabelaCategoria(List<Categoria> categorias) {
        this.categorias = categoriaDao.todasCategorias();
        this.categoriaTableModel = new CategoriaTableModel(categorias);
        this.dashboard.getTabelaCategoria().setModel(categoriaTableModel);
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
            mostrarTelaCategoria();
        }
    }
    
    private void editar() {
        Utilizador utilizador = utilizadorLogado();
        if(autenticacaoDao.temPermissao(utilizador)){
            if(this.categoria != null) {
                preencherValoresNoFormulario();
                mostrarTelaCategoria();
            } else {
                JOptionPane.showMessageDialog(dashboard, "Deve selecionar uma categoria na tabela", "Seleciona uma categoria", 0);
            }
        }
    }
    
    
    private Utilizador utilizadorLogado() {
        int utilizadorLogadoId = Integer.parseInt(this.dashboard.getLabelUtilizadorLogadoId().getText());
        return utilizadorDao.buscarUtilizadorPeloId(utilizadorLogadoId);
    }
    
    
    private void salvar() {
        Categoria categoriaTemp = pegarValoresDoFormulario();
        
        String mensagem = categoriaDao.salvar(categoriaTemp);
        
        if(mensagem.startsWith("Categoria")) {
            mensagemNaTela(mensagem, Color.GREEN);
            actualizarTabelaCategoria(categoriaDao.todasCategorias());
            limpaCampos();
        } else {
            mensagemNaTela(mensagem, Color.RED);
        }
    }
    
    
    private void limpaCampos() {
        this.dashboard.getTxtCategoriaId().setText("0");
        this.dashboard.getTxtCategoriaDescricao().setText("");
        this.categoria = null;
        actualizarTabelaCategoria(categoriaDao.todasCategorias());
        inicializarComboBoxCategoriaNoProduto();
    }
    
    
    private void validacaoDoCampo(String campo) {
        if(campo.isEmpty()) {
            String mensagem = "Deves preencher o campo nome";
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        } 
    }
    
    
    private void mensagemNaTela(String mensagem, Color color) {
       this.dashboard.getLabelCategoriaMensagem().setText(mensagem);
        this.dashboard.getLabelCategoriaMensagem().setBackground(color);
    }
    
    
    private Categoria pegarValoresDoFormulario() {
        String idString = this.dashboard.getTxtCategoriaId().getText();
        String descricao = this.dashboard.getTxtCategoriaDescricao().getText();
        
        int id = Integer.parseInt(idString);
        
        validacaoDoCampo(descricao);
        
        return new Categoria(id, descricao);
    }
    
    
    private void preencherValoresNoFormulario() {
        this.dashboard.getTxtCategoriaId().setText(Long.toString(this.categoria.getId()));
        this.dashboard.getTxtCategoriaDescricao().setText(this.categoria.getDescricao());
    }

    
    private void apagar() {
        System.out.println("Botão de apagar pressionado!");
        Utilizador utilizador = utilizadorLogado();
        if(autenticacaoDao.temPermissao(utilizador)){
            if (categoria != null) {
                int confirmar = JOptionPane.showConfirmDialog(dashboard, 
                        String.format("Tem certeza que deseja apagar? \nNome: %s", this.categoria.getDescricao()), 
                        "Apagar categoria", JOptionPane.YES_NO_OPTION);
                
                    if(confirmar == JOptionPane.YES_OPTION) {
                        String mensagem = categoriaDao.deleteCategoriaPeloId(this.categoria.getId());
                        JOptionPane.showMessageDialog(dashboard, mensagem);
                        limpaCampos();
                    }
            } else {
                mensagemNaTela("Deve selecionar uma categoria na tabela", Color.RED);
            }
        }
    }
    
    private void mostrarTelaCategoria() {
        this.dashboard.getDialogCategoria().pack();
        this.dashboard.getDialogCategoria().setLocationRelativeTo(dashboard);
        this.dashboard.getDialogCategoria().setVisible(true);
    }
    
    
    private void limpar() {
        limpaCampos();
        mensagemNaTela("", Color.WHITE);
    }
    

    private void cancelar() {
        this.dashboard.getDialogCategoria().setVisible(false);
        this.dashboard.getDialogProduto().setVisible(true);
        limpar();
    }
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        int linhaSelecionada = this.dashboard.getTabelaCategoria().getSelectedRow();
        this.categoria = this.categoriaTableModel.getCategorias().get(linhaSelecionada);
        preencherValoresNoFormulario();
    }

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
    
    public void keyTyped(KeyEvent ke) {}

    public void keyPressed(KeyEvent ke) {}
    
    public void keyReleased(KeyEvent ke) {
        String pesquisar = this.dashboard.getTxtCategoriaPesquisar().getText();
        
        if(pesquisar.isEmpty()) {
            actualizarTabelaCategoria(categoriaDao.todasCategorias());
        } else {
            List<Categoria> categoriaTemp = this.categoriaDao.todasCategorias()
                    .stream()
                    .filter((Categoria c) -> {
                        return c.getDescricao().toLowerCase().contains(pesquisar.toLowerCase());
                    })
                    .collect(Collectors.toList());
            
            actualizarTabelaCategoria(categoriaTemp);
        }
    }
}
