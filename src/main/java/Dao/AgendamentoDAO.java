/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Agendamento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author allan
 */
public class AgendamentoDAO {
    
    private final EntityManager em;

    public AgendamentoDAO(EntityManager em) {
        this.em = em;
    }
    
    public Agendamento insert(Agendamento agendamento){
        em.persist(agendamento);
        return agendamento;
    }
    
    public Agendamento update(Agendamento agendamento){
        em.merge(agendamento);
        em.persist(agendamento);
        return agendamento;
    }
    
    public Agendamento insertOrUpdate(Agendamento agendamento){
        if(agendamento.getId() > 0){
            return update(agendamento);
        }else{
            return insert(agendamento);
        }
    }
    
    public void delete(Agendamento agendamento){
        em.merge(agendamento);
        em.remove(agendamento);
    }
    
    public List<Agendamento> selectAll(){
        //SQL,  JPQL
        String jpql = "select u from Agendamento as u";
        Query query = em.createQuery(jpql);
        
        return retornarListaConformeConsulta(query);
    }

    private List<Agendamento> retornarListaConformeConsulta(Query query) {
        List<Agendamento> agendamentos;
        try{
            agendamentos = query.getResultList();
        }catch(NoResultException e){
            agendamentos = new ArrayList<Agendamento>();
        } 
        return agendamentos;
    }
    
    public Agendamento selectPorId(Agendamento agendamento){
        return em.find(Agendamento.class, agendamento);
    }
}
