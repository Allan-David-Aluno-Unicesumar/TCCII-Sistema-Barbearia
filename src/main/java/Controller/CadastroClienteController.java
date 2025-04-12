/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.CadastroClienteHelper;
import Model.Cliente;
import View.CadastroClienteView;
import View.MenuPrincipalView;
import Dao.ClienteDAO;
import Dao.JPAUtil;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class CadastroClienteController {
    
    private final CadastroClienteView view;
    private CadastroClienteHelper helper;

    
    public CadastroClienteController(CadastroClienteView view) {
        this.view = view;
        this.helper = new CadastroClienteHelper(view);
    }
    
    
    public void cadastrarCliente() throws SQLException{
        
        Cliente cliente = helper.obterModelo();
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        new ClienteDAO(em).insert(cliente);
            
        em.getTransaction().commit();
        em.close();
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }
    
    public void voltarParaMenuPrincipal(){
        
        MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
        menuPrincipalView.setVisible(true);
        view.dispose();
    }
}
