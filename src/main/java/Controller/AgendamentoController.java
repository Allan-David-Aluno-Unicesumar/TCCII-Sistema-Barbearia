/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendamentoHelper;
import Dao.AgendamentoDAO;
import Dao.ClienteDAO;
import Dao.JPAUtil;
import Dao.ServicoDAO;
import Dao.UsuarioDAO;
import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;
import View.AgendamentoView;
import View.MenuPrincipalView;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class AgendamentoController {
    
    private final AgendamentoView view;
    private AgendamentoHelper helper;

    public AgendamentoController(AgendamentoView view) {
        this.view = view;
        this.helper = new AgendamentoHelper(view);
    }
    
    public void atualizarTabela(){
        
        // Buscar lista de agendamentos no banco de dados
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO(em);
        List<Agendamento> agendamentos = agendamentoDAO.selectAll();
            
        em.getTransaction().commit();
        em.close();
        
        // Exibir a lista na view
        helper.preencherTabela(agendamentos);
    }
    
    public void atualizarCliente(){
        
        // Buscar lista de clientes no banco de dados
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        ClienteDAO clienteDAO = new ClienteDAO(em);
        List<Cliente> clientes = clienteDAO.selectAll();
            
        em.getTransaction().commit();
        em.close();
        
        // Exibir a lista no jComboBox
        helper.preencherClientes(clientes);
    }
    
    public void atualizarServico(){
        
        // Buscar lista de servicos no banco de dados
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        ServicoDAO servicoDAO = new ServicoDAO(em);
        List<Servico> servicos = servicoDAO.selectAll();
            
        em.getTransaction().commit();
        em.close();
        
        // Exibir a lista no jComboBox
        helper.preencherServicos(servicos);
    }
    
    public void atualizarUsuario(){
        
        // Buscar lista de usuarios no banco de dados
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        UsuarioDAO usuarioDAO = new UsuarioDAO(em);
        List<Usuario> usuarios = usuarioDAO.selectAll();
            
        em.getTransaction().commit();
        em.close();
        
        // Exibir a lista no jComboBox
        helper.preencherUsuarios(usuarios);
    }
    
    public void agendar() {
        
       Agendamento agendamento = helper.obterModelo();
       
       EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        new AgendamentoDAO(em).insert(agendamento);
            
        em.getTransaction().commit();
        em.close();
        JOptionPane.showMessageDialog(null, "Agendamento cadastrado com sucesso!");
    }

    public void voltarParaMenuPrincipal() {
        
        MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
        menuPrincipalView.setVisible(true);
        view.dispose();
    }
    
    
    
}
