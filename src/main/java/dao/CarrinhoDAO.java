/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.CarrinhoCompra;
import dominio.Cliente;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author LEDS
 */
public class CarrinhoDAO extends GenericDAO {
    
    public List<CarrinhoCompra> pesquisarStatus(String status) throws HibernateException {
        List<CarrinhoCompra> compra = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( CarrinhoCompra.class );
            
            // FROM
            Root tabela = consulta.from(CarrinhoCompra.class);
            
            // RESTRIÇÕES
            Predicate restricoes = builder.equal(tabela.get("status"), status); 
                        
            consulta.where(restricoes);
            try {
                compra = sessao.createQuery(consulta).getResultList();
            } catch (NoResultException e) {
                compra = null;
            }           

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null ) {
                sessao.getTransaction().rollback();          
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return compra;
    }
    
    
    public CarrinhoCompra pesquisarCompra(Cliente cli, Date data) throws HibernateException {
        CarrinhoCompra compra = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( CarrinhoCompra.class );
            
            // FROM
            Root tabela = consulta.from(CarrinhoCompra.class);
            
            // RESTRIÇÕES
            Predicate restricoes = builder.and(
                builder.equal(tabela.get("cliente_id"), cli),
                builder.equal(tabela.get("dataCompra"), data)
            );
                        
            consulta.where(restricoes);
            try {
                compra = (CarrinhoCompra) sessao.createQuery(consulta).getSingleResult();
            } catch (NoResultException e) {
                compra = null;
            }           

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null ) {
                sessao.getTransaction().rollback();          
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return compra;
    }
}
