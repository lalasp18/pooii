/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Origami;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author LEDS
 */
public class OrigamiDAO extends GenericDAO {
    
    private List<Origami> pesquisar(String pesq, int tipo) throws HibernateException {
        // TESTE
        return listar(Origami.class);
    }
}
