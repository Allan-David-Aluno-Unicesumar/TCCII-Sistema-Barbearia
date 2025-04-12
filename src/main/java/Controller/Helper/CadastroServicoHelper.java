/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Servico;
import View.CadastroServicoView;

/**
 *
 * @author allan
 */
public class CadastroServicoHelper {
    
    private final CadastroServicoView view;

    public CadastroServicoHelper(CadastroServicoView view) {
        this.view = view;
    }
    
    public Servico obterModelo(){
        String descricao = view.getCampoDescricao().getText();
        double valor = Double.parseDouble(view.getCampoValor().getText());
        String tempoEstimado = view.getCampoTempoEstimado().getText();
        
        Servico modelo = new Servico(descricao, valor, tempoEstimado);
        return modelo;
    }
    
    public void setarModelo(Servico modelo){
        String descricao = modelo.getDescricao();
        double valor = modelo.getValorVenda();
        String tempoEstimado = modelo.getTempoEstimado();
        
        
        view.getCampoDescricao().setText(descricao);
        view.getCampoValor().setText(String.valueOf(valor));
        view.getCampoTempoEstimado().setText(tempoEstimado);
        
    }
    
    public void limparTela(){
        view.getCampoDescricao().setText("");
        view.getCampoValor().setText("");
        view.getCampoTempoEstimado().setText("");
        

    }
    
}
