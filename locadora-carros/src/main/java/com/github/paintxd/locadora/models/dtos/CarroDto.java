package com.github.paintxd.locadora.models.dtos;

import com.github.paintxd.locadora.models.Carro;
import com.github.paintxd.locadora.models.Modelo;

public class CarroDto {
    private String nome;
    private String marca;
    private Modelo modelo;
    private Double valorLocacao;

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

    public void setModelo(String modelo) {
        this.modelo = Modelo.valueOf(modelo);
    }

    public Double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(Double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public Carro createCarro() {
        return new Carro(nome, marca, modelo, valorLocacao);
    }
}
