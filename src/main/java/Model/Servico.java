/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author allan
 */
@Entity
public class Servico extends Item{
    
    private String tempoEstimado;

    
    public Servico() {
    }

    public Servico(String descricao, double valorVenda, String tempoEstimado) {
        super(descricao, valorVenda);
        this.tempoEstimado = tempoEstimado;
    }

    public String getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(String tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    
    @Override
    public String toString(){
        return super.getDescricao();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
    return Objects.equals(id, servico.id); // Comparação por ID
    }

    @Override
        public int hashCode() {
        return Objects.hash(id);
    }
    
}
