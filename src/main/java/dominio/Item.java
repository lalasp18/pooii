/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author 2020122760226
 */

@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idItem;
    
    @ManyToOne
    @JoinColumn(name = "origami_id")
    private Origami origami;
    
    private int qtd;
    
    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private CarrinhoCompra carrinho;

    public Item() {
    }

    public Item(int idItem, Origami origami, int qtd, CarrinhoCompra carrinho) {
        this.idItem = idItem;
        this.origami = origami;
        this.qtd = qtd;
        this.carrinho = carrinho;
    }

    public Item(Origami origami, int qtd, CarrinhoCompra carrinho) {
        this.origami = origami;
        this.qtd = qtd;
        this.carrinho = carrinho;
    }

    @Override
    public String toString() {
        return "Item{" + "origami=" + origami + ", carrinho=" + carrinho + '}';
    }
    
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public Origami getOrigami() {
        return origami;
    }

    public void setOrigami(Origami origami) {
        this.origami = origami;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public CarrinhoCompra getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoCompra carrinho) {
        this.carrinho = carrinho;
    }
}
