/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.AgendamentoView;
import View.CadastroClienteView;
import View.CadastroFornecedorView;
import View.CadastroProdutoView;
import View.CadastroServicoView;
import View.MenuPrincipalView;

/**
 *
 * @author allan
 */
public class MenuPrincipalController {

    private final MenuPrincipalView view;

    
    public MenuPrincipalController(MenuPrincipalView view) {
        this.view = view;
    }
    
    public void abrirTelaCadastrarCliente(){
        
        CadastroClienteView cadastroClienteView = new CadastroClienteView();
        cadastroClienteView.setVisible(true);
        view.dispose();
    }

    public void abrirTelaCadastrarServico() {
        
        CadastroServicoView cadastroServicoView = new CadastroServicoView();
        cadastroServicoView.setVisible(true);
        view.dispose();
    }

    public void abrirTelaCadastroFornecedor() {
        
        CadastroFornecedorView cadastroFornecedorView = new CadastroFornecedorView();
        cadastroFornecedorView.setVisible(true);
        view.dispose();
    }

    public void abrirTelaCadastrarProduto() {
        
        CadastroProdutoView cadastroProdutoView = new CadastroProdutoView();
        cadastroProdutoView.setVisible(true);
        view.dispose();
    }

    public void abrirTelaAgendamento() {
        
        AgendamentoView agendamentoView = new AgendamentoView();
        agendamentoView.setVisible(true);
        view.dispose();
    }
    
    
}
