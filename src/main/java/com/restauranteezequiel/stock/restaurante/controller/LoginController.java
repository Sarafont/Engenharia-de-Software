/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.controller;

import com.restauranteezequiel.stock.restaurante.modelo.dao.AutenticacaoDAO;
import com.restauranteezequiel.stock.restaurante.modelo.dominio.Utilizador;
import com.restauranteezequiel.stock.restaurante.view.formulario.Dashboard;
import com.restauranteezequiel.stock.restaurante.view.formulario.Login;
import com.restauranteezequiel.stock.restaurante.view.modelo.LoginDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author sara
 */
public class LoginController implements ActionListener {
    
    private final Login login;
    private final AutenticacaoDAO autenticacaoDao;

    public LoginController(Login login) {
        this.login = login;
        autenticacaoDao = new AutenticacaoDAO();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao) {
            case "login": login(); break;
            case "cancelar": cancelar(); break;                                
        }
    }

    private void login(){
       String username = this.login.getTxtLoginUtilizador().getText();
       String senha = this.login.getTxtLoginSenha().getText();
       
       if(username.equals("") || senha.equals("")){
           this.login.getLabelLoginMensagem().setText("Utilizador e senha devem ser preenchidos.");
           return;
       }
       
       LoginDTO loginDto = new LoginDTO(username, senha);
       Utilizador utilizador = autenticacaoDao.login(loginDto);
       
       if(utilizador != null){
           System.out.println("Sucesso: " + utilizador.getUsername());
           Dashboard dashboard = new Dashboard();
           dashboard.setVisible(true);
           dashboard.getLabelBenvindoUtilizador().setText(String.format("Bem-vindo %s", utilizador.getNome()));
            dashboard.getLabelUtilizadorLogadoId().setText(Long.toString(utilizador.getId()));
            this.login.setVisible(false);
            limpaTela();
       } else {
           this.login.getLabelLoginMensagem().setText("Utilizador ou senha incorretos.");
       } 
    }

    private void cancelar() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem a certeza de que deseja sair?","Sair do login", JOptionPane.YES_NO_OPTION);
    
        if (confirma == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    
    private void limpaTela() {
        login.getLabelLoginMensagem().setText("");
        login.getTxtLoginUtilizador().setText("");
        login.getTxtLoginSenha().setText("");
    }
    
}
