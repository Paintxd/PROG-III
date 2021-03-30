package com.github.paintxd.locadora.models;

import javax.persistence.*;

@Entity
@Table(name = "carros")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String marca;
    @Enumerated(EnumType.STRING)
    private Modelo modelo;
    @Column(name = "valor")
    private Double valorLocacao;

    public Carro() {
    }

    public Carro(String nome, String marca, Modelo modelo, Double valorLocacao) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.valorLocacao = valorLocacao;
    }

    public String getNomeMarca() {
        return nome + " - " + marca;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(Double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }
}
