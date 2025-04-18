/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Produto;
import Model.Servico;
import Model.Usuario;
import Model.Venda;
import View.VendaView;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author allan
 */
public class VendaHelper implements IHelper{
    
    private final VendaView view;

    public VendaHelper(VendaView view) {
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
    
    public void preencherProdutos(List<Produto> produtos) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getComboBoxProduto().getModel();
        
        for (Produto produto : produtos) {
            comboBoxModel.addElement(produto);
        }
    }
    
    public Servico obterServico() {
        return (Servico) view.getComboBoxServico().getSelectedItem();
    }
    
    public Cliente obterCliente() {
        return (Cliente) view.getComboBoxCliente().getSelectedItem();
    }
    
    public Usuario obterUsuario() {
        return (Usuario) view.getComboBoxUsuario().getSelectedItem();
    }
    
    public Produto obterProduto() {
        return (Produto) view.getComboBoxProduto().getSelectedItem();
    }
    
    public void exibirValorServico(double valorServico) {
        view.getCampoSubvalorServico().setText(String.valueOf(valorServico));
    }
    
    public void exibirValorProduto(double valorProduto) {
        view.getCampoSubvalorProduto().setText(String.valueOf(valorProduto));
    }
    
    public void setarSomaValores() {
    
        double valorServico = 0.0;
        double valorProduto = 0.0;

        try {
            valorServico = Double.parseDouble(view.getCampoSubvalorServico().getText().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        try {
            valorProduto = Double.parseDouble(view.getCampoSubvalorProduto().getText().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        double valorTotal = valorServico + valorProduto;
        view.getCampoValorTotal().setText(String.valueOf(valorTotal));
    }
    
    public Venda obterModelo(){
        String data = view.getCampoData().getText()+" "+view.getCampoHora().getText();
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        Usuario usuario = obterUsuario();
        Produto produto = obterProduto();
        double valorServico = Double.parseDouble(view.getCampoSubvalorServico().getText());
        double valorProduto = Double.parseDouble(view.getCampoSubvalorProduto().getText());
        double valorTotal = valorServico + valorProduto;
        String formaPagamento = (String) view.getComboBoxFormaPagamento().getSelectedItem();

        
        Venda modelo = new Venda (data, cliente, servico, usuario, produto, valorTotal, formaPagamento);
        return modelo;
    }
   
    public void setarModelo(Venda modelo){
        String data = modelo.getDataFormatada();
        String hora = modelo.getHoraFormatada();
        Cliente cliente = modelo.getCliente();
        Servico servico = modelo.getServico();
        Usuario usuario = modelo.getUsuario();
        Produto produto = modelo.getProduto();
        double valorTotal = modelo.getValorTotal();
        String formaPagamento = modelo.getFormaPagamento();
        
        
        view.getComboBoxCliente().setSelectedItem(cliente);
        view.getComboBoxServico().setSelectedItem(servico);
        view.getComboBoxUsuario().setSelectedItem(usuario);
        view.getComboBoxProduto().setSelectedItem(produto);
        view.getCampoValorTotal().setText(String.valueOf(valorTotal));
        view.getCampoData().setText(data);
        view.getCampoHora().setText(hora);
        view.getComboBoxFormaPagamento().setSelectedItem(formaPagamento);
    }
    
    public void limparTela(){
        view.getCampoValorTotal().setText("");
        view.getCampoData().setText("");
        view.getCampoHora().setText("");

    }

    public Agendamento obterAgendamentoDaTabela(int linhaSelecionada) {
        
        DefaultTableModel model = (DefaultTableModel) view.getTableAgendamentos().getModel();
        Agendamento agendamento = new Agendamento();
        
        agendamento.setCliente((Cliente) model.getValueAt(linhaSelecionada, 1));
        agendamento.setServico((Servico) model.getValueAt(linhaSelecionada, 2));
        agendamento.setBarbeiro((Usuario) model.getValueAt(linhaSelecionada, 3));
        agendamento.setValor((double) model.getValueAt(linhaSelecionada, 4));
        agendamento.setDataFormatada((String) model.getValueAt(linhaSelecionada, 5));
        agendamento.setHoraFormatada((String) model.getValueAt(linhaSelecionada, 6));
        
        return agendamento;
    }

    public void preencherCampos(Agendamento agendamento) {

        view.getComboBoxCliente().setSelectedItem(agendamento.getCliente());
        view.getComboBoxServico().setSelectedItem(agendamento.getServico());
        view.getComboBoxUsuario().setSelectedItem(agendamento.getUsuario());
        view.getCampoSubvalorServico().setText(String.valueOf(agendamento.getValor()));
        view.getCampoData().setText(agendamento.getDataFormatada());
        view.getCampoHora().setText(agendamento.getHoraFormatada());
    }

   
    
}
