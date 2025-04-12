/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;
import View.AgendamentoView;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author allan
 */
public class AgendamentoHelper {
    
    private final AgendamentoView view;

    public AgendamentoHelper(AgendamentoView view) {
        this.view = view;
    }
    
    public void preencherTabela(List<Agendamento> agendamentos) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        // Percorrer lista inserindo valores
        for (Agendamento agendamento : agendamentos) {
            
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente(),
                agendamento.getServico(),
                agendamento.getUsuario(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            });
            
        }
    }
    
    public void preencherClientes(List<Cliente> clientes) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getComboBoxCliente().getModel();
        
        for (Cliente cliente : clientes) {
            comboBoxModel.addElement(cliente);
        }
    }
    
    public void preencherServicos(List<Servico> servicos) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getComboBoxServico().getModel();
        
        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico);
        }
    }
    
    public void preencherUsuarios(List<Usuario> usuarios) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getComboBoxUsuario().getModel();
        
        for (Usuario usuario : usuarios) {
            comboBoxModel.addElement(usuario);
        }
    }
    
    public Agendamento obterModelo(){
        Cliente cliente = (Cliente) view.getComboBoxCliente().getSelectedItem();
        Servico servico = (Servico) view.getComboBoxServico().getSelectedItem();
        Usuario usuario = (Usuario) view.getComboBoxUsuario().getSelectedItem();
        double valor = Double.parseDouble(view.getCampoValor().getText());
        String data = view.getCampoData().getText()+" "+view.getCampoHora().getText();
        String observacao = view.getAreaObservacao().getText();
        
        Agendamento modelo = new Agendamento(cliente, servico, usuario, valor, data, observacao);
        return modelo;
    }
   
    public void setarModelo(Agendamento modelo){
        Cliente cliente = modelo.getCliente();
        Servico servico = modelo.getServico();
        Usuario usuario = modelo.getUsuario();
        double valor = modelo.getValor();
        String data = modelo.getDataFormatada();
        String hora = modelo.getHoraFormatada();
        String observacao = modelo.getObservacao();
        
        view.getComboBoxCliente().setSelectedItem(cliente);
        view.getComboBoxServico().setSelectedItem(servico);
        view.getComboBoxUsuario().setSelectedItem(usuario);
        view.getCampoValor().setText(String.valueOf(valor));
        view.getCampoData().setText(data);
        view.getCampoHora().setText(hora);
        view.getAreaObservacao().setText(observacao);
        
    }
    public void limparTela(){
        view.getComboBoxCliente().setSelectedItem("");
        view.getComboBoxServico().setSelectedItem("");
        view.getComboBoxUsuario().setSelectedItem("");
        view.getCampoValor().setText("");
        view.getCampoData().setText("");
        view.getCampoHora().setText("");
        view.getAreaObservacao().setText("");

    }

    

    
    
}
