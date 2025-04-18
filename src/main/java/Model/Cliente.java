/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author allan
 */
@Entity
public class Cliente extends Pessoa{
 
    private String apelido;
    private String endereco;

    
    public Cliente() {
    }

    
    public Cliente(String nome, String cpf, char sexo, String dataNascimento, String telefone, String email, String apelido, String endereco) {
        super(nome, cpf, sexo, dataNascimento, telefone, email);
        this.apelido = apelido;
        this.endereco = endereco;
    }


    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    @Override
    public String toString(){
        return super.getNome();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
    return Objects.equals(id, cliente.id); // Comparação por ID
    }

    @Override
        public int hashCode() {
        return Objects.hash(id);
    }
    

    
    

    

}
