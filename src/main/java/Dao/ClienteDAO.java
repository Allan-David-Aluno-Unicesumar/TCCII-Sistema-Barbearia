/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author allan
 */
public class ClienteDAO {
    
    private final EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }
    
    public Cliente insert(Cliente cliente){
        em.persist(cliente);
        return cliente;
    }
    
    public Cliente update(Cliente cliente){
        em.merge(cliente);
        em.persist(cliente);
        return cliente;
    }
    
    public Cliente insertOrUpdate(Cliente cliente){
        if(cliente.getId() > 0){
            return update(cliente);
        }else{
            return insert(cliente);
        }
    }
    
    public void delete(Cliente cliente){
        em.merge(cliente);
        em.remove(cliente);
    }
    
    public List<Cliente> selectAll(){
        //SQL,  JPQL
        String jpql = "select u from Cliente as u";
        Query query = em.createQuery(jpql);
        
        return retornarListaConformeConsulta(query);
    }

    private List<Cliente> retornarListaConformeConsulta(Query query) {
        List<Cliente> clientes;
        try{
            clientes = query.getResultList();
        }catch(NoResultException e){
            clientes = new ArrayList<Cliente>();
        } 
        return clientes;
    }
    
    public Cliente selectPorId(Cliente cliente){
        return em.find(Cliente.class, cliente);
    }
}
