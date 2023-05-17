/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package intergraf;

import gerTarefas.GerInterGrafica;
import java.awt.Color;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import org.hibernate.HibernateException;

/**
 *
 * @author LEDS
 */
public class DlgLogIn extends javax.swing.JDialog {

    private GerInterGrafica gerIG;
    /**
     * Creates new form NewJDialog
     */
    public DlgLogIn(java.awt.Frame parent, boolean modal, GerInterGrafica gerIG) {
        initComponents();
        this.gerIG = gerIG;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSenha = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        btnInscrever = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sign In");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSenha.setText("Senha");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, -1));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setText("E-mail");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setToolTipText("");
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 230, 30));

        btnEntrar.setBackground(new java.awt.Color(0, 0, 153));
        btnEntrar.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 100, 30));

        btnInscrever.setForeground(new java.awt.Color(0, 153, 153));
        btnInscrever.setText("<html><head> <style> p{text-decoration: underline;} p:active{color: white;} </style></head><body> <p>Inscrever-se</p></body> </html>");
        btnInscrever.setActionCommand("<html>\n<style>\np{text-decoration: underline; box-shadow: .5em .5em black;}\n</style>\n<p>Inscrever-se</p>\n</html>");
        btnInscrever.setBorder(null);
        btnInscrever.setBorderPainted(false);
        btnInscrever.setContentAreaFilled(false);
        btnInscrever.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscreverActionPerformed(evt);
            }
        });
        getContentPane().add(btnInscrever, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html>\n<style>\nh1{font-size: 40px}\n</style>\n<h1>Log In</h1>\n</html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Não Tem Uma Conta?");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 230, 30));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.jpg"))); // NOI18N
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        String email = txtEmail.getText();
        
        char[] passwordChars = txtSenha.getPassword();
        String senha = new String(passwordChars);
        
        if( validarCampos() ) {
             // INSERIR NO BANCO
            try {
                // PESQUISAR
//                int id = gerIG.getGerDominio().inserirCliente(nome, cpf, dt, sexo, cep, ender,  bairro, num, complemento, referencia, telFixo, celular, email, fotoBytes, cidade);
//                JOptionPane.showMessageDialog(this, "Cliente " + id + "inserido com sucesso.", "Inserir Cliente", JOptionPane.INFORMATION_MESSAGE  );
                
                gerIG.janelaPedidos();
                limparCampos();
                dispose();
            } catch (HibernateException ex) {
                JOptionPane.showMessageDialog(this, ex, "ERRO Log in", JOptionPane.ERROR_MESSAGE  );
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex, "ERRO Log in", JOptionPane.ERROR_MESSAGE  );
            }
        }
        
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnInscreverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscreverActionPerformed
        gerIG.janelaCadCliente();
        limparCampos();
        dispose();
    }//GEN-LAST:event_btnInscreverActionPerformed

    private boolean validarCampos() {
        
        String msgErro = "";
        
        lblEmail.setForeground(Color.DARK_GRAY);
        lblSenha.setForeground(Color.DARK_GRAY); 
        
        if ( txtEmail.getText().isEmpty() ) {
            msgErro = msgErro + "Digite o e-mail.\n";
            lblEmail.setForeground(Color.red);            
        }
        

        char[] passwordChars = txtSenha.getPassword();
        String password = new String(passwordChars);
        if ( password.isEmpty() ) {
            msgErro = msgErro + "Digite a senha.\n";
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
        lblEmail.setForeground(Color.DARK_GRAY);
        lblSenha.setForeground(Color.DARK_GRAY); 
        
        
        txtEmail.setText( "" );
        char[] emptyPassword = new char[0];
        txtSenha.setEchoChar('\u0000');
        txtSenha.setText(new String(emptyPassword));

     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnInscrever;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
