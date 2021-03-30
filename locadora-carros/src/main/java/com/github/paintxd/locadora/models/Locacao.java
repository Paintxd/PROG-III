package com.github.paintxd.locadora.models;

import javax.persistence.*;
import java.time.Duration;
import java.util.Date;

@Entity
@Table(name = "locacoes")
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private Date dataLocacao;
    private Date estimativaDevolucao;
    private Date devolucao;
    private Double valorCobrado;
    private Double valorPago;
    private Double multa;

    public Locacao() {
    }

    public Locacao(Carro carro, Cliente cliente, Date dataLocacao, Date estimativaDevolucao, Double valorCobrado) {
        this.carro = carro;
        this.cliente = cliente;
        this.dataLocacao = dataLocacao;
        this.estimativaDevolucao = estimativaDevolucao;
        this.valorCobrado = valorCobrado;
    }

    public Long getId() {
        return id;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getEstimativaDevolucao() {
        return estimativaDevolucao;
    }

    public void setEstimativaDevolucao(Date estimativaDevolucao) {
        this.estimativaDevolucao = estimativaDevolucao;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao() {
        this.devolucao = new Date(System.currentTimeMillis());
    }

    public Double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(Double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago() {
        this.valorPago = valorCobrado + multa;
    }

    public Double getMulta() {
        if (multa != null) return multa;

        return calculoMulta();
    }

    public void setMulta() {
        this.multa = calculoMulta();
    }

    private Double calculoMulta() {
        Long diasPassados = Duration.between(estimativaDevolucao.toInstant(), devolucao.toInstant()).toDays();
        Double valorMulta = carro.getValorLocacao() * 0.25;
        return valorMulta * diasPassados;
    }
}
