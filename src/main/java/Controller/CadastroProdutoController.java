/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.CadastroProdutoHelper;
import Dao.FornecedorDAO;
import Dao.JPAUtil;
import Dao.ProdutoDAO;
import Model.Fornecedor;
import Model.Produto;
import View.CadastroProdutoView;
import View.MenuPrincipalView;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class CadastroProdutoController {
    
    private final CadastroProdutoView view;
    private CadastroProdutoHelper helper;

    
    public CadastroProdutoController(CadastroProdutoView view) {
        this.view = view;
        this.helper = new CadastroProdutoHelper(view);
    }
    
    public void atualizarFornecedor(){
        
        // Buscar lista de fornecedores no banco de dados
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        FornecedorDAO fornecedorDAO = new FornecedorDAO(em);
        List<Fornecedor> fornecedores = fornecedorDAO.selectAll();
            
        em.getTransaction().commit();
        em.close();
        
        // Exibir a lista no jComboBox
        helper.preencherFornecedores(fornecedores);
    }
    
    public void cadastrarProduto() throws SQLException{
        
        Produto produto = helper.obterModelo();
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
            
        new ProdutoDAO(em).insert(produto);
            
        em.getTransaction().commit();
        em.close();
        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        
        helper.limparTela();
    }
    
    public void voltarParaMenuPrincipal(){
        
        MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
        menuPrincipalView.setVisible(true);
        view.dispose();
    }
}
