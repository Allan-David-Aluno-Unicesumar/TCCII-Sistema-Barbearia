/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author allan
 */
public class FornecedorDAO {
    
    private final EntityManager em;

    public FornecedorDAO(EntityManager em) {
        this.em = em;
    }
    
    public Fornecedor insert(Fornecedor fornecedor){
        em.persist(fornecedor);
        return fornecedor;
    }
    
    public Fornecedor update(Fornecedor fornecedor){
        em.merge(fornecedor);
        em.persist(fornecedor);
        return fornecedor;
    }
    
    public Fornecedor insertOrUpdate(Fornecedor fornecedor){
        if(fornecedor.getId() > 0){
            return update(fornecedor);
        }else{
            return insert(fornecedor);
        }
    }
    
    public void delete(Fornecedor fornecedor){
        em.merge(fornecedor);
        em.remove(fornecedor);
    }
    
    public List<Fornecedor> selectAll(){
        //SQL,  JPQL
        String jpql = "select u from Fornecedor as u";
        Query query = em.createQuery(jpql);
        
        return retornarListaConformeConsulta(query);
    }

    private List<Fornecedor> retornarListaConformeConsulta(Query query) {
        List<Fornecedor> fornecedores;
        try{
            fornecedores = query.getResultList();
        }catch(NoResultException e){
            fornecedores = new ArrayList<Fornecedor>();
        } 
        return fornecedores;
    }
    
    public Fornecedor selectPorId(Fornecedor fornecedor){
        return em.find(Fornecedor.class, fornecedor);
    }
}
