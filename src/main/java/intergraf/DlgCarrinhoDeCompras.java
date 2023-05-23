/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package intergraf;

import dominio.CarrinhoCompra;
import dominio.Cliente;
import dominio.Origami;
import intergraf.DlgTelaPedidos;
import gerTarefas.GerInterGrafica;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LEDS
 */
public class DlgCarrinhoDeCompras extends javax.swing.JDialog {

    private GerInterGrafica gerIG;
    /**
     * Creates new form DlgCarrinhoDeCompras
     */
    public DlgCarrinhoDeCompras(java.awt.Frame parent, boolean modal, GerInterGrafica gerIG) {
        initComponents();
        this.gerIG = gerIG;
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
        jMenu3 = new javax.swing.JMenu();
        menuLoja = new javax.swing.JMenuItem();
        menuCarrinho = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuExcluirConta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer-review.png"))); // NOI18N
        jMenu3.setText("<html><style>h1{font-size:12px}</style><h1>Usuário</h1></html>");

        menuLoja.setText("Loja de origamis");
        menuLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLojaActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoja);

        menuCarrinho.setText("Carrinho de compras");
        jMenu3.add(menuCarrinho);

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenu3.add(menuSair);
        jMenu3.add(jSeparator2);

        menuExcluirConta.setText("Excluir conta");
        jMenu3.add(menuExcluirConta);

        jMenuBar1.add(jMenu3);

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
        //  EXEMPLO DE CLIENTE JÁ QUE NÃO POSSUO PESQUISAR PARA MANTÊ-LO LOGADO
        List<Cliente> clientes = gerIG.getGerDominio().listar(Cliente.class);
        Cliente client = clientes.get(clientes.size()-1);
        //  EXEMPLO DE CLIENTE JÁ QUE NÃO POSSUO PESQUISAR PARA MANTÊ-LO LOGADO
        String msgSucesso = "";
        int i = 1;
        
        List<CarrinhoCompra> carrinhos = gerIG.getGerDominio().listar(CarrinhoCompra.class);
        for (CarrinhoCompra compra : carrinhos) {
            client.getPedidos().add(compra);
            msgSucesso = "Itens dos "  + i + " carrinhos comprados com sucesso";
            i++;
        }
        
        if(!msgSucesso.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) tbCarrinho.getModel();
            model.setRowCount(0);
                
            JOptionPane.showMessageDialog(this, msgSucesso, "Status da Compra", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnComprarActionPerformed
    
    private float definirFrete() {
        //  EXEMPLO DE CLIENTE JÁ QUE NÃO POSSUO PESQUISAR PARA MANTÊ-LO LOGADO
        List<Cliente> clientes = gerIG.getGerDominio().listar(Cliente.class);
        Cliente client = clientes.get(clientes.size()-1);
        //  EXEMPLO DE CLIENTE JÁ QUE NÃO POSSUO PESQUISAR PARA MANTÊ-LO LOGADO
        
        if( null != client.getCidade() ) switch (client.getCidade()) {
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
        List<CarrinhoCompra> carrinhos = gerIG.getGerDominio().listar(CarrinhoCompra.class);
        Map<Origami, Integer> origamisQuantidades = new HashMap<>();
        Set<Origami> origamisExibidos = new HashSet<>();
        
        float totalCompra = 0.0f;
        float totalFrete = 0.0f;
        
        DefaultTableModel tableModel = (DefaultTableModel) tbCarrinho.getModel();
        tableModel.setRowCount(0);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbCarrinho.setDefaultRenderer(Object.class, centerRenderer);
        
        for (CarrinhoCompra compra : carrinhos) {
            for (Origami origami : compra.getOrigami()) {
                origamisQuantidades.put(origami, origamisQuantidades.getOrDefault(origami, 0) + 1);
            }
        }
        
        for (CarrinhoCompra compra : carrinhos) {
            for(Origami origami : compra.getOrigami()) {
                if (origamisExibidos.contains(origami)) {
                    continue; // Ignorar a adição à tabela
                }
                
                origamisExibidos.add(origami);
                
                String nome = origami.getNome();
                float preco = origami.getPreco();
                int qtd = origamisQuantidades.get(origami);
                float total = qtd * preco;
                totalCompra += total;

                String qtdStr = Integer.toString(qtd) + " unid.";
                String precoStr = "R$ " + Float.toString(preco);
                String totalStr = "R$ " + Float.toString(total);

                Object[] rowData = {nome, qtdStr, precoStr, totalStr};
                tableModel.addRow(rowData);
            }
        }

        totalFrete = definirFrete();
        totalCompra += totalFrete;

        txtFrete.setText("R$ " + totalFrete);
        txtTotal.setText("R$ " + totalCompra);
        
        tbCarrinho.setModel(tableModel);
        tbCarrinho.setShowVerticalLines(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JMenuItem menuCarrinho;
    private javax.swing.JMenuItem menuExcluirConta;
    private javax.swing.JMenuItem menuLoja;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JTable tbCarrinho;
    private javax.swing.JTextField txtFrete;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
