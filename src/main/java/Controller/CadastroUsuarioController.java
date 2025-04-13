/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.CadastroUsuarioHelper;
import Dao.UsuarioDAO;
import Model.Usuario;
import View.CadastroUsuarioView;
import View.LoginView;
import Dao.JPAUtil;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class CadastroUsuarioController {
    
    private final CadastroUsuarioView view;
    private CadastroUsuarioHelper helper;

    
    public CadastroUsuarioController(CadastroUsuarioView view) {
        this.view = view;
        this.helper = new CadastroUsuarioHelper(view);
    }
    
    
    public void cadastrarUsuario() throws SQLException{
        
        Usuario usuario = helper.obterModelo();
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        new UsuarioDAO(em).insert(usuario);
            
        em.getTransaction().commit();
        em.close();
        JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
        
        helper.limparTela();
    }
    
    public void voltarParaTelaLogin(){
        
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
        view.dispose();
    }
}
