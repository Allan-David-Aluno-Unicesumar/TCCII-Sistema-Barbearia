/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Produto;
import View.CadastroProdutoView;

/**
 *
 * @author allan
 */
public class CadastroProdutoHelper implements IHelper{
    
    private final CadastroProdutoView view;

    public CadastroProdutoHelper(CadastroProdutoView view) {
        this.view = view;
    }
    
    public Produto obterModelo(){
        String descricao = view.getCampoDescricao().getText();
        double valorCusto = Double.parseDouble(view.getCampoValorCusto().getText());
        double taxaLucro = Double.parseDouble(view.getCampoTaxaLucro().getText());
        int qtd = Integer.parseInt(view.getCampoQtd().getText());
        int estoque = Integer.parseInt(view.getCampoEstoque().getText());
        
        Produto modelo = new Produto(descricao, valorCusto, taxaLucro, qtd, estoque);
        return modelo;
    }
    
    public void setarModelo(Produto modelo){
        String descricao = modelo.getDescricao();
        double valorCusto = modelo.getValorCusto();
        double taxaLucro = modelo.getTaxaLucro();
        int qtd = modelo.getQtd();
        int estoque = modelo.getEstoque();
        
        
        view.getCampoDescricao().setText(descricao);
        view.getCampoValorCusto().setText(String.valueOf(valorCusto));
        view.getCampoTaxaLucro().setText(String.valueOf(taxaLucro));
        view.getCampoQtd().setText(String.valueOf(qtd));
        view.getCampoEstoque().setText(String.valueOf(estoque));
        
    }
    
    public void limparTela(){
        view.getCampoDescricao().setText("");
        view.getCampoValorCusto().setText("");
        view.getCampoTaxaLucro().setText("");
        view.getCampoQtd().setText("");
        view.getCampoEstoque().setText("");
        

    }
    
}
