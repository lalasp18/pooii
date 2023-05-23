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
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "origami_id")
    private List<Origami> origami;
    
    private float frete;

    // Hibernate
    public CarrinhoCompra() {
    }

    public CarrinhoCompra(int idCarrinhoCompra, List<Origami> origami, float frete) {
        this.idCarrinhoCompra = idCarrinhoCompra;
        this.origami = origami;
        this.frete = frete;
    }

    public CarrinhoCompra(List<Origami> origami, float frete) {
        this.origami = origami;
        this.frete = frete;
    }

    @Override
    public String toString() {
        return "CarrinhoCompra{" + "origami=" + origami + '}';
    }
    
    public int getIdCarrinhoCompra() {
        return idCarrinhoCompra;
    }

    public void setIdCarrinhoCompra(int idCarrinhoCompra) {
        this.idCarrinhoCompra = idCarrinhoCompra;
    }

    public List<Origami> getOrigami() {
        return origami;
    }

    public void setOrigami(List<Origami> origami) {
        this.origami = origami;
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.idCarrinhoCompra;
        hash = 19 * hash + Objects.hashCode(this.origami);
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
        if (!Objects.equals(this.origami, other.origami)) {
            return false;
        }
        return true;
    }
}
