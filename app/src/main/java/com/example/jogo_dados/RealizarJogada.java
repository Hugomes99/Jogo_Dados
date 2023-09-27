package com.example.jogo_dados;

import android.widget.TextView;
import android.widget.VideoView;

import java.util.Random;

public class RealizarJogada {
    private static Random rnd = new Random();
    private VideoView videoDado;

    public static int executar_jogada(VideoView video) {
        VideoView videoDado;
        videoDado = video;
        int dado = (rnd.nextInt(6)+1);
        videoDado.setVideoPath(String.valueOf(dado));

        if (dado == 1) {
            videoDado.setVideoPath("android.resource://" + "com.example.jogo_dados" + "/" + R.raw.dado01);
        } else if (dado == 2) {
            videoDado.setVideoPath("android.resource://" + "com.example.jogo_dados" + "/" + R.raw.dado02);
        } else if (dado == 3) {
            videoDado.setVideoPath("android.resource://" + "com.example.jogo_dados" + "/" + R.raw.dado03);
        } else if (dado == 4) {
            videoDado.setVideoPath("android.resource://" + "com.example.jogo_dados" + "/" + R.raw.dado04);
        } else if (dado == 5) {
            videoDado.setVideoPath("android.resource://" + "com.example.jogo_dados" + "/" + R.raw.dado05);
        } else if(dado == 6) {
            videoDado.setVideoPath("android.resource://" + "com.example.jogo_dados" + "/" + R.raw.dado06);
        }
        return dado;
    }

    public static String definirVencedor (int aposta1, int aposta2, int somaDados){
        int apostaJ1 = aposta1;
        int apostaJ2 = aposta2;
        int somaDadost = somaDados;
        String vencedor;
        if(somaDadost == aposta1){
            vencedor = "jogador 1 venceu a partida";
            return vencedor;
        }
        if(somaDadost == aposta2){
            vencedor = "jogador 2 venceu a partida";
            return vencedor;
        }
        if(somaDadost != apostaJ1 && somaDados != apostaJ2);
            vencedor = "sem vencedores";
        return vencedor;
    }
}