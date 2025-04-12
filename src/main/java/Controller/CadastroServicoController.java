/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.CadastroServicoHelper;
import Dao.JPAUtil;
import Dao.ServicoDAO;
import Model.Servico;
import View.CadastroServicoView;
import View.MenuPrincipalView;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class CadastroServicoController {
    
    private final CadastroServicoView view;
    private CadastroServicoHelper helper;

    
    public CadastroServicoController(CadastroServicoView view) {
        this.view = view;
        this.helper = new CadastroServicoHelper(view);
    }
    
    
    public void cadastrarServico() throws SQLException{
        
        Servico servico = helper.obterModelo();
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        new ServicoDAO(em).insert(servico);
            
        em.getTransaction().commit();
        em.close();
        JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
    }
    
    public void voltarParaMenuPrincipal(){
        
        MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
        menuPrincipalView.setVisible(true);
        view.dispose();
    }
}
