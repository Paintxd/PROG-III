package com.github.paintxd.locadora.models.dtos;

public class ValorCarroDto {
    private Long id;
    private Double valorLocacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(Double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }
}
