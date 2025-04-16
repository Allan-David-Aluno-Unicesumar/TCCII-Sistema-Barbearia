/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Controller.Helper.VendaHelper;
import Dao.AgendamentoDAO;
import Dao.ClienteDAO;
import Dao.JPAUtil;
import Dao.ProdutoDAO;
import Dao.ServicoDAO;
import Dao.UsuarioDAO;
import Dao.VendaDAO;
import Model.Agendamento;
import Model.Cliente;
import Model.Produto;
import Model.Servico;
import Model.Usuario;
import Model.Venda;
import View.MenuPrincipalView;
import View.VendaView;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class VendaController {
    
    private final VendaView view;
    private VendaHelper helper;

    public VendaController(VendaView view) {
        this.view = view;
        this.helper = new VendaHelper(view);
    }
    
    public void atualizarTabelaAgendamentos(){
        
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
    
    public void atualizarValorServico(){
        
        Servico servico = helper.obterServico();
        helper.exibirValorServico(servico.getValorVenda());
        
    }
    
    public void atualizarValorProduto(){
        
        Produto produto = helper.obterProduto();
        helper.exibirValorProduto(produto.getValorVenda());
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
    
    public void atualizarProduto(){
        
        // Buscar lista de usuarios no banco de dados
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        List<Produto> produtos = produtoDAO.selectAll();
            
        em.getTransaction().commit();
        em.close();
        
        // Exibir a lista no jComboBox
        helper.preencherProdutos(produtos);
    }
    
    public void vender() {
        
        // Obtem objeto da tela
        Venda venda = helper.obterModelo();
        
        // Salva no banco de dados
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        new VendaDAO(em).insert(venda);
            
        em.getTransaction().commit();
        em.close();
        JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
        

        helper.limparTela();
    }

    public void voltarParaMenuPrincipal() {
        
        MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
        menuPrincipalView.setVisible(true);
        view.dispose();
    }

    
    
    
}
