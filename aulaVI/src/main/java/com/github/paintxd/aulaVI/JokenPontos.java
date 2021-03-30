package com.github.paintxd.aulaVI;

public class JokenPontos {
    private int jogador;
    private int maquina;

    public JokenPontos() {
        this.jogador = 0;
        this.maquina = 0;
    }

    public int getJogador() {
        return jogador;
    }

    public void setJogador() {
        this.jogador += 1;
    }

    public int getMaquina() {
        return maquina;
    }

    public void setMaquina() {
        this.maquina += 1;
    }
}
