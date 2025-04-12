/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author allan
 */
public class UsuarioDAO {
    
    private final EntityManager em;

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }
    
    public Usuario insert(Usuario usuario){
        em.persist(usuario);
        return usuario;
    }
    
    public Usuario update(Usuario usuario){
        em.merge(usuario);
        em.persist(usuario);
        return usuario;
    }
    
    public Usuario insertOrUpdate(Usuario usuario){
        if(usuario.getId() > 0){
            return update(usuario);
        }else{
            return insert(usuario);
        }
    }
    
    public void delete(Usuario usuario){
        em.merge(usuario);
        em.remove(usuario);
    }
    
    public List<Usuario> selectAll(){
        //SQL,  JPQL
        String jpql = "select u from Usuario as u";
        Query query = em.createQuery(jpql);
        
        return retornarListaConformeConsulta(query);
    }

    private List<Usuario> retornarListaConformeConsulta(Query query) {
        List<Usuario> usuarios;
        try{
            usuarios = query.getResultList();
        }catch(NoResultException e){
            usuarios = new ArrayList<Usuario>();
        } 
        return usuarios;
    }
    
    public boolean existeNoBancoPorUsuarioESenha(Usuario usuarioNovo){
        String jpql = "select u from Usuario as u "
                + "where u.nome = :pUsuario and u.senha = :pSenha";
        
        Query query = em.createQuery(jpql);
        query.setParameter("pUsuario", usuarioNovo.getNome());
        query.setParameter("pSenha", usuarioNovo.getSenha());
        
        return !retornarListaConformeConsulta(query).isEmpty();
    }
    
    public Usuario selectPorId(Usuario usuario){
        return em.find(Usuario.class, usuario);
    }
}
