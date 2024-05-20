/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import com.sun.istack.Nullable;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author LEDS
 */

@Entity
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idCliente;
    
    @Column (length = 50, nullable = false)
    private String nome;
    
    @Column (length = 50, nullable = false)
    private String email;
    
    @Column (length = 50, nullable = false)
    private String senha;
    
    @Column (length = 50, nullable = false)
    private String cidade;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CarrinhoCompra> pedidos = new ArrayList();

    // Hibernate
    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String email, String senha, String cidade, List<CarrinhoCompra> pedidos) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.pedidos = pedidos;
    }

    public Cliente(String nome, String email, String senha, String cidade) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<CarrinhoCompra> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<CarrinhoCompra> pedidos) {
        this.pedidos = pedidos;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.idCliente;
        hash = 19 * hash + Objects.hashCode(this.email);
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
}
