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
public class Origami implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idOrigami;
    
    @Column (length = 50, nullable = false)
    private String nome;
    
    @Column (length = 50, nullable = false)
    private String dificuldade;
    private float preco;
    
    @Column (length = 50, nullable = false)
    private String categoria;
    
    @Column (length = 50, nullable = false)
    private String tipoPapel;
    private int qtdPecas;
    
    @Lob
    private byte[] foto;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> materiais;
    
    // Hibernate
    public Origami() {
    }

    public Origami(int idOrigami, String nome, String dificuldade, float preco, String categoria, String tipoPapel, int qtdPecas, byte[] foto, List<String> materiais) {
        this.idOrigami = idOrigami;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.preco = preco;
        this.categoria = categoria;
        this.tipoPapel = tipoPapel;
        this.qtdPecas = qtdPecas;
        this.foto = foto;
        this.materiais = materiais;
    }

    public Origami(String nome, String dificuldade, float preco, String categoria, String tipoPapel, int qtdPecas, byte[] foto, List<String> materiais) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.preco = preco;
        this.categoria = categoria;
        this.tipoPapel = tipoPapel;
        this.qtdPecas = qtdPecas;
        this.foto = foto;
        this.materiais = materiais;
    }

    @Override
    public String toString() {
        return '{' + nome + foto + '}';
    }

    public int getIdOrigami() {
        return idOrigami;
    }

    public void setIdOrigami(int idOrigami) {
        this.idOrigami = idOrigami;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoPapel() {
        return tipoPapel;
    }

    public void setTipoPapel(String tipoPapel) {
        this.tipoPapel = tipoPapel;
    }

    public int getQtdPecas() {
        return qtdPecas;
    }

    public void setQtdPecas(int qtdPecas) {
        this.qtdPecas = qtdPecas;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public List<String> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<String> materiais) {
        this.materiais = materiais;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.idOrigami;
        hash = 19 * hash + Objects.hashCode(this.nome);
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
        final Origami other = (Origami) obj;
        if (this.idOrigami != other.idOrigami) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}
