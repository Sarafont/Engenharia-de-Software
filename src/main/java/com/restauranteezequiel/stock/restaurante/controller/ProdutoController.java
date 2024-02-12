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
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Categoria;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Fornecedores;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Produto;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Utilizador;
import com.restauranteezequiel.stock.restaurante.view.formulario.Dashboard;
import com.restauranteezequiel.stock.restaurante.view.modelo.exception.NegocioException;
import com.restauranteezequiel.stock.restaurante.view.modelo.util.ProdutoTableModel;
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
public class ProdutoController implements ActionListener, MouseListener, KeyListener {
    
    private Conexao conexao;
    private Dashboard dashboard;
    private AutenticacaoDAO autenticacaoDao;
    private UtilizadorDAO utilizadorDao;
    private CategoriaDAO categoriaDao;
    private FornecedoresDAO fornecedoresDao;
    private ProdutoDAO produtoDao;
    private ProdutoTableModel produtoTableModel;
    private Produto produto;
    
    
    public ProdutoController(Dashboard dashboard) {
        
        this.conexao = new ConexaoMySql();
        this.utilizadorDao = new UtilizadorDAO();
        this.autenticacaoDao = new AutenticacaoDAO();
        this.dashboard = dashboard;
        this.categoriaDao = new CategoriaDAO();
        this.produtoDao = new ProdutoDAO();
        this.fornecedoresDao = new FornecedoresDAO();
        
        actualizarTabela(produtoDao.todosProdutos());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao) {
            case "adicionar": adicionar(); break;
            case "editar": editar(); break;
            case "apagar": apagar(); break;
            case "adicionarcategoria": mostrarTelaCategoria(); break;
            case "adicionarfornecedor": mostrarTelaFornecedor(); break;
            case "salvar": salvar(); break;
            case "cancelar": cancelar(); break;
        }
    }
    
    
    private void adicionar() {
        Utilizador usuario = utilizadorLogado();
        if(autenticacaoDao.temPermissao(usuario))
            mostrarTelaProduto();
    }
    
    
    private Utilizador utilizadorLogado() {
        int utilizadorLogadoId = Integer.parseInt(this.dashboard.getLabelUtilizadorLogadoId().getText());
        return utilizadorDao.buscarUtilizadorPeloId(utilizadorLogadoId);
    }
    
    
    private void mostrarTelaProduto() {
        this.dashboard.getDialogProduto().pack();
        this.dashboard.getDialogProduto().setLocationRelativeTo(dashboard);
        this.dashboard.getDialogProduto().setVisible(true);
    }
    
    
    private void mostrarTelaCategoria() {
        this.dashboard.getDialogCategoria().pack();
        this.dashboard.getDialogCategoria().setLocationRelativeTo(dashboard);
        this.dashboard.getDialogCategoria().setVisible(true);
        ocultaTelaProduto();
    }
    
    private void mostrarTelaFornecedor() {
        this.dashboard.getDialogFornecedor().pack();
        this.dashboard.getDialogFornecedor().setLocationRelativeTo(dashboard);
        this.dashboard.getDialogFornecedor().setVisible(true);
        ocultaTelaProduto();
    }
    
    
    private void ocultaTelaProduto() {
        this.dashboard.getDialogProduto().setVisible(false);
    }
    
    
    private void validacaoDoCampo(String campo, String nomeDaVariavel) {
        if(campo.isEmpty()) {
            String mensagem = String.format("Deve preencher o campo %s", nomeDaVariavel);
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }
    }
    
    
    private void validacaoDaQuantidade(Integer quantidade) {
        if(quantidade < 0) {
            String mensagem = String.format("Quantidade não pode ser um numero negativo");
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }
    }
    
    
    private void validacaoDoPreco(double preco) {
        if(preco < 0) {
            String mensagem = String.format("Preço não pode ser menor que zero ");
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }
    }
    
    private void validacaoDaCategoria() {
        if(this.dashboard.getComboBoxProdutoCategoria().getSelectedIndex() == 0) {
            String mensagem = "Deves selecionar a categoria";
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }
    }
    
    private void validacaoDoFornecedor() {
        if(this.dashboard.getComboBoxProdutoFornecedores().getSelectedIndex() == 0) {
            String mensagem = "Deves selecionar o fornecedor";
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }
    }
    
    
    private Integer validacaoDaQuantidadeSeENumero(String quantidadeString) {
        try {
            Integer quantidade = Integer.valueOf(quantidadeString);
            return quantidade;
        } catch (NumberFormatException e) {
            mensagemNaTela("Deves inserir apenas numero.", Color.RED);
            return 0;
        }
    }
    
    
    private double validacaoDaPrecoSeENumero(String precoString) {
        try {
            double preco = Double.parseDouble(precoString);
            return preco;
        } catch (Exception e) {
            mensagemNaTela("Deves inserir apenas numero.", Color.RED);
            return 1.0;
        }
    }
    
    
     private Produto pegarValoresDoFormulario() {
        Utilizador utilizador = utilizadorLogado();
        
        String idString = this.dashboard.getTxtProdutoId().getText();
        String nome = this.dashboard.getTxtProdutoNome().getText();
        String descricao = this.dashboard.getTxtProdutoDescricao().getText();
        String precoString = this.dashboard.getTxtProdutoPreco().getText();
        String quantidadeString = this.dashboard.getTxtProdutoQuantidade().getValue().toString();
        String categoriaTemp = this.dashboard.getComboBoxProdutoCategoria().getSelectedItem().toString();
        String fornecedorTemp = this.dashboard.getComboBoxProdutoFornecedores().getSelectedItem().toString();
               
        validacaoDoCampo(nome, "nome");
        validacaoDoCampo(precoString, "preco");
        validacaoDoCampo(quantidadeString, "quantidade");
        validacaoDaCategoria();
        validacaoDoFornecedor();
        
        int id = Integer.parseInt(idString);
        int quantidade = validacaoDaQuantidadeSeENumero(quantidadeString);
        double preco = validacaoDaPrecoSeENumero(precoString);
        Categoria categoria = categoriaDao.buscarCategoriaPeloDescricao(categoriaTemp);
        Fornecedores fornecedor = fornecedoresDao.buscarFornecedoresPeloDesignacao(fornecedorTemp);
        
        //Atualizar 
        /*
        produto.setCategoria_id(categoria);
        produto.setFornecedor_id(fornecedor);*/
        
        validacaoDaQuantidade(quantidade);
        validacaoDoPreco(preco);
        
                
        return new Produto(id, nome, descricao, preco, quantidade, categoria, fornecedor, utilizador,  null);
    }
     
     
    private void salvar() {
        Produto produtoTemp = pegarValoresDoFormulario();
        
        String mensagem = produtoDao.salvar(produtoTemp);
        
        if(mensagem.startsWith("Produto")) {
            mensagemNaTela(mensagem, Color.GREEN);
            limpaCampo();
        }else {
            mensagemNaTela(mensagem, Color.RED);
        }
    }
     
    
    private void cancelar() {
        this.dashboard.getDialogProduto().setVisible(false);
        limpaCampo();
        mensagemNaTela("", Color.WHITE);
    }
    

    private void mensagemNaTela(String mensagem, Color color) {
         this.dashboard.getLabelProdutoMensagem().setBackground(color);
         this.dashboard.getLabelProdutoMensagem().setText(mensagem);
    }
    
    
    private void limpaCampo() {
        this.dashboard.getTxtProdutoId().setText("0");
        this.dashboard.getTxtProdutoNome().setText("");
        this.dashboard.getTxtProdutoDescricao().setText("");
        this.dashboard.getTxtProdutoPreco().setText("1");
        this.dashboard.getTxtProdutoQuantidade().setValue(0);
        this.dashboard.getComboBoxProdutoCategoria().setSelectedIndex(0);
        this.dashboard.getComboBoxProdutoFornecedores().setSelectedIndex(0);
        actualizarTabela(produtoDao.todosProdutos());
        this.produto = null;
    }
    
    
    private void actualizarTabela(List<Produto> produtos) {
        this.produtoTableModel = new ProdutoTableModel(produtos);
        
        for (Produto p : produtos) {
            Fornecedores fornecedor = fornecedoresDao.buscarFornecedoresPeloId(p.getFornecedor_id().getId());
            p.setFornecedor_id(fornecedor);
        }
        
        this.dashboard.getTabelaProduto().setModel(produtoTableModel);
        this.dashboard.getLabelHomeProduto().setText(String.format("%d", produtos.size()));
        
        this.dashboard.atualizarLabelHomeProduto();
    }
    

    private void editar() {
        Utilizador utilizador = utilizadorLogado();
        if(autenticacaoDao.temPermissao(utilizador)){
            if(this.produto != null) {
                this.dashboard.getComboBoxProdutoCategoria().setSelectedItem(this.produto.getCategoria_id().getDescricao());
                this.dashboard.getComboBoxProdutoFornecedores().setSelectedItem(this.produto.getFornecedor_id().getDesignacao());
                mostrarTelaProduto();
            } else {
                JOptionPane.showMessageDialog(dashboard, "Deve selecionar um produto na tabela", "Seleciona um produto", 0);
            }
        }
    }
    
    
    private void apagar() {
        Utilizador utilizador = utilizadorLogado();
        if(autenticacaoDao.temPermissao(utilizador)){
            if(this.produto != null) {
                int confirmar = JOptionPane.showConfirmDialog(dashboard, 
                        String.format("Tem certeza que deseja apagar? \nNome: %s", this.produto.getNome()), 
                        "Apagar produto", JOptionPane.YES_NO_OPTION);
                
                    if(confirmar == JOptionPane.YES_OPTION) {
                        String mensagem = produtoDao.deletaProdutoPeloId(this.produto.getId());
                        JOptionPane.showMessageDialog(dashboard, mensagem);
                        limpaCampo();
                    }
            } else {
                JOptionPane.showMessageDialog(dashboard, "Deve selecionar um produto na tabela", "Seleciona um produto", 0);
            }
        }
    }
    
    
    private void preencherOsValoresNoFormulario() {
        this.dashboard.getTxtProdutoId().setText(Long.toString(this.produto.getId()));
        this.dashboard.getTxtProdutoNome().setText(this.produto.getNome());
        this.dashboard.getTxtProdutoDescricao().setText(this.produto.getDescricao());
        this.dashboard.getTxtProdutoPreco().setText(Double.toString(this.produto.getPreco_unitario()));
        this.dashboard.getTxtProdutoQuantidade().setValue(this.produto.getQuantidade());
        this.dashboard.getComboBoxProdutoCategoria().setSelectedItem(this.produto.getCategoria_id().getDescricao());
        this.dashboard.getComboBoxProdutoFornecedores().setSelectedItem(this.produto.getFornecedor_id().getDesignacao());
    }
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        int linhaSelecionada = this.dashboard.getTabelaProduto().getSelectedRow();
        this.produto = this.produtoTableModel.getProdutos().get(linhaSelecionada);
        preencherOsValoresNoFormulario();
    }

    @Override
    public void mousePressed(MouseEvent me) {}

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

    @Override
    public void keyReleased(KeyEvent ke) {
        String pesquisar = this.dashboard.getTxtProdutoPesquisar().getText();
        
        if(pesquisar.isEmpty()) {
            actualizarTabela(produtoDao.todosProdutos());
        } else {
            List<Produto> produtoTemp = this.produtoDao.todosProdutos()
                    .stream()
                    .filter((Produto p) -> {
                        return p.getNome().toLowerCase().contains(pesquisar.toLowerCase()) || 
                                p.getCategoria_id().getDescricao().toLowerCase().contains(pesquisar.toLowerCase());
                    })
                    .collect(Collectors.toList());
            
            actualizarTabela(produtoTemp);
        }
    }

}
