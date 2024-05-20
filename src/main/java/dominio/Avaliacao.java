/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author LEDS
 */

@Entity
public class Avaliacao implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idAvaliacao;
    
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @OneToOne
    @JoinColumn(name = "origami_id")
    private Origami origami;
    private int nota;
    
    @Column (length = 150, nullable = false)
    private String comentario;

    // Hibernate
    public Avaliacao() {
    }

    public Avaliacao(int idAvaliacao, Cliente cliente, Origami origami, int nota, String comentario) {
        this.idAvaliacao = idAvaliacao;
        this.cliente = cliente;
        this.origami = origami;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Avaliacao(Cliente cliente, Origami origami, int nota, String comentario) {
        this.cliente = cliente;
        this.origami = origami;
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Origami getOrigami() {
        return origami;
    }

    public void setOrigami(Origami origami) {
        this.origami = origami;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.idAvaliacao;
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
        final Avaliacao other = (Avaliacao) obj;
        if (this.idAvaliacao != other.idAvaliacao) {
            return false;
        }
        return true;
    }
}
