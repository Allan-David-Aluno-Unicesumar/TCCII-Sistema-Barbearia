/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Usuario;
import View.LoginView;

/**
 *
 * @author allan
 */
public class LoginHelper {
    
    private final LoginView view;

    public LoginHelper(LoginView view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
        String usuario = view.getCampoUsuario().getText();
        String senha = view.getCampoSenha().getText();
        Usuario modelo = new Usuario(usuario, senha);
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getCampoUsuario().setText(nome);
        view.getCampoSenha().setText(senha);
    }
    
    public void limparTela(){
        view.getCampoUsuario().setText("");
        view.getCampoSenha().setText("");
    }
    
}
