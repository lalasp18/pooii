/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.CarrinhoCompra;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author LEDS
 */
public class CarrinhoDAO extends GenericDAO {
    
    private List<CarrinhoCompra> pesquisar(String pesq, int tipo) throws HibernateException {
        // TESTE
        return listar(CarrinhoCompra.class);
    }
}
