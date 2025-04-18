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
public class Usuario extends Pessoa{
    
    private String senha;
    private String nivelAcesso;

    
    public Usuario() {
    }


    public Usuario(String nome, String cpf, char sexo, String dataNascimento, String telefone, String email, String senha, String nivelAcesso) {
        super(nome, cpf, sexo, dataNascimento, telefone, email);
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }
    
    
    public Usuario(String nome, String senha) {
        super(nome);
        this.senha = senha;
    }
    
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    
    @Override
    public String toString(){
        return super.getNome();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
    return Objects.equals(id, usuario.id); // Comparação por ID
    }

    @Override
        public int hashCode() {
        return Objects.hash(id);
    }
    
    

     
}
