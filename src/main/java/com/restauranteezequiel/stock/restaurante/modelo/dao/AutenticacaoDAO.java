/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restauranteezequiel.stock.restaurante.modelo.dao;

import com.restauranteezequiel.stock.restaurante.modelo.dominio.Utilizador;
import com.restauranteezequiel.stock.restaurante.view.modelo.LoginDTO;
import com.restauranteezequiel.stock.restaurante.view.modelo.exception.NegocioException;
import javax.swing.JOptionPane;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author sara
 */
public class AutenticacaoDAO {
    
    private final UtilizadorDAO utilizadorDao;

    public AutenticacaoDAO() {
        this.utilizadorDao = new UtilizadorDAO();
    }


    public Utilizador login (LoginDTO login){
        Utilizador utilizador = utilizadorDao.buscarUtilizadorPeloUsername(login.getUtilizador());
        
        if (utilizador == null) {
            System.out.println("Usuário não encontrado");
            return null;
        } else {
            utilizador.setEstado(true);
        }

        if (!utilizador.isEstado()) {
            System.out.println("Usuário está inativo");
            return null;
        }

        if (validaSenha(utilizador.getSenha(), login.getSenha())) {
            System.out.println("Login bem-sucedido!");
            return utilizador;
        } else {
            System.out.println("Senha incorreta");
            return null;
        }
    }

    private boolean validaSenha(String senhaUtilizador, String senhaLogin) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //o primeiro paragrafo é a senha que NÃO está encriptografada
        //o segundo é a senha QUE ESTÁ encriptografda
        return passwordEncoder.matches(senhaLogin, senhaUtilizador);
    }
    
    
    //Método para autorizar na aplicação
    public boolean temPermissao (Utilizador u){
        try{
            permissao(u);
            return true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Utilizador sem permissão.", 0);
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }
    
    private void permissao(Utilizador u) {
        if(!u.getTipo_utilizador().equals("Chefe") && !u.getTipo_utilizador().equals("Gerente")) {
            throw new NegocioException("Sem permissão para realizar essa ação.");
        }
    }
    
    
    //Permissão apenas para o chefe => Relatorio
    public boolean temPermissaoChefe (Utilizador u){
        try{
            permissaoChefe(u);
            return true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Utilizador sem permissão.", 0);
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }
    
    private void permissaoChefe(Utilizador u) {
        if(!u.getTipo_utilizador().equals("Chefe")) {
            throw new NegocioException("Sem permissão para realizar essa ação.");
        }
    }
}
