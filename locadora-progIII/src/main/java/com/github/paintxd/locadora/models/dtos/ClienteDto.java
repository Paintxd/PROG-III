package com.github.paintxd.locadora.models.dtos;

import com.github.paintxd.locadora.models.Cliente;
import com.github.paintxd.locadora.models.Cnh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClienteDto {
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private String telefone;
    private String email;
    private String endereco;
    private String numero;
    private String categoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.dataNascimento = formatter.parse(dataNascimento);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Cnh createCnh(Cliente cliente) {
        return new Cnh(numero, categoria, cliente);
    }

    public Cliente createClient() {
        return new Cliente(nome, sobrenome, dataNascimento, telefone, email, endereco);
    }
}
