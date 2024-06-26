/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import dao.AvaliacaoDAO;
import dao.CarrinhoDAO;
import dao.ClienteDAO;
import dao.ConexaoHibernate;
import dao.GenericDAO;
import dao.ItemDAO;
import dao.OrigamiDAO;
import dominio.Avaliacao;
import dominio.CarrinhoCompra;
import dominio.Cliente;
import dominio.Item;
import dominio.Origami;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author LEDS
 */
public class GerenciadorDominio {
    
    AvaliacaoDAO avaDAO = null;
    CarrinhoDAO carrDAO = null;
    ClienteDAO cliDAO = null;
    GenericDAO genDAO = null;
    ItemDAO itmDAO = null;
    OrigamiDAO oriDAO = null;

    public GerenciadorDominio() throws HibernateException {
        ConexaoHibernate.getSessionFactory();
        
        avaDAO = new AvaliacaoDAO();
        carrDAO = new CarrinhoDAO();
        cliDAO = new ClienteDAO();
        genDAO = new GenericDAO();
        itmDAO = new ItemDAO();
        oriDAO = new OrigamiDAO();
    }
    
    // GENÉRICOS
    public List listar(Class classe) throws HibernateException {        
        return genDAO.listar(classe);        
    }
    
    // GENÉRICOS
    public void excluir (Object obj) throws HibernateException {
        genDAO.excluir(obj);
    }
    
    public int inserirOrigami (String nome, String dificuldade, float preco, String categoria, String tipoPapel, int qtdPecas, byte[] foto, List<String> materiais) throws HibernateException {
        Origami ori = new Origami(nome, dificuldade, preco, categoria, tipoPapel, qtdPecas, foto, materiais);
        oriDAO.inserir(ori);
        return ori.getIdOrigami();
    }
    
    public Origami nomeOrigamiExiste (String pesq) throws HibernateException {
        return oriDAO.pesquisarNome(pesq);
    }
    
    public void alterarOrigami(Origami ori, String nome, String dificuldade, float preco, String categoria, String tipoPapel, int qtdPecas, byte[] foto, List<String> materiais) throws HibernateException   {
        ori.setNome(nome);
        ori.setDificuldade(dificuldade);
        ori.setPreco(preco);
        ori.setCategoria(categoria);
        ori.setTipoPapel(tipoPapel);
        ori.setQtdPecas(qtdPecas);
        ori.setFoto(foto);
        ori.setMateriais(materiais);
        
        oriDAO.alterar(ori);        
    }
    
    public int inserirCliente (String nome, String email, String senha, String cidade) throws HibernateException {
        Cliente cli = new Cliente(nome, email, senha, cidade);
        cliDAO.inserir(cli);
        return cli.getIdCliente();
    }
    
    public Cliente logar(String email, String senha) {
        return cliDAO.pesquisarPerfil(email, senha);
    }
    
    public Cliente pesquisarEmailCliente (String pesq) throws HibernateException {
        return cliDAO.pesquisarEmailExistente(pesq);
    }
    
    public int inserirAvalicao (Cliente cliente, Origami origami, int nota, String comentario) {
        Avaliacao ava = new Avaliacao(cliente, origami, nota, comentario);
        avaDAO.inserir(ava);
        return ava.getIdAvaliacao();
    }
    
    public int inserirItem (Origami origami, int qtd) {
        Item itm = new Item(origami, qtd);
        itmDAO.inserir(itm);
        return itm.getIdItem();
    }
    
    public int inserirCarrinhoCompra (float frete, float total, Date dataCompra, String status, List<Item> listaItens, Cliente cliente) {
        CarrinhoCompra carr = new CarrinhoCompra(frete, total, dataCompra, status, cliente);
        
        for(Item produto : listaItens) {
            produto.setCarrinho(carr);
        }
        carr.setListaItens(listaItens);
        
        cliente.getPedidos().add(carr);
        
        carrDAO.inserir(carr);
        return carr.getIdCarrinhoCompra();
    }
    
    public List<CarrinhoCompra> statusDaCompra(String pesq) {
        return carrDAO.pesquisarStatus(pesq);
    }
    
//    public CarrinhoCompra editarStatus(String nomeCliente, Date data) {
//        Cliente clt = pesquisarCliente(nomeCliente, 0);
//        return carrDAO.pesquisarCompra(clt, data);
//    }
    
    public void alterarStatusCompra(CarrinhoCompra compraAtualizada, String status) {
        compraAtualizada.setStatus(status);
        
        carrDAO.alterar(compraAtualizada);
    }
}
