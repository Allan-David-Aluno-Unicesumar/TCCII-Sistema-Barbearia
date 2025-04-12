/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allan
 */
public class Venda{
    
    private int id;
    private Date data;
    private Cliente cliente;
    private Servico servico;
    private Produto produto;
    private double valorTotal;
    private String formaPagamento;

    
    public Venda() {
    }

    
    public Venda(int id, String data, Cliente cliente, Servico servico, Produto produto, double valorTotal, String formaPagamento) {
        this.id = id;
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.cliente = cliente;
        this.servico = servico;
        this.produto = produto;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    
    public Venda(int id, String data, Cliente cliente, Servico servico, double valorTotal, String formaPagamento) {
        this.id = id;
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.cliente = cliente;
        this.servico = servico;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    
    public Venda(int id, String data, Cliente cliente, Produto produto, double valorTotal, String formaPagamento) {
        this.id = id;
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.cliente = cliente;
        this.produto = produto;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    
    
}
    
    
    
    
    
   
