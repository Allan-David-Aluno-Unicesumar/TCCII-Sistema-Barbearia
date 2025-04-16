/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author allan
 */
public class VendaDAO {
    
    private final EntityManager em;

    public VendaDAO(EntityManager em) {
        this.em = em;
    }
    
    public Venda insert(Venda venda){
        em.persist(venda);
        return venda;
    }
    
    public Venda update(Venda venda){
        em.merge(venda);
        em.persist(venda);
        return venda;
    }
    
    public Venda insertOrUpdate(Venda venda){
        if(venda.getId() > 0){
            return update(venda);
        }else{
            return insert(venda);
        }
    }
    
    public void delete(Venda venda){
        em.merge(venda);
        em.remove(venda);
    }
    
    public List<Venda> selectAll(){
        //SQL,  JPQL
        String jpql = "select u from Venda as u";
        Query query = em.createQuery(jpql);
        
        return retornarListaConformeConsulta(query);
    }

    private List<Venda> retornarListaConformeConsulta(Query query) {
        List<Venda> vendas;
        try{
            vendas = query.getResultList();
        }catch(NoResultException e){
            vendas = new ArrayList<Venda>();
        } 
        return vendas;
    }
    
    public Venda selectPorId(Venda venda){
        return em.find(Venda.class, venda);
    }
}
