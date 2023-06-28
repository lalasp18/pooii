/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gerTarefas;

import dominio.Cliente;
import dominio.Item;
import intergraf.DlgCadastroLogin;
import intergraf.DlgCarrinhoDeCompras;
import intergraf.DlgGerenciarOrigami;
import intergraf.DlgHistorico;
import intergraf.DlgLogIn;
import intergraf.DlgTelaPedidos;
import intergraf.MenuPrincipal;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

/**
 *
 * @author LEDS
 */
public class GerInterGrafica {
    
    // JANELAS
    private MenuPrincipal janPrinc = null;
    private DlgGerenciarOrigami janGeren = null;
    private DlgLogIn janLogin = null;
    private DlgCadastroLogin janCadlog = null;
    private DlgTelaPedidos janTelped = null;
    private DlgCarrinhoDeCompras janCarcomp = null;
    private DlgHistorico janHistor = null;
    
    // GERENCIADORES de DOMINIO
    GerenciadorDominio gerDominio;
    GerenciadorRelatorios gerRel;
    
    // CLIENTE LOGADO
    Cliente gerCliente = null;
    
    public GerInterGrafica() {
        try {
            gerDominio = new GerenciadorDominio();
            gerRel = new GerenciadorRelatorios();
        } catch (HibernateException  ex) {
            JOptionPane.showMessageDialog(janPrinc, "Erro de conexão com o banco. " + ex.getMessage() );
                System.exit(-1);
        } 
    }

    public Cliente getGerCliente() {
        return gerCliente;
    }

    public GerenciadorDominio getGerDominio() {
        return gerDominio;
    }

    public GerenciadorRelatorios getGerRelatorios() {
        return gerRel;
    }
    
   // ABRIR JDIALOG
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, GerInterGrafica.class ).newInstance(parent,true,this);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() );
            } 
        }        
        dlg.setVisible(true); 
        return dlg;
    }
    
    private void fecharJanela(JDialog dlg_1, JDialog dlg_2, JDialog dlg_3) {
        if (dlg_1 != null && dlg_1.isVisible()) {
            dlg_1.dispose();
        }
        if (dlg_2 != null && dlg_2.isVisible()) {
            dlg_2.dispose();
        }
        if (dlg_3 != null && dlg_3.isVisible()) {
            dlg_3.dispose();
        }
    }

    
    public void janelaPrincipal() {
        janPrinc = new MenuPrincipal(this);
        janPrinc.setVisible(true);
        clienteDeslogado();
    }
    
    public void janelaLogInCliente() {
        if(gerCliente == null) {
            janLogin = (DlgLogIn) abrirJanela(janPrinc, janLogin, DlgLogIn.class);
        }
    }
    
    public void janelaCadCliente() {
        janCadlog = (DlgCadastroLogin) abrirJanela(janPrinc, janCadlog, DlgCadastroLogin.class);
    }
    
    public void janelaPedidos() {
        janTelped = (DlgTelaPedidos) abrirJanela(janPrinc, janTelped, DlgTelaPedidos.class);
    }
    
    public void janelaCarrinho() {
        janCarcomp = (DlgCarrinhoDeCompras) abrirJanela(janPrinc, janCarcomp, DlgCarrinhoDeCompras.class);
    }
    
    public void janelaHistorico() {
        janHistor = (DlgHistorico) abrirJanela(janPrinc, janHistor, DlgHistorico.class);
    }
    
    public void janelaGerenciar() {
        janGeren = (DlgGerenciarOrigami) abrirJanela(janPrinc, janGeren, DlgGerenciarOrigami.class);
    }
    
    public void fecharPerfil() {
        fecharJanela(janTelped, janCarcomp, janHistor);
        clienteDeslogado();
    }
    
    public boolean clienteLogado(String email, String senha) {
        gerCliente = gerDominio.logar(email, senha);
        if(gerCliente != null) {
            return true;
        }
        return false;
    }
    
    public void clienteDeslogado() {
        gerCliente = null;
    }
    
    public List<Item> produtosPedidos(){
        return janTelped.getItensPedidos();
    }
    
    public static void main(String[] args) {
        
        // TRADUÇÃO
        javax.swing.UIManager.put("OptionPane.yesButtonText", "Sim"); 
        javax.swing.UIManager.put("OptionPane.noButtonText", "Não");
        

        GerInterGrafica gerIG = new GerInterGrafica();
        gerIG.janelaPrincipal();
    }
}
