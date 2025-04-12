/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author allan
 */
public class ProdutoDAO {
    
    private final EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }
    
    public Produto insert(Produto produto){
        em.persist(produto);
        return produto;
    }
    
    public Produto update(Produto produto){
        em.merge(produto);
        em.persist(produto);
        return produto;
    }
    
    public Produto insertOrUpdate(Produto produto){
        if(produto.getId() > 0){
            return update(produto);
        }else{
            return insert(produto);
        }
    }
    
    public void delete(Produto produto){
        em.merge(produto);
        em.remove(produto);
    }
    
    public List<Produto> selectAll(){
        //SQL,  JPQL
        String jpql = "select u from Produto as u";
        Query query = em.createQuery(jpql);
        
        return retornarListaConformeConsulta(query);
    }

    private List<Produto> retornarListaConformeConsulta(Query query) {
        List<Produto> produtos;
        try{
            produtos = query.getResultList();
        }catch(NoResultException e){
            produtos = new ArrayList<Produto>();
        } 
        return produtos;
    }
    
    public Produto selectPorId(Produto produto){
        return em.find(Produto.class, produto);
    }
}
