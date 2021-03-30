package com.github.paintxd.locadora.models.dtos;

import com.github.paintxd.locadora.models.Carro;
import com.github.paintxd.locadora.models.Cliente;
import com.github.paintxd.locadora.models.Locacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class LocacaoDto {
    private Long carroId;
    private Long clienteId;
    private Date dataLocacao;
    private Date estimativaDevolucao;
    private Double valorCobrado;

    public Long getCarroId() {
        return carroId;
    }

    public void setCarroId(Long carroId) {
        this.carroId = carroId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao() {
        this.dataLocacao = new Date(System.currentTimeMillis());
    }

    public Date getEstimativaDevolucao() {
        return estimativaDevolucao;
    }

    public void setEstimativaDevolucao(String estimativaDevolucao) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.estimativaDevolucao = formatter.parse(estimativaDevolucao);
    }

    public Double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(Double valorLocacao) {
        Long diasLocacao = Duration.between(dataLocacao.toInstant(), estimativaDevolucao.toInstant()).toDays();

        this.valorCobrado = diasLocacao > 0 ? valorLocacao * diasLocacao : valorLocacao;
    }

    public Locacao createLocacao(Carro carro, Cliente cliente) {
        setDataLocacao();
        setValorCobrado(carro.getValorLocacao());
        return new Locacao(carro, cliente, dataLocacao, estimativaDevolucao, valorCobrado);
    }
}
