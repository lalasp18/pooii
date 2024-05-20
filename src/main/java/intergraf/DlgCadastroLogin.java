/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package intergraf;

import gerTarefas.GerInterGrafica;
import java.awt.Color;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

/**
 *
 * @author LEDS
 */
public class DlgCadastroLogin extends javax.swing.JDialog {

    private GerInterGrafica gerIG;
    /**
     * Creates new form DlgCadastroLogin
     */
    public DlgCadastroLogin(java.awt.Frame parent, boolean modal, GerInterGrafica gerIG) {
        initComponents();
        this.gerIG = gerIG;
        limparCampos();
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
        lblNome = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        boxCidade = new javax.swing.JComboBox<>();
        btnCadastrar = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Usuário");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html> <style> h1{font-size: 30px} </style> <h1>Novo usuário</h1> </html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setText("Nome de usuário");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 250, 30));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setText("E-mail");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        lblSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSenha.setText("Senha");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 250, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Cidade");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        boxCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boxCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Serra", "Vila Velha", "Cariacica", "Vitória", "Guarapari", "Colatina", "Aracruz", "Viana", "Nova Venécia" }));
        getContentPane().add(boxCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 180, 30));

        btnCadastrar.setBackground(new java.awt.Color(204, 255, 255));
        btnCadastrar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(0, 0, 153));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 130, 40));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 250, 30));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cadastro.jpg"))); // NOI18N
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String nomeCliente = txtNome.getText();
        String email = txtEmail.getText();
        String senha = txtSenha.getText();
        String cidade = boxCidade.getSelectedItem().toString();
        
        if( validarCampos() ) {
            if(gerIG.getGerDominio().pesquisarEmailCliente(email) != null) {
                lblEmail.setForeground(Color.red);      
                JOptionPane.showMessageDialog(this, "E-mail já cadastrado!", "ERRO Log In", JOptionPane.ERROR_MESSAGE  );
            } else {
                // INSERIR NO BANCO
               try {
                   int id = gerIG.getGerDominio().inserirCliente(nomeCliente, email, senha, cidade);
                   JOptionPane.showMessageDialog(this, "Usuário " + id + " cadastrado com sucesso.", "Inserir Cliente", JOptionPane.INFORMATION_MESSAGE  );

                   gerIG.janelaLogInCliente();
                   limparCampos();
                   dispose();
               } catch (HibernateException ex) {
                   JOptionPane.showMessageDialog(this, ex, "ERRO Cliente", JOptionPane.ERROR_MESSAGE  );
               }
               catch (Exception ex) {
                   JOptionPane.showMessageDialog(this, ex, "ERRO Cliente", JOptionPane.ERROR_MESSAGE  );
               }
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed
    
    private boolean validarCampos() {
        
        String msgErro = "";
        
        lblNome.setForeground(Color.DARK_GRAY);
        lblEmail.setForeground(Color.DARK_GRAY);
        lblSenha.setForeground(Color.DARK_GRAY); 
        
        if ( txtNome.getText().isEmpty() ) {
            msgErro = msgErro + "Digite o seu nome.\n";
            lblNome.setForeground(Color.red);            
        }
        if ( txtEmail.getText().isEmpty() ) {
            msgErro = msgErro + "Digite o seu e-mail.\n";
            lblEmail.setForeground(Color.red);            
        }
        if ( txtSenha.getText().isEmpty() ) {
            msgErro = msgErro + "Insira uma senha.\n";
            lblSenha.setForeground(Color.red);            
        }
        
              
        if ( msgErro.isEmpty() ) {
            return true;
        } else {            
            JOptionPane.showMessageDialog(this, msgErro, "ERRO Gerenciador", JOptionPane.ERROR_MESSAGE  );
            return false;
        }
        
    } 
    
    private void limparCampos() { 
        lblNome.setForeground(Color.DARK_GRAY);
        lblEmail.setForeground(Color.DARK_GRAY);
        lblSenha.setForeground(Color.DARK_GRAY); 
        
        
        txtNome.setText( "" );
        txtEmail.setText( "" );
        txtSenha.setText( "" );
        boxCidade.setSelectedIndex(0);
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCidade;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
