/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package intergraf;

import dominio.Item;
import dominio.Origami;
import gerTarefas.GerInterGrafica;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;

/**
 *
 * @author LEDS
 */
public class DlgCarrinhoDeCompras extends javax.swing.JDialog {

    private GerInterGrafica gerIG;
    private float totalComprado = 0.0f;
    /**
     * Creates new form DlgCarrinhoDeCompras
     */
    public DlgCarrinhoDeCompras(java.awt.Frame parent, boolean modal, GerInterGrafica gerIG) {
        initComponents();
        this.gerIG = gerIG;
        menuUsuario.setText("<html><style>h1{font-size:12px}</style><h1>" + gerIG.getGerCliente().getNome()
                + "</h1></html>");
        carregarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbCarrinho = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtFrete = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        menuLoja = new javax.swing.JMenuItem();
        menuCompras = new javax.swing.JMenu();
        subMenuCarrinho = new javax.swing.JMenuItem();
        subMenuHistorico = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuExcluirConta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Carrinho de Compras");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setOpaque(false);

        tbCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Origami", "Quantidade", "Valor Un.", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCarrinho.setOpaque(false);
        tbCarrinho.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbCarrinho);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 580, 510));

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(102, 0, 0));
        btnCancelar.setText("Cancelar");
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, 120, 60));

        btnComprar.setBackground(new java.awt.Color(102, 0, 204));
        btnComprar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnComprar.setForeground(new java.awt.Color(255, 255, 255));
        btnComprar.setText("Comprar Agora");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        getContentPane().add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 180, 60));

        jPanel1.setBackground(new java.awt.Color(157, 225, 248));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        txtFrete.setEditable(false);
        txtFrete.setBackground(new java.awt.Color(255, 255, 255));
        txtFrete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtFrete.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtFrete);

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FRETE");
        jPanel1.add(jLabel2);

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setPreferredSize(new java.awt.Dimension(34, 31));
        jPanel1.add(txtTotal);

        lblTotal.setBackground(new java.awt.Color(255, 255, 255));
        lblTotal.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(51, 51, 51));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("TOTAL");
        jPanel1.add(lblTotal);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 210, 140));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer-review.png"))); // NOI18N
        menuUsuario.setText("<html><style>h1{font-size:12px}</style><h1>Usuário</h1></html>");

        menuLoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/loja-alt.png"))); // NOI18N
        menuLoja.setText("Loja de origamis");
        menuLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLojaActionPerformed(evt);
            }
        });
        menuUsuario.add(menuLoja);

        menuCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicionar-sacola-de-compras.png"))); // NOI18N
        menuCompras.setText("Compras");

        subMenuCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/carrinho-de-compras (1).png"))); // NOI18N
        subMenuCarrinho.setText("Carrinho de compras");
        menuCompras.add(subMenuCarrinho);

        subMenuHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tempo-passado.png"))); // NOI18N
        subMenuHistorico.setText("Histórico");
        subMenuHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuHistoricoActionPerformed(evt);
            }
        });
        menuCompras.add(subMenuHistorico);

        menuUsuario.add(menuCompras);

        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/saida.png"))); // NOI18N
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuUsuario.add(menuSair);
        menuUsuario.add(jSeparator2);

        menuExcluirConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lixo.png"))); // NOI18N
        menuExcluirConta.setText("Excluir conta");
        menuUsuario.add(menuExcluirConta);

        jMenuBar1.add(menuUsuario);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        gerIG.fecharPerfil();
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLojaActionPerformed
        gerIG.janelaPedidos();
        dispose();
    }//GEN-LAST:event_menuLojaActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        float frete = definirFrete();
        if(gerIG.itensPedidos.size() > 0) {
            try {
            // INSERIR
                int id = gerIG.getGerDominio().inserirCarrinhoCompra(frete, totalComprado, gerIG.itensPedidos, gerIG.getGerCliente());
                JOptionPane.showMessageDialog(this, "Carrinho " + id + " comprado com sucesso.", "Status da Compra", JOptionPane.INFORMATION_MESSAGE  );
                DefaultTableModel model = (DefaultTableModel) tbCarrinho.getModel();
                model.setRowCount(0);
                txtFrete.setText("");
                txtTotal.setText("");
            } catch (HibernateException ex) {
                JOptionPane.showMessageDialog(this, ex, "ERRO Carrinho", JOptionPane.ERROR_MESSAGE  );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex, "ERRO Carrinho", JOptionPane.ERROR_MESSAGE  );
            }
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void subMenuHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuHistoricoActionPerformed
        gerIG.janelaHistorico();
        dispose();
    }//GEN-LAST:event_subMenuHistoricoActionPerformed
    
    private float definirFrete() {
        if( gerIG.getGerCliente()!= null ) switch (gerIG.getGerCliente().getCidade()) {
            case "Serra":
                return 15;
            case "Vila Velha":
                return 12.5f;
            case "Cariacica":
                return 10;
            case "Vitória":
                return 8.5f;
            case "Guarapari":
                return 20;
            case "Colatina":
                return 18;
            case "Aracruz":
                return 16;
            case "Viana":
                return 14;
            case "Nova Venécia":
                return 22;
            default:
                return 17.5f;
        }
        return 0;
    }
    
    private void carregarTabela(){
        float totalFrete = 0.0f;
        
        DefaultTableModel tableModel = (DefaultTableModel) tbCarrinho.getModel();
        tableModel.setRowCount(0);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbCarrinho.setDefaultRenderer(Object.class, centerRenderer);
        
        if(!gerIG.itensPedidos.isEmpty() || gerIG.itensPedidos != null) {
            for(Item produto : gerIG.itensPedidos) {
                if(produto.getCarrinho() != null) {
                    continue;
                }

                Origami origami = produto.getOrigami();

                String nome = origami.getNome();
                float preco = origami.getPreco();
                int qtd = produto.getQtd();
                float total = qtd * preco;
                totalComprado += total;

                String qtdStr = Integer.toString(qtd) + " unid.";
                String precoStr = "R$ " + Float.toString(preco);
                String totalStr = "R$ " + Float.toString(total);

                Object[] rowData = {nome, qtdStr, precoStr, totalStr};
                tableModel.addRow(rowData);
            }

            totalFrete = definirFrete();
            totalComprado += totalFrete;

            txtFrete.setText("R$ " + totalFrete);
            txtTotal.setText("R$ " + totalComprado);
        }
        
        tbCarrinho.setModel(tableModel);
        tbCarrinho.setShowVerticalLines(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JMenu menuCompras;
    private javax.swing.JMenuItem menuExcluirConta;
    private javax.swing.JMenuItem menuLoja;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenuItem subMenuCarrinho;
    private javax.swing.JMenuItem subMenuHistorico;
    private javax.swing.JTable tbCarrinho;
    private javax.swing.JTextField txtFrete;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
