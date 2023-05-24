/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author LEDS
 */

@Entity
public class CarrinhoCompra implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idCarrinhoCompra;
    
    private float frete;
    private float total;
    
    @OneToMany(mappedBy = "carrinho", fetch = FetchType.EAGER)
    private List<Item> listaItens;
    
    // Hibernate
    public CarrinhoCompra() {
    }

    public CarrinhoCompra(int idCarrinhoCompra, float frete, float total, List<Item> listaItens) {
        this.idCarrinhoCompra = idCarrinhoCompra;
        this.frete = frete;
        this.total = total;
        this.listaItens = listaItens;
    }

    public CarrinhoCompra(float frete, float total, List<Item> listaItens) {
        this.frete = frete;
        this.total = total;
        this.listaItens = listaItens;
    }

    @Override
    public String toString() {
        return "CarrinhoCompra{" + "frete=" + frete + ", total=" + total + ", listaItens=" + listaItens + '}';
    }

    public int getIdCarrinhoCompra() {
        return idCarrinhoCompra;
    }

    public void setIdCarrinhoCompra(int idCarrinhoCompra) {
        this.idCarrinhoCompra = idCarrinhoCompra;
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<Item> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<Item> listaItens) {
        this.listaItens = listaItens;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.idCarrinhoCompra;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CarrinhoCompra other = (CarrinhoCompra) obj;
        if (this.idCarrinhoCompra != other.idCarrinhoCompra) {
            return false;
        }
        return true;
    }
}
