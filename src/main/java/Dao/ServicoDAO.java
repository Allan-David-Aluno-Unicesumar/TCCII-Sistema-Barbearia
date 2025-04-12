/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Servico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author allan
 */
public class ServicoDAO {
    
    private final EntityManager em;

    public ServicoDAO(EntityManager em) {
        this.em = em;
    }
    
    public Servico insert(Servico servico){
        em.persist(servico);
        return servico;
    }
    
    public Servico update(Servico servico){
        em.merge(servico);
        em.persist(servico);
        return servico;
    }
    
    public Servico insertOrUpdate(Servico servico){
        if(servico.getId() > 0){
            return update(servico);
        }else{
            return insert(servico);
        }
    }
    
    public void delete(Servico servico){
        em.merge(servico);
        em.remove(servico);
    }
    
    public List<Servico> selectAll(){
        //SQL,  JPQL
        String jpql = "select u from Servico as u";
        Query query = em.createQuery(jpql);
        
        return retornarListaConformeConsulta(query);
    }

    private List<Servico> retornarListaConformeConsulta(Query query) {
        List<Servico> servicos;
        try{
            servicos = query.getResultList();
        }catch(NoResultException e){
            servicos = new ArrayList<Servico>();
        } 
        return servicos;
    }
    
    public Servico selectPorId(Servico servico){
        return em.find(Servico.class, servico);
    }
}
