package com.example.jogo_dados;

public class Inscritos {
    private int id;
    private int pontos;
    private int aposta1;
    private int aposta2;
    private String jogador1;
    private String jogador2;

    public Inscritos() {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.pontos = pontos;
    }

    public Inscritos(String jogador1, String jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getAposta1() {
        return aposta1;
    }

    public void setAposta1(int aposta1) {
        this.aposta1 = aposta1;
    }

    public int getAposta2() {
        return aposta2;
    }

    public void setAposta2(int aposta2) {
        this.aposta2 = aposta2;
    }

    public String getJogador1() {
        return jogador1;
    }

    public void setJogador1(String jogador1) {
        this.jogador1 = jogador1;
    }

    public String getJogador2() {
        return jogador2;
    }

    public void setJogador2(String jogador2) {
        this.jogador2 = jogador2;
    }
}
