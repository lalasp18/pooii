/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Item;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author LEDS
 */
public class ItemDAO extends GenericDAO {
    
    private List<Item> pesquisar(String pesq, int tipo) throws HibernateException {
        // TESTE
        return listar(Item.class);
    }
}
