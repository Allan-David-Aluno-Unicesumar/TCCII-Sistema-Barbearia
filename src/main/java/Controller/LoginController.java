/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.LoginHelper;
import Dao.UsuarioDAO;
import Model.Usuario;
import View.LoginView;
import View.MenuPrincipalView;
import Dao.JPAUtil;
import View.CadastroUsuarioView;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class LoginController {

    private final LoginView view;
    private LoginHelper helper;

    public LoginController(LoginView view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }


    public void autenticar() throws SQLException {
        
        //Pegar usuario e senha da view
        Usuario usuario = helper.obterModelo();
        
        //Pesquisa-los no banco de dados
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        boolean existe = new UsuarioDAO(em).existeNoBancoPorUsuarioESenha(usuario);
            
        em.getTransaction().commit();
        em.close();
        
        
        //Se existir e bater informacoes, direcionar ao menu principal
        if(existe){
            MenuPrincipalView telaMenu = new MenuPrincipalView();
            telaMenu.setVisible(true);
            view.dispose();
            
            //Se nao, mostrar mensagem "Usuario ou Senha invalidos"
        }else{
            JOptionPane.showMessageDialog(null, "Usuario ou Senha invalidos");
        }
        
        
    }

    public void cadastrarUsuario() {
        CadastroUsuarioView telaCadastrarUsuario = new CadastroUsuarioView();
        telaCadastrarUsuario.setVisible(true);
        view.dispose();
    }
    
}
    
    

