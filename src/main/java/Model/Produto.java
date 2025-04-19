/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author allan
 */
@Entity
public class Produto extends Item{
    
    private double valorCusto;
    private double taxaLucro;
    private int qtd;
    private int estoque;
    
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    
    public Produto() {
    }

    
    public Produto(String descricao, double valorCusto, double taxaLucro, int qtd, int estoque, Fornecedor fornecedor) {
        super(descricao);
        this.valorCusto = valorCusto;
        this.taxaLucro = taxaLucro;
        this.qtd = qtd;
        this.estoque = estoque;
        this.fornecedor = fornecedor;
    }
    
    
    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getTaxaLucro() {
        return taxaLucro;
    }

    public void setTaxaLucro(double taxaLucro) {
        this.taxaLucro = taxaLucro;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public double getValorVenda() {
        return valorVenda = this.valorCusto * (1 + this.taxaLucro/100);
    }

    @Override
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    @Override
    public String toString(){
        return super.getDescricao();
    }
    
}
