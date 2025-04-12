/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.CadastroFornecedorHelper;
import Dao.FornecedorDAO;
import View.MenuPrincipalView;
import Dao.JPAUtil;
import Model.Fornecedor;
import View.CadastroFornecedorView;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class CadastroFornecedorController {
    
    private final CadastroFornecedorView view;
    private CadastroFornecedorHelper helper;

    
    public CadastroFornecedorController(CadastroFornecedorView view) {
        this.view = view;
        this.helper = new CadastroFornecedorHelper(view);
    }
    
    
    public void cadastrarFornecedor() throws SQLException{
        
        Fornecedor fornecedor = helper.obterModelo();
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        new FornecedorDAO(em).insert(fornecedor);
            
        em.getTransaction().commit();
        em.close();
        JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
    }
    
    public void voltarParaMenuPrincipal(){
        
        MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
        menuPrincipalView.setVisible(true);
        view.dispose();
    }
}
