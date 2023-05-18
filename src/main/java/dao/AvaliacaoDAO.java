/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Avaliacao;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author LEDS
 */
public class AvaliacaoDAO extends GenericDAO {
    
    private List<Avaliacao> pesquisar(String pesq, int tipo) throws HibernateException {
        // TESTE kkjkjk
        return listar(Avaliacao.class);
    }
}
