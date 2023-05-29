/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Cliente;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author LEDS
 */
public class ClienteDAO extends GenericDAO {
    
    public Cliente pesquisarPerfil(String email, String senha) throws HibernateException {
        Cliente client = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( Cliente.class );
            
            // FROM
            Root tabela = consulta.from(Cliente.class);
            
            // RESTRIÇÕES
            Predicate restricoes = builder.and(
                builder.like(tabela.get("email"), email + "%"),
                builder.like(tabela.get("senha"), senha + "%")
            );
                        
            consulta.where(restricoes);
            try {
                client = (Cliente) sessao.createQuery(consulta).getSingleResult();
            } catch (NoResultException e) {
                client = null;
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
        return client;
    }
    
    public Cliente pesquisarEmail(String email) throws HibernateException {
        Cliente client = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( Cliente.class );
            
            // FROM
            Root tabela = consulta.from(Cliente.class);
            
            // RESTRIÇÕES
            Predicate restricoes = builder.like(tabela.get("email"), email + "%" ); 
                        
            consulta.where(restricoes);
            try {
                client = (Cliente) sessao.createQuery(consulta).getSingleResult();
            } catch (NoResultException e) {
                client = null;
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
        return client;
    }
    
}
