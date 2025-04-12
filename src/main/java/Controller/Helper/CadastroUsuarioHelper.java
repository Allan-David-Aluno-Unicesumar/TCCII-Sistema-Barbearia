/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Usuario;
import View.CadastroUsuarioView;
import View.LoginView;
import java.util.Date;

/**
 *
 * @author allan
 */
public class CadastroUsuarioHelper {
    
    private final CadastroUsuarioView view;

    public CadastroUsuarioHelper(CadastroUsuarioView view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
        String nome = view.getCampoNome().getText();
        String cpf = view.getCampoCpf().getText();
        char sexo = view.getCampoSexo().getText().charAt(0);
        String dataNascimento = view.getCampoDataNascimento().getText();
        String telefone = view.getCampoTelefone().getText();
        String email = view.getCampoEmail().getText();
        String senha = view.getCampoSenha().getText();
        String nivelAcesso = view.getCampoNivelAcesso().getText();
        
        Usuario modelo = new Usuario(nome, cpf, sexo, dataNascimento, telefone, email, senha, nivelAcesso);
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String cpf = modelo.getCpf();
        char sexo = modelo.getSexo();
        Date dataNascimento = modelo.getDataNascimento();
        String telefone = modelo.getTelefone();
        String email = modelo.getEmail();
        String senha = modelo.getSenha();
        String nivelAcesso = modelo.getNivelAcesso();
        
        view.getCampoNome().setText(nome);
        view.getCampoCpf().setText(cpf);
        view.getCampoSexo().setText(String.valueOf(sexo));
        view.getCampoDataNascimento().setText(String.valueOf(dataNascimento));
        view.getCampoTelefone().setText(telefone);
        view.getCampoEmail().setText(email);
        view.getCampoSenha().setText(senha);
        view.getCampoNivelAcesso().setText(nivelAcesso);
    }
    
    public void limparTela(){
        view.getCampoNome().setText("");
        view.getCampoCpf().setText("");
        view.getCampoSexo().setText("");
        view.getCampoDataNascimento().setText("");
        view.getCampoTelefone().setText("");
        view.getCampoEmail().setText("");
        view.getCampoSenha().setText("");
        view.getCampoNivelAcesso().setText("");
    }
    
}
