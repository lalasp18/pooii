/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Cliente;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author LEDS
 */
public class ClienteDAO extends GenericDAO {
    
    public Cliente pesquisarEmail(String email, String senha) throws HibernateException {
        List<Cliente> clientes = listar(Cliente.class);
        if(!clientes.isEmpty()){
            return clientes.get(clientes.size()-1);
        }
        return null;
    }
}
