/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.view.formulario;

import com.restauranteezequiel.stock.restaurante.controller.CategoriaController;
import com.restauranteezequiel.stock.restaurante.controller.DashboardController;
import com.restauranteezequiel.stock.restaurante.controller.FornecedoresController;
import com.restauranteezequiel.stock.restaurante.controller.ProdutoController;
import com.restauranteezequiel.stock.restaurante.controller.UtilizadorController;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author sara
 */
public class Dashboard extends javax.swing.JFrame {
    
    private DashboardController dashboardController;
    private CategoriaController categoriaController;
    private ProdutoController produtoController;
    private FornecedoresController fornecedoresController;
    private UtilizadorController utilizadorController;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        setLocationRelativeTo(null);
        this.dashboardController = new DashboardController(this);
        this.categoriaController = new CategoriaController(this);
        this.utilizadorController = new UtilizadorController(this);
        this.produtoController = new ProdutoController(this);
        this.fornecedoresController = new FornecedoresController(this);
        eventosDashboard();
        eventoUtilizador();
        eventoProduto();
        eventoCategoria();
        eventoFornecedores();
        
        String[] tiposUtilizador = {"Chefe", "Gerente", "Funcionario", "Cozinheiro"};
        comboBoxUtilizadorTipoUtilzador.setModel(new DefaultComboBoxModel<>(tiposUtilizador));
    }
    
    private void eventosDashboard() {
        botaoDashboardProdutos.addActionListener(dashboardController);
        botaoDashboardFornecedores.addActionListener(dashboardController);
        botaoDashboardCategorias.addActionListener(dashboardController);
        botaoDashboardUtilizador.addActionListener(dashboardController);
        botaoDashboardRelatorio.addActionListener(dashboardController);
        botaoDashboardHome.addActionListener(dashboardController);
        botaoDashboardSair.addActionListener(dashboardController);
    }
    
    private void eventoUtilizador() {
        botaoUtilizadorAdicionar.addActionListener(utilizadorController);
        botaoUtilizadorEditar.addActionListener(utilizadorController);
        botaoUtilizadorApagar.addActionListener(utilizadorController);
        botaoUtilizadorSalvar.addActionListener(utilizadorController);
        botaoUtilizadorCancelar.addActionListener(utilizadorController);
        tabelaUtilizador.addMouseListener(utilizadorController);
        txtUtilizadorPesquisa.addKeyListener(utilizadorController);
    }
    
    private void eventoProduto() {
        botaoProdutoAdicionar.addActionListener(produtoController);
        botaoProdutoSalvar.addActionListener(produtoController);
        botaoProdutoCancelar.addActionListener(produtoController);
        botaoProdutoEditar.addActionListener(produtoController);
        botaoProdutoApagar.addActionListener(produtoController);
        tabelaProduto.addMouseListener(produtoController);
        txtProdutoPesquisa.addKeyListener(produtoController);
    }
   
    
    private void eventoCategoria() {
        botaoCategoriaAdicionar.addActionListener(categoriaController);        
        botaoCategoriaCancelar.addActionListener(categoriaController);
        botaoCategoriaApagar.addActionListener(categoriaController);
        botaoCategoriaEditar.addActionListener(categoriaController);
        botaoCategoriaSalvar.addActionListener(categoriaController);
        tabelaCategoria.addMouseListener(categoriaController);
        txtCategoriaPesquisa.addKeyListener(categoriaController);
    }
    
    private void eventoFornecedores() {
        botaoFornecedoresAdicionar.addActionListener(fornecedoresController);        
        botaoFornecedorCancelar.addActionListener(fornecedoresController);
        botaoFornecedoresApagar.addActionListener(fornecedoresController);
        botaoFornecedoresEditar.addActionListener(fornecedoresController);
        botaoFornecedorSalvar.addActionListener(fornecedoresController);
        tabelaFornecedores.addMouseListener(fornecedoresController);
        txtFornecedoresPesquisa.addKeyListener(fornecedoresController);
    }
    
    
    private void mostrarPainelFornecedores() {
        panelUtilizadores.setVisible(false);
        panelProduto.setVisible(false);
        panelCategoria.setVisible(false);
        panelFornecedores.setVisible(true);
    }

    private void mostrarPainelUtilizadores() {
        panelUtilizadores.setVisible(true);
        panelProduto.setVisible(false);
        panelCategoria.setVisible(false);
        panelFornecedores.setVisible(false);
    }

    private void mostrarPainelCategorias() {
        panelUtilizadores.setVisible(false);
        panelProduto.setVisible(false);
        panelCategoria.setVisible(true);
        panelFornecedores.setVisible(false);
    }
    
    private void mostrarPainelRelatorio() {
        panelUtilizadores.setVisible(false);
        panelProduto.setVisible(false);
        panelCategoria.setVisible(false);
        panelFornecedores.setVisible(false);
        panelRelatorio.setVisible(true);
    }
    
    
    public void atualizarLabelHomeProduto() {
        int totalProdutos = tabelaProduto.getRowCount();
        labelHomeProduto.setText(String.valueOf(totalProdutos));
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogUtilizador = new javax.swing.JDialog();
        jPanel16 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botaoUtilizadorCancelar = new javax.swing.JButton();
        botaoUtilizadorSalvar = new javax.swing.JButton();
        txtUtilizadorId = new javax.swing.JTextField();
        txtUtilizadorNome = new javax.swing.JTextField();
        txtUtilizadorUsername = new javax.swing.JTextField();
        txtUtilizadorSenha = new javax.swing.JPasswordField();
        comboBoxUtilizadorTipoUtilzador = new javax.swing.JComboBox<>();
        radioBotaoUtilizadorAtivo = new javax.swing.JRadioButton();
        radioBotaoUtilizadorDesativo = new javax.swing.JRadioButton();
        labelUtilizadorMensagem = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        labelUtilizadorLogadoId = new javax.swing.JLabel();
        dialogProduto = new javax.swing.JDialog();
        jPanel21 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtProdutoId = new javax.swing.JTextField();
        txtProdutoNome = new javax.swing.JTextField();
        txtProdutoPreco = new javax.swing.JTextField();
        comboBoxProdutoCategoria = new javax.swing.JComboBox<>();
        comboBoxProdutoFornecedor = new javax.swing.JComboBox<>();
        txtProdutoQuantidade = new javax.swing.JSpinner();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtProdutoDescricao = new javax.swing.JTextArea();
        botaoProdutoAdicionarCategoria = new javax.swing.JButton();
        labelProdutoMensagem = new javax.swing.JLabel();
        botaoProdutoSalvar = new javax.swing.JButton();
        botaoProdutoCancelar = new javax.swing.JButton();
        botaoProdutoAdicionarFornecedor = new javax.swing.JButton();
        dialogCategoria = new javax.swing.JDialog();
        jPanel18 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        botaoCategoriaCancelar = new javax.swing.JButton();
        botaoCategoriaSalvar = new javax.swing.JButton();
        txtCategoriaId = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtCategoriaDescricao = new javax.swing.JTextArea();
        labelCategoriaMensagem = new javax.swing.JLabel();
        dialogFornecedor = new javax.swing.JDialog();
        jPanel22 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        botaoFornecedorCancelar = new javax.swing.JButton();
        botaoFornecedorSalvar = new javax.swing.JButton();
        txtFornecedorId = new javax.swing.JTextField();
        txtFornecedorDesignacao = new javax.swing.JTextField();
        txtFornecedorContato = new javax.swing.JTextField();
        txtFornecedorContribuinte = new javax.swing.JTextField();
        txtFornecedorCodPostal = new javax.swing.JTextField();
        txtFornecedorLocalidade = new javax.swing.JTextField();
        txtFornecedorEmail = new javax.swing.JTextField();
        txtFornecedorTelefone = new javax.swing.JTextField();
        labelFornecedorMensagem = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtFornecedorMorada = new javax.swing.JTextField();
        dialogRelatorio = new javax.swing.JDialog();
        panelRelatorio = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        dataEmissao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProdutoRel = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        totalProdutosStock = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel0 = new javax.swing.JPanel();
        botaoDashboardHome = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        botaoDashboardProdutos = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        botaoDashboardFornecedores = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        botaoDashboardCategorias = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        botaoDashboardUtilizador = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        botaoDashboardSair = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        botaoDashboardRelatorio = new javax.swing.JButton();
        panelBody = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelHomeProduto = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labelHomeFornecedores = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        labelHomeUtilizador = new javax.swing.JLabel();
        labelDashboardBemvidoUtilizador = new javax.swing.JLabel();
        panelProduto = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        botaoProdutoAdicionar = new javax.swing.JButton();
        botaoProdutoEditar = new javax.swing.JButton();
        botaoProdutoApagar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        txtProdutoPesquisa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelFornecedores = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        botaoFornecedoresAdicionar = new javax.swing.JButton();
        botaoFornecedoresEditar = new javax.swing.JButton();
        botaoFornecedoresApagar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaFornecedores = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        txtFornecedoresPesquisa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelCategoria = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        botaoCategoriaAdicionar = new javax.swing.JButton();
        botaoCategoriaEditar = new javax.swing.JButton();
        botaoCategoriaApagar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaCategoria = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        txtCategoriaPesquisa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelUtilizadores = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        botaoUtilizadorAdicionar = new javax.swing.JButton();
        botaoUtilizadorEditar = new javax.swing.JButton();
        botaoUtilizadorApagar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaUtilizador = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        txtUtilizadorPesquisa = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        dialogUtilizador.setBackground(java.awt.Color.white);

        jPanel16.setBackground(java.awt.Color.white);
        jPanel16.setPreferredSize(new java.awt.Dimension(742, 458));

        jLabel12.setBackground(java.awt.Color.white);
        jLabel12.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("REGISTO DE UTILIZADOR");
        jLabel12.setMaximumSize(new java.awt.Dimension(272, 29));
        jLabel12.setMinimumSize(new java.awt.Dimension(272, 29));
        jLabel12.setOpaque(true);
        jLabel12.setPreferredSize(new java.awt.Dimension(272, 29));

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel13.setText("Id:");

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel14.setText("Nome:");

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel15.setText("Username:");

        jLabel17.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel17.setText("Senha:");

        jLabel18.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel18.setText("Tipo de utilizador:");

        jLabel19.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel19.setText("Estado:");

        botaoUtilizadorCancelar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoUtilizadorCancelar.setText("Cancelar");

        botaoUtilizadorSalvar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoUtilizadorSalvar.setText("Salvar");

        txtUtilizadorId.setText("0");

        radioBotaoUtilizadorAtivo.setText("Ativo");

        radioBotaoUtilizadorDesativo.setText("Desativado");

        labelUtilizadorMensagem.setBackground(java.awt.Color.white);
        labelUtilizadorMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUtilizadorMensagem.setMaximumSize(new java.awt.Dimension(31, 18));
        labelUtilizadorMensagem.setMinimumSize(new java.awt.Dimension(31, 18));
        labelUtilizadorMensagem.setPreferredSize(new java.awt.Dimension(31, 18));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel13)
                                .addComponent(jLabel15)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18)
                                .addComponent(jLabel19))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUtilizadorId)
                                .addComponent(txtUtilizadorNome)
                                .addComponent(txtUtilizadorUsername)
                                .addComponent(txtUtilizadorSenha)
                                .addComponent(comboBoxUtilizadorTipoUtilzador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addComponent(radioBotaoUtilizadorAtivo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(radioBotaoUtilizadorDesativo)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(botaoUtilizadorSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoUtilizadorCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelUtilizadorMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUtilizadorMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtUtilizadorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtUtilizadorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtUtilizadorUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtUtilizadorSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(comboBoxUtilizadorTipoUtilzador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(radioBotaoUtilizadorAtivo)
                    .addComponent(radioBotaoUtilizadorDesativo))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoUtilizadorCancelar)
                    .addComponent(botaoUtilizadorSalvar))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogUtilizadorLayout = new javax.swing.GroupLayout(dialogUtilizador.getContentPane());
        dialogUtilizador.getContentPane().setLayout(dialogUtilizadorLayout);
        dialogUtilizadorLayout.setHorizontalGroup(
            dialogUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUtilizadorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        dialogUtilizadorLayout.setVerticalGroup(
            dialogUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUtilizadorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        labelUtilizadorLogadoId.setText("0");
        labelUtilizadorLogadoId.getAccessibleContext().setAccessibleDescription("");

        jPanel21.setBackground(java.awt.Color.white);
        jPanel21.setPreferredSize(new java.awt.Dimension(742, 467));

        jLabel21.setBackground(java.awt.Color.white);
        jLabel21.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("REGISTO DE PRODUTO");
        jLabel21.setMaximumSize(new java.awt.Dimension(282, 29));
        jLabel21.setMinimumSize(new java.awt.Dimension(282, 29));
        jLabel21.setPreferredSize(new java.awt.Dimension(282, 29));

        jLabel22.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel22.setText("Id:");

        jLabel23.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel23.setText("Nome:");

        jLabel29.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel29.setText("Preço:");

        jLabel30.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel30.setText("Quantidade:");

        jLabel31.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel31.setText("Categoria:");

        jLabel32.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel32.setText("Fornecedor:");

        jLabel33.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel33.setText("Descrição:");

        txtProdutoId.setText("0");

        txtProdutoPreco.setText("1");

        comboBoxProdutoCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12", "Item 13" }));

        comboBoxProdutoFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", " " }));
        comboBoxProdutoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProdutoFornecedorActionPerformed(evt);
            }
        });

        txtProdutoDescricao.setColumns(20);
        txtProdutoDescricao.setRows(5);
        jScrollPane6.setViewportView(txtProdutoDescricao);

        labelProdutoMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        botaoProdutoSalvar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoProdutoSalvar.setText("Salvar");

        botaoProdutoCancelar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoProdutoCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel30)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel32)
                                            .addComponent(jLabel33)
                                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel22)
                                                .addComponent(jLabel23)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtProdutoQuantidade)
                                            .addComponent(txtProdutoPreco)
                                            .addComponent(txtProdutoNome)
                                            .addComponent(txtProdutoId)
                                            .addComponent(jScrollPane6)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(comboBoxProdutoFornecedor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(comboBoxProdutoCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(botaoProdutoAdicionarCategoria)
                                                    .addComponent(botaoProdutoAdicionarFornecedor)))))))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(413, 413, 413)
                                .addComponent(botaoProdutoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(botaoProdutoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(67, 67, 67))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelProdutoMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelProdutoMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtProdutoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23))
                    .addComponent(txtProdutoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtProdutoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtProdutoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(comboBoxProdutoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoProdutoAdicionarCategoria))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(comboBoxProdutoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoProdutoAdicionarFornecedor))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoProdutoCancelar)
                    .addComponent(botaoProdutoSalvar))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout dialogProdutoLayout = new javax.swing.GroupLayout(dialogProduto.getContentPane());
        dialogProduto.getContentPane().setLayout(dialogProdutoLayout);
        dialogProdutoLayout.setHorizontalGroup(
            dialogProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogProdutoLayout.setVerticalGroup(
            dialogProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel18.setBackground(java.awt.Color.white);

        jLabel25.setBackground(java.awt.Color.white);
        jLabel25.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("REGISTO DE CATEGORIA");

        jLabel24.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel24.setText("Id:");

        jLabel26.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel26.setText("Descrição:");

        botaoCategoriaCancelar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoCategoriaCancelar.setText("Cancelar");

        botaoCategoriaSalvar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoCategoriaSalvar.setText("Salvar");

        txtCategoriaId.setText("0");

        txtCategoriaDescricao.setColumns(20);
        txtCategoriaDescricao.setRows(5);
        jScrollPane7.setViewportView(txtCategoriaDescricao);

        labelCategoriaMensagem.setBackground(java.awt.Color.white);
        labelCategoriaMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCategoriaId, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(botaoCategoriaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botaoCategoriaCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCategoriaMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCategoriaMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCategoriaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCategoriaCancelar)
                    .addComponent(botaoCategoriaSalvar))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogCategoriaLayout = new javax.swing.GroupLayout(dialogCategoria.getContentPane());
        dialogCategoria.getContentPane().setLayout(dialogCategoriaLayout);
        dialogCategoriaLayout.setHorizontalGroup(
            dialogCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
            .addGroup(dialogCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogCategoriaLayout.setVerticalGroup(
            dialogCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
            .addGroup(dialogCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBackground(java.awt.Color.white);

        jLabel27.setBackground(java.awt.Color.white);
        jLabel27.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("REGISTO DE FORNECEDOR");

        jLabel28.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel28.setText("Id:");

        jLabel34.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel34.setText("Designação:");

        jLabel35.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel35.setText("Contato:");

        jLabel36.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel36.setText("Contribuinte:");

        jLabel37.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel37.setText("Código Postal:");

        jLabel38.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel38.setText("Localidade:");

        jLabel39.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel39.setText("Email:");

        jLabel40.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel40.setText("Telefone:");

        botaoFornecedorCancelar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoFornecedorCancelar.setText("Cancelar");

        botaoFornecedorSalvar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoFornecedorSalvar.setText("Salvar");

        txtFornecedorId.setText("0");

        labelFornecedorMensagem.setBackground(java.awt.Color.white);
        labelFornecedorMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel20.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel20.setText("Morada:");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFornecedorId)
                            .addComponent(txtFornecedorDesignacao)
                            .addComponent(txtFornecedorContato)
                            .addComponent(txtFornecedorContribuinte)
                            .addComponent(txtFornecedorCodPostal)
                            .addComponent(txtFornecedorLocalidade)
                            .addComponent(txtFornecedorEmail)
                            .addComponent(txtFornecedorTelefone)
                            .addComponent(txtFornecedorMorada)))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelFornecedorMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoFornecedorSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoFornecedorCancelar)
                .addGap(78, 78, 78))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFornecedorMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtFornecedorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtFornecedorDesignacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtFornecedorContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtFornecedorContribuinte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtFornecedorCodPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtFornecedorLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtFornecedorMorada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFornecedorEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtFornecedorTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFornecedorSalvar)
                    .addComponent(botaoFornecedorCancelar))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout dialogFornecedorLayout = new javax.swing.GroupLayout(dialogFornecedor.getContentPane());
        dialogFornecedor.getContentPane().setLayout(dialogFornecedorLayout);
        dialogFornecedorLayout.setHorizontalGroup(
            dialogFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(dialogFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogFornecedorLayout.setVerticalGroup(
            dialogFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(dialogFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dialogFornecedorLayout.createSequentialGroup()
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelRelatorio.setBackground(java.awt.Color.white);

        jLabel45.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Relatório de Stock");

        jPanel24.setBackground(java.awt.Color.white);

        jLabel41.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel41.setText("Data de Emissão:");

        dataEmissao.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataEmissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabelaProdutoRel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane2.setViewportView(tabelaProdutoRel);

        jPanel26.setBackground(java.awt.Color.white);

        jLabel42.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jLabel42.setText("Total de Produtos em Stock:");

        totalProdutosStock.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalProdutosStock, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(totalProdutosStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRelatorioLayout = new javax.swing.GroupLayout(panelRelatorio);
        panelRelatorio.setLayout(panelRelatorioLayout);
        panelRelatorioLayout.setHorizontalGroup(
            panelRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRelatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRelatorioLayout.createSequentialGroup()
                        .addGroup(panelRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRelatorioLayout.setVerticalGroup(
            panelRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRelatorioLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogRelatorioLayout = new javax.swing.GroupLayout(dialogRelatorio.getContentPane());
        dialogRelatorio.getContentPane().setLayout(dialogRelatorioLayout);
        dialogRelatorioLayout.setHorizontalGroup(
            dialogRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 907, Short.MAX_VALUE)
            .addGroup(dialogRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dialogRelatorioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        dialogRelatorioLayout.setVerticalGroup(
            dialogRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
            .addGroup(dialogRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dialogRelatorioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBackground(java.awt.Color.white);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        botaoDashboardHome.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoDashboardHome.setText("Home");
        botaoDashboardHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDashboardHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel0Layout = new javax.swing.GroupLayout(jPanel0);
        jPanel0.setLayout(jPanel0Layout);
        jPanel0Layout.setHorizontalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoDashboardHome, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
        );
        jPanel0Layout.setVerticalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
            .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoDashboardHome, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
        );

        botaoDashboardProdutos.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoDashboardProdutos.setText("Produtos");
        botaoDashboardProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDashboardProdutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        botaoDashboardFornecedores.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoDashboardFornecedores.setText("Fornecedores");
        botaoDashboardFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDashboardFornecedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoDashboardFornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoDashboardFornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
        );

        botaoDashboardCategorias.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoDashboardCategorias.setText("Categorias");
        botaoDashboardCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDashboardCategoriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoDashboardCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoDashboardCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
        );

        botaoDashboardUtilizador.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoDashboardUtilizador.setText("Utilizadores");
        botaoDashboardUtilizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDashboardUtilizadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoDashboardUtilizador, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoDashboardUtilizador, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
        );

        botaoDashboardSair.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoDashboardSair.setIcon(new javax.swing.ImageIcon("/home/sara/NetBeansProjects/stock-restaurante/src/main/java/com/restauranteezequiel/stock/restaurante/view/imagens/20130709071127978_easyicon_net_32.png")); // NOI18N
        botaoDashboardSair.setText("Sair");
        botaoDashboardSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDashboardSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardSair, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        botaoDashboardRelatorio.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        botaoDashboardRelatorio.setText("Relatório");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoDashboardRelatorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(botaoDashboardRelatorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelBody.setPreferredSize(new java.awt.Dimension(758, 595));
        panelBody.setLayout(new java.awt.CardLayout());

        panelHome.setBackground(java.awt.Color.white);

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(198, 136));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel2.setText("PRODUTOS");
        jLabel2.setPreferredSize(new java.awt.Dimension(132, 29));

        labelHomeProduto.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        labelHomeProduto.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelHomeProduto)
                .addGap(22, 22, 22))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelHomeProduto)
                .addGap(27, 27, 27))
        );

        jPanel10.setBackground(java.awt.Color.white);
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setPreferredSize(new java.awt.Dimension(198, 136));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel4.setText("FORNECEDORES");
        jLabel4.setPreferredSize(new java.awt.Dimension(132, 29));

        labelHomeFornecedores.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        labelHomeFornecedores.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelHomeFornecedores)
                .addGap(22, 22, 22))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelHomeFornecedores)
                .addGap(27, 27, 27))
        );

        jPanel11.setBackground(java.awt.Color.white);
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setPreferredSize(new java.awt.Dimension(198, 136));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel6.setText("UTILIZADORES");
        jLabel6.setPreferredSize(new java.awt.Dimension(132, 29));

        labelHomeUtilizador.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        labelHomeUtilizador.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(labelHomeUtilizador)
                .addGap(22, 22, 22))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelHomeUtilizador)
                .addGap(27, 27, 27))
        );

        labelDashboardBemvidoUtilizador.setBackground(java.awt.Color.white);
        labelDashboardBemvidoUtilizador.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelDashboardBemvidoUtilizador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(labelDashboardBemvidoUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(371, Short.MAX_VALUE))
        );

        panelBody.add(panelHome, "card2");

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        botaoProdutoAdicionar.setText("Adicionar");
        jPanel2.add(botaoProdutoAdicionar);

        botaoProdutoEditar.setText("Editar");
        jPanel2.add(botaoProdutoEditar);

        botaoProdutoApagar.setText("Apagar");
        jPanel2.add(botaoProdutoApagar);

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tabelaProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaProduto.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tabelaProduto);

        jPanel12.setBackground(java.awt.Color.white);
        jPanel12.setPreferredSize(new java.awt.Dimension(309, 32));

        txtProdutoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoPesquisaActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon("/home/sara/NetBeansProjects/stock-restaurante/src/main/java/com/restauranteezequiel/stock/restaurante/view/imagens/search16.png")); // NOI18N
        jLabel5.setText("icon");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProdutoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProdutoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PRODUTOS");

        javax.swing.GroupLayout panelProdutoLayout = new javax.swing.GroupLayout(panelProduto);
        panelProduto.setLayout(panelProdutoLayout);
        panelProdutoLayout.setHorizontalGroup(
            panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProdutoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelProdutoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelProdutoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelProdutoLayout.setVerticalGroup(
            panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdutoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(65, 65, 65)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(451, Short.MAX_VALUE))
            .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProdutoLayout.createSequentialGroup()
                    .addContainerGap(49, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(522, Short.MAX_VALUE)))
            .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProdutoLayout.createSequentialGroup()
                    .addContainerGap(145, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        panelBody.add(panelProduto, "card3");

        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

        botaoFornecedoresAdicionar.setText("Adicionar");
        jPanel15.add(botaoFornecedoresAdicionar);

        botaoFornecedoresEditar.setText("Editar");
        jPanel15.add(botaoFornecedoresEditar);

        botaoFornecedoresApagar.setText("Apagar");
        jPanel15.add(botaoFornecedoresApagar);

        jScrollPane3.setBackground(java.awt.Color.white);

        tabelaFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane3.setViewportView(tabelaFornecedores);

        jPanel13.setBackground(java.awt.Color.white);

        jLabel8.setIcon(new javax.swing.ImageIcon("/home/sara/NetBeansProjects/stock-restaurante/src/main/java/com/restauranteezequiel/stock/restaurante/view/imagens/search16.png")); // NOI18N
        jLabel8.setText("icon");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFornecedoresPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFornecedoresPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jLabel7.setBackground(java.awt.Color.white);
        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FORNECEDORES");
        jLabel7.setMaximumSize(new java.awt.Dimension(102, 22));
        jLabel7.setMinimumSize(new java.awt.Dimension(102, 22));
        jLabel7.setPreferredSize(new java.awt.Dimension(102, 22));

        javax.swing.GroupLayout panelFornecedoresLayout = new javax.swing.GroupLayout(panelFornecedores);
        panelFornecedores.setLayout(panelFornecedoresLayout);
        panelFornecedoresLayout.setHorizontalGroup(
            panelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelFornecedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addGroup(panelFornecedoresLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(panelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelFornecedoresLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelFornecedoresLayout.setVerticalGroup(
            panelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFornecedoresLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(477, Short.MAX_VALUE))
            .addGroup(panelFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFornecedoresLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        panelBody.add(panelFornecedores, "card4");

        jPanel19.setLayout(new java.awt.GridLayout(1, 0));

        botaoCategoriaAdicionar.setText("Adicionar");
        jPanel19.add(botaoCategoriaAdicionar);

        botaoCategoriaEditar.setText("Editar");
        jPanel19.add(botaoCategoriaEditar);

        botaoCategoriaApagar.setText("Apagar");
        jPanel19.add(botaoCategoriaApagar);

        jScrollPane5.setBackground(java.awt.Color.white);
        jScrollPane5.setToolTipText("");

        tabelaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane5.setViewportView(tabelaCategoria);

        jPanel20.setBackground(java.awt.Color.white);

        jLabel10.setIcon(new javax.swing.ImageIcon("/home/sara/NetBeansProjects/stock-restaurante/src/main/java/com/restauranteezequiel/stock/restaurante/view/imagens/search16.png")); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCategoriaPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCategoriaPesquisa))
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CATEGORIAS");

        javax.swing.GroupLayout panelCategoriaLayout = new javax.swing.GroupLayout(panelCategoria);
        panelCategoria.setLayout(panelCategoriaLayout);
        panelCategoriaLayout.setHorizontalGroup(
            panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCategoriaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCategoriaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelCategoriaLayout.setVerticalGroup(
            panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCategoriaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(469, Short.MAX_VALUE))
            .addGroup(panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCategoriaLayout.createSequentialGroup()
                    .addContainerGap(135, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        panelBody.add(panelCategoria, "card5");

        jPanel17.setLayout(new java.awt.GridLayout(1, 0));

        botaoUtilizadorAdicionar.setText("Adicionar");
        jPanel17.add(botaoUtilizadorAdicionar);

        botaoUtilizadorEditar.setText("Editar");
        jPanel17.add(botaoUtilizadorEditar);

        botaoUtilizadorApagar.setText("Apagar");
        jPanel17.add(botaoUtilizadorApagar);

        tabelaUtilizador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane4.setViewportView(tabelaUtilizador);

        jPanel14.setBackground(java.awt.Color.white);

        jLabel16.setIcon(new javax.swing.ImageIcon("/home/sara/NetBeansProjects/stock-restaurante/src/main/java/com/restauranteezequiel/stock/restaurante/view/imagens/search16.png")); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUtilizadorPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUtilizadorPesquisa))
                .addContainerGap())
        );

        jLabel11.setBackground(java.awt.Color.white);
        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("UTILIZADORES");

        javax.swing.GroupLayout panelUtilizadoresLayout = new javax.swing.GroupLayout(panelUtilizadores);
        panelUtilizadores.setLayout(panelUtilizadoresLayout);
        panelUtilizadoresLayout.setHorizontalGroup(
            panelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtilizadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUtilizadoresLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(panelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelUtilizadoresLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(panelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelUtilizadoresLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelUtilizadoresLayout.setVerticalGroup(
            panelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtilizadoresLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addGap(62, 62, 62)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(458, Short.MAX_VALUE))
            .addGroup(panelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUtilizadoresLayout.createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(520, Short.MAX_VALUE)))
            .addGroup(panelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUtilizadoresLayout.createSequentialGroup()
                    .addContainerGap(146, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        panelBody.add(panelUtilizadores, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBody, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoDashboardHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDashboardHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDashboardHomeActionPerformed

    private void botaoDashboardProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDashboardProdutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDashboardProdutosActionPerformed

    private void botaoDashboardFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDashboardFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDashboardFornecedoresActionPerformed

    private void botaoDashboardCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDashboardCategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDashboardCategoriasActionPerformed

    private void botaoDashboardUtilizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDashboardUtilizadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDashboardUtilizadorActionPerformed

    private void botaoDashboardSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDashboardSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDashboardSairActionPerformed

    private void comboBoxProdutoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProdutoFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProdutoFornecedorActionPerformed

    private void txtProdutoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoPesquisaActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCategoriaAdicionar;
    private javax.swing.JButton botaoCategoriaApagar;
    private javax.swing.JButton botaoCategoriaCancelar;
    private javax.swing.JButton botaoCategoriaEditar;
    private javax.swing.JButton botaoCategoriaSalvar;
    private javax.swing.JButton botaoDashboardCategorias;
    private javax.swing.JButton botaoDashboardFornecedores;
    private javax.swing.JButton botaoDashboardHome;
    private javax.swing.JButton botaoDashboardProdutos;
    private javax.swing.JButton botaoDashboardRelatorio;
    private javax.swing.JButton botaoDashboardSair;
    private javax.swing.JButton botaoDashboardUtilizador;
    private javax.swing.JButton botaoFornecedorCancelar;
    private javax.swing.JButton botaoFornecedorSalvar;
    private javax.swing.JButton botaoFornecedoresAdicionar;
    private javax.swing.JButton botaoFornecedoresApagar;
    private javax.swing.JButton botaoFornecedoresEditar;
    private javax.swing.JButton botaoProdutoAdicionar;
    private javax.swing.JButton botaoProdutoAdicionarCategoria;
    private javax.swing.JButton botaoProdutoAdicionarFornecedor;
    private javax.swing.JButton botaoProdutoApagar;
    private javax.swing.JButton botaoProdutoCancelar;
    private javax.swing.JButton botaoProdutoEditar;
    private javax.swing.JButton botaoProdutoSalvar;
    private javax.swing.JButton botaoUtilizadorAdicionar;
    private javax.swing.JButton botaoUtilizadorApagar;
    private javax.swing.JButton botaoUtilizadorCancelar;
    private javax.swing.JButton botaoUtilizadorEditar;
    private javax.swing.JButton botaoUtilizadorSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboBoxProdutoCategoria;
    private javax.swing.JComboBox<String> comboBoxProdutoFornecedor;
    private javax.swing.JComboBox<String> comboBoxUtilizadorTipoUtilzador;
    private javax.swing.JLabel dataEmissao;
    private javax.swing.JDialog dialogCategoria;
    private javax.swing.JDialog dialogFornecedor;
    private javax.swing.JDialog dialogProduto;
    private javax.swing.JDialog dialogRelatorio;
    private javax.swing.JDialog dialogUtilizador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel0;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelCategoriaMensagem;
    private javax.swing.JLabel labelDashboardBemvidoUtilizador;
    private javax.swing.JLabel labelFornecedorMensagem;
    private javax.swing.JLabel labelHomeFornecedores;
    private javax.swing.JLabel labelHomeProduto;
    private javax.swing.JLabel labelHomeUtilizador;
    private javax.swing.JLabel labelProdutoMensagem;
    private javax.swing.JLabel labelUtilizadorLogadoId;
    private javax.swing.JLabel labelUtilizadorMensagem;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelCategoria;
    private javax.swing.JPanel panelFornecedores;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelProduto;
    private javax.swing.JPanel panelRelatorio;
    private javax.swing.JPanel panelUtilizadores;
    private javax.swing.JRadioButton radioBotaoUtilizadorAtivo;
    private javax.swing.JRadioButton radioBotaoUtilizadorDesativo;
    private javax.swing.JTable tabelaCategoria;
    private javax.swing.JTable tabelaFornecedores;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTable tabelaProdutoRel;
    private javax.swing.JTable tabelaUtilizador;
    private javax.swing.JLabel totalProdutosStock;
    private javax.swing.JTextArea txtCategoriaDescricao;
    private javax.swing.JTextField txtCategoriaId;
    private javax.swing.JTextField txtCategoriaPesquisa;
    private javax.swing.JTextField txtFornecedorCodPostal;
    private javax.swing.JTextField txtFornecedorContato;
    private javax.swing.JTextField txtFornecedorContribuinte;
    private javax.swing.JTextField txtFornecedorDesignacao;
    private javax.swing.JTextField txtFornecedorEmail;
    private javax.swing.JTextField txtFornecedorId;
    private javax.swing.JTextField txtFornecedorLocalidade;
    private javax.swing.JTextField txtFornecedorMorada;
    private javax.swing.JTextField txtFornecedorTelefone;
    private javax.swing.JTextField txtFornecedoresPesquisa;
    private javax.swing.JTextArea txtProdutoDescricao;
    private javax.swing.JTextField txtProdutoId;
    private javax.swing.JTextField txtProdutoNome;
    private javax.swing.JTextField txtProdutoPesquisa;
    private javax.swing.JTextField txtProdutoPreco;
    private javax.swing.JSpinner txtProdutoQuantidade;
    private javax.swing.JTextField txtUtilizadorId;
    private javax.swing.JTextField txtUtilizadorNome;
    private javax.swing.JTextField txtUtilizadorPesquisa;
    private javax.swing.JPasswordField txtUtilizadorSenha;
    private javax.swing.JTextField txtUtilizadorUsername;
    // End of variables declaration//GEN-END:variables

    public JButton getBotaoDashboardHome() {
        return botaoDashboardHome;
    }

    public JButton getBotaoDashboardProdutos() {
        return botaoDashboardProdutos;
    }
    
    public JButton getBotaoDashboardCategorias() {
        return botaoDashboardCategorias;
    }
    
    public JButton getBotaoDashboardFornecedores() {
        return botaoDashboardFornecedores;
    }
    
    public JButton getBotaoDashboardUtilizadores() {
        return botaoDashboardUtilizador;
    }
    
    public JButton getBotaoDashboardRelatorio() {
        return botaoDashboardRelatorio;
    }
    
    public JButton getBotaoDashboardSair() {
        return botaoDashboardSair;
    }
    
    public JPanel getPanelHome() {
        return panelHome;
    }
    
    public JPanel getPanelBody() {
        return panelBody;
    }
    
    public JPanel getPanelProduto() {
        return panelProduto;
    }
    
    public JPanel getPanelFornecedores() {
        return panelFornecedores;
    }
    
    public JPanel getPanelCategorias() {
        return panelCategoria;
    }
    
    public JPanel getPanelUtilizador() {
        return panelUtilizadores;
    }
    
    public JTable getTabelaUtilizador(){
        return tabelaUtilizador;
    }    
    
    public JLabel getLabelBenvindoUtilizador() {
        return labelDashboardBemvidoUtilizador;
    }

    public JLabel getLabelUtilizadorLogadoId() {
        return labelUtilizadorLogadoId;
    }
    
    public JButton getBotaoUtilizadorAdicionar() {
        return botaoUtilizadorAdicionar;
    }
    
    public JButton getBotaoUtilizadorEditar() {
        return botaoUtilizadorEditar;
    }
    
    public JButton getBotaoUtilizadorApagar() {
        return botaoUtilizadorApagar;
    }
    
    public JDialog getDialogUtilizador() {
        return this.dialogUtilizador;
    }
    
    public JDialog getDialogRelatorio() {
        return this.dialogRelatorio;
    }
    
    public JComboBox getComboBoxUtilizadorTipoUtilizador() {
        return comboBoxUtilizadorTipoUtilzador;
    }
    
    public JTextField getTxtUtilizadorId() {
        return txtUtilizadorId;
    }
    
    public JTextField getTxtUtilizadorNome() {
        return txtUtilizadorNome;
    }
    
    public JTextField getTxtUtilizadorSenha() {
        return txtUtilizadorSenha;
    }
    
    public JTextField getTxtUtilizadorUsername() {
        return txtUtilizadorUsername;
    }
    
    public JRadioButton getRadioBotaoAtivo() {
        return radioBotaoUtilizadorAtivo;
    }
    
    public JRadioButton getRadioBotaoDesativo() {
        return radioBotaoUtilizadorDesativo;
    }
    
    public JLabel getLabelUtilizadorMensagem() {
        return labelUtilizadorMensagem;
    }
    
    public JTextField getTxtUtilizadorPesquisar() {
        return txtUtilizadorPesquisa;
    }
    
    public JButton getBotaoCategoriaSalvar() {
        return botaoCategoriaSalvar;
    }
    
    public JButton getBotaoCategoriaCancelar() {
        return botaoCategoriaCancelar;
    }
    
    public JButton getBotaoCategoriaApagar() {
        return botaoCategoriaApagar;
    }
    
    public JTextField getTxtCategoriaId() {
        return txtCategoriaId;
    }
    
    public JTextArea getTxtCategoriaDescricao() {
        return txtCategoriaDescricao;
    }
    
    public JTable getTabelaCategoria() {
        return tabelaCategoria;
    }
    
    public JDialog getDialogProduto() {
        return dialogProduto;
    }
    
    public JLabel getDataEmissao(){
        return dataEmissao;
    }
    
    public JLabel getTotalProdutosStock(){
        return totalProdutosStock;
    }
    
    public JButton getBotaoProdutoAdicionarCategoria() {
        return botaoProdutoAdicionarCategoria;
    }
    
    public JDialog getDialogCategoria() {
        return dialogCategoria;
    }
    
    public JButton getBotaoProdutoAdicionar() {
        return botaoProdutoAdicionar;
    }
    
    public JButton getBotaoProdutoEditar() {
        return botaoProdutoEditar;
    }
    
    public JButton getBotaoProdutoApagar() {
        return botaoProdutoApagar;
    }
    
    public JLabel getLabelCategoriaMensagem() {
        return labelCategoriaMensagem;
    }
    
    public JComboBox getComboBoxProdutoCategoria() {
        return comboBoxProdutoCategoria;
    }
    
    public JComboBox getComboBoxProdutoFornecedores() {
        return comboBoxProdutoFornecedor;
    }
    
    public JTextField getTxtProdutoId() {
        return txtProdutoId;
    }
    
    public JTextField getTxtProdutoNome() {
        return txtProdutoNome;
    }
    
    public JTextField getTxtProdutoPreco() {
        return txtProdutoPreco;
    }
    
    public JSpinner getTxtProdutoQuantidade() {
        return txtProdutoQuantidade;
    }
    
    public JTextArea getTxtProdutoDescricao() {
        return txtProdutoDescricao;
    }
 
    public JLabel getLabelProdutoMensagem() {
        return labelProdutoMensagem;
    }
    
    public JTable getTabelaProduto() {
        return tabelaProduto;
    }
    
    public JTable getTabelaProdutoRel() {
        return tabelaProdutoRel;
    }
    
    public JTextField getTxtProdutoPesquisar() {
        return txtProdutoPesquisa;
    }
    
    public JTextField getTxtFornecedoresPesquisar() {
        return txtFornecedoresPesquisa;
    }
    
    public JTextField getTxtCategoriaPesquisar() {
        return txtCategoriaPesquisa;
    }
    
    public JLabel getLabelFornecedorMensagem() {
        return labelFornecedorMensagem;
    }
    
    public JTextField getTxtFornecedorId() {
        return txtFornecedorId;
    }
    
    public JTextField getTxtFornecedorDesigncao() {
        return txtFornecedorDesignacao;
    }
    
    public JTextField getTxtFornecedorContato() {
        return txtFornecedorContato;
    }
    
    public JTextField getTxtFornecedorContribuinte() {
        return txtFornecedorContribuinte;
    }
    
    public JTextField getTxtFornecedorCodPostal() {
        return txtFornecedorCodPostal;
    }
    
    public JTextField getTxtFornecedorLocalidade() {
        return txtFornecedorLocalidade;
    }
    
    public JTextField getTxtFornecedorMorada() {
        return txtFornecedorMorada;
    }
    
    public JTextField getTxtFornecedorEmail() {
        return txtFornecedorEmail;
    }
    
    public JTextField getTxtFornecedorTelefone() {
        return txtFornecedorTelefone;
    }
    
    public JButton getBotaoFornecedoresAdicionar() {
        return botaoFornecedoresAdicionar;
    } 
    
    public JButton getBotaoFornecedoresEditar() {
        return botaoFornecedoresEditar;
    }
    
    public JButton getBotaoFornecedoresApagar() {
        return botaoFornecedoresApagar;
    }
    
    
    public JDialog getDialogFornecedor() {
        return dialogFornecedor;
    }
    
    public JLabel getLabelHomeProduto() {
        return labelHomeProduto;
    }
    
    public JLabel getLabelHomeFornecedores() {
        return labelHomeFornecedores;
    }
    
    public JLabel getLabelHomeUtilizadores() {
        return labelHomeUtilizador;
    }
    
    public JTable getTabelaFornecedor() {
        return tabelaFornecedores;
    }
}
