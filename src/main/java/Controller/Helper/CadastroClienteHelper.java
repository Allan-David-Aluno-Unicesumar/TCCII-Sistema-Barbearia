/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Cliente;
import View.CadastroClienteView;
import java.util.Date;

/**
 *
 * @author allan
 */
public class CadastroClienteHelper implements IHelper{
    
    private final CadastroClienteView view;

    public CadastroClienteHelper(CadastroClienteView view) {
        this.view = view;
    }
    
    public Cliente obterModelo(){
        String nome = view.getCampoNome().getText();
        String cpf = view.getCampoCpf().getText();
        char sexo = view.getCampoSexo().getText().charAt(0);
        String dataNascimento = view.getCampoDataNascimento().getText();
        String telefone = view.getCampoTelefone().getText();
        String email = view.getCampoEmail().getText();
        String apelido = view.getCampoApelido().getText();
        String endereco = view.getCampoEndereco().getText();
        
        Cliente modelo = new Cliente(nome, cpf, sexo, dataNascimento, telefone, email, apelido, endereco);
        return modelo;
    }
    
    public void setarModelo(Cliente modelo){
        String nome = modelo.getNome();
        String cpf = modelo.getCpf();
        char sexo = modelo.getSexo();
        Date dataNascimento = modelo.getDataNascimento();
        String telefone = modelo.getTelefone();
        String email = modelo.getEmail();
        String apelido = modelo.getApelido();
        String endereco = modelo.getEndereco();
        
        view.getCampoNome().setText(nome);
        view.getCampoCpf().setText(cpf);
        view.getCampoSexo().setText(String.valueOf(sexo));
        view.getCampoDataNascimento().setText(String.valueOf(dataNascimento));
        view.getCampoTelefone().setText(telefone);
        view.getCampoEmail().setText(email);
        view.getCampoApelido().setText(apelido);
        view.getCampoEndereco().setText(endereco);
    }
    
    public void limparTela(){
        view.getCampoNome().setText("");
        view.getCampoCpf().setText("");
        view.getCampoSexo().setText("");
        view.getCampoDataNascimento().setText("");
        view.getCampoTelefone().setText("");
        view.getCampoEmail().setText("");
        view.getCampoApelido().setText("");
        view.getCampoEndereco().setText("");

    }
    
}
