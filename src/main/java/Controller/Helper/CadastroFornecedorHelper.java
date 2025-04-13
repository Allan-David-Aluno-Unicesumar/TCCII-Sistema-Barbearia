/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Fornecedor;
import View.CadastroFornecedorView;

/**
 *
 * @author allan
 */
public class CadastroFornecedorHelper implements IHelper{
    
    private final CadastroFornecedorView view;

    public CadastroFornecedorHelper(CadastroFornecedorView view) {
        this.view = view;
    }
    
    public Fornecedor obterModelo(){
        String razaoSocial = view.getCampoRazaoSocial().getText();
        String nomeFantasia = view.getCampoNomeFantasia().getText();
        String cnpj = view.getCampoCnpj().getText();
        String telefone = view.getCampoTelefone().getText();
        String email = view.getCampoEmail().getText();

        Fornecedor modelo = new Fornecedor(razaoSocial, nomeFantasia, cnpj, telefone, email);
        return modelo;
    }
    
    public void setarModelo(Fornecedor modelo){
        String razaoSocial = modelo.getRazaoSocial();
        String nomeFantasia = modelo.getNomeFantasia();
        String cnpj = modelo.getCnpj();
        String telefone = modelo.getTelefone();
        String email = modelo.getEmail();
        
        view.getCampoRazaoSocial().setText(razaoSocial);
        view.getCampoNomeFantasia().setText(nomeFantasia);
        view.getCampoCnpj().setText(cnpj);
        view.getCampoTelefone().setText(telefone);
        view.getCampoEmail().setText(email);
        
    }
    
    public void limparTela(){
        view.getCampoRazaoSocial().setText("");
        view.getCampoNomeFantasia().setText("");
        view.getCampoCnpj().setText("");
        view.getCampoTelefone().setText("");
        view.getCampoEmail().setText("");

    }
    
}
