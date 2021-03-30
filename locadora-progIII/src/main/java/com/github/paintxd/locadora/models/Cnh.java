package com.github.paintxd.locadora.models;

import javax.persistence.*;

@Entity
@Table(name = "CNH")
public class Cnh {
    @Id
    @Column(name = "cliente_id")
    private Long id;
    private String numero;
    private String categoria;
    @OneToOne
    @MapsId
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Cnh() {
    }

    public Cnh(String numero, String categoria, Cliente cliente) {
        this.numero = numero;
        this.categoria = categoria;
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
