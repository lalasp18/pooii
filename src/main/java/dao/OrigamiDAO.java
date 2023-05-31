/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Origami;
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
public class OrigamiDAO extends GenericDAO {
    
    public Origami pesquisarNome(String nome) throws HibernateException {
        Origami origami = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( Origami.class );
            
            // FROM
            Root tabela = consulta.from(Origami.class);
            
            // RESTRIÇÕES
            Predicate restricoes = builder.like(tabela.get("nome"), nome + "%" ); 
                        
            consulta.where(restricoes);
            try {
                origami = (Origami) sessao.createQuery(consulta).getSingleResult();
            } catch (NoResultException e) {
                origami = null;
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
        return origami;
    }
}
