/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.MenuPrincipalController;

/**
 *
 * @author allan
 */
public class MenuPrincipalView extends javax.swing.JFrame {
    
    private final MenuPrincipalController controller;
    
    
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipalView() {
        initComponents();
        controller = new MenuPrincipalController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCadastrarCliente = new javax.swing.JMenuItem();
        menuCadastrarFornecedor = new javax.swing.JMenuItem();
        menuCadastrarProduto = new javax.swing.JMenuItem();
        menuCadastrarServico = new javax.swing.JMenuItem();
        menuOperacao = new javax.swing.JMenu();
        menuAgendamento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/fundo-menu-principal.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        menuCadastro.setText("Cadastro");

        menuCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/icons/icon-cliente-24.png"))); // NOI18N
        menuCadastrarCliente.setText("Cliente");
        menuCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastrarCliente);

        menuCadastrarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/icons/icon-fornecedor-24.png"))); // NOI18N
        menuCadastrarFornecedor.setText("Fornecedor");
        menuCadastrarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarFornecedorActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastrarFornecedor);

        menuCadastrarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/icons/icon-produto-24.png"))); // NOI18N
        menuCadastrarProduto.setText("Produto");
        menuCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarProdutoActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastrarProduto);

        menuCadastrarServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/icons/icon-servi�o-24.png"))); // NOI18N
        menuCadastrarServico.setText("Servi�o");
        menuCadastrarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarServicoActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastrarServico);

        jMenuBar1.add(menuCadastro);
        menuCadastro.getAccessibleContext().setAccessibleName("");

        menuOperacao.setText("Opera��o");

        menuAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/icons/icon-agendamento-24.png"))); // NOI18N
        menuAgendamento.setText("Agendamento");
        menuAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgendamentoActionPerformed(evt);
            }
        });
        menuOperacao.add(menuAgendamento);

        jMenuBar1.add(menuOperacao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 986, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarClienteActionPerformed
        
        controller.abrirTelaCadastrarCliente();
    }//GEN-LAST:event_menuCadastrarClienteActionPerformed

    private void menuAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgendamentoActionPerformed
        
        controller.abrirTelaAgendamento();
    }//GEN-LAST:event_menuAgendamentoActionPerformed

    private void menuCadastrarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarServicoActionPerformed
        
        controller.abrirTelaCadastrarServico();
    }//GEN-LAST:event_menuCadastrarServicoActionPerformed

    private void menuCadastrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarFornecedorActionPerformed
        
        controller.abrirTelaCadastroFornecedor();
    }//GEN-LAST:event_menuCadastrarFornecedorActionPerformed

    private void menuCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarProdutoActionPerformed
        
        controller.abrirTelaCadastrarProduto();
    }//GEN-LAST:event_menuCadastrarProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuAgendamento;
    private javax.swing.JMenuItem menuCadastrarCliente;
    private javax.swing.JMenuItem menuCadastrarFornecedor;
    private javax.swing.JMenuItem menuCadastrarProduto;
    private javax.swing.JMenuItem menuCadastrarServico;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuOperacao;
    // End of variables declaration//GEN-END:variables
}
