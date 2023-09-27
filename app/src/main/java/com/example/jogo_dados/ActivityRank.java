package com.example.jogo_dados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.List;
import android.widget.TextView;



public class ActivityRank extends AppCompatActivity {
    TextView listaRank;
    Button btInicio;
    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        btInicio = (Button) findViewById(R.id.btInicio);
        listaRank = (TextView) findViewById(R.id.listaRank);

        BancoDados banco = new BancoDados(this);


        List<Inscritos> inscritos = banco.listaTodosInscritos();
        for (Inscritos i : inscritos) {
            String log = "Nome: " + i.getJogador1() + ", Pontos: " + i.getPontos() + "\n" + " Nome: " + i.getJogador2() + ", Pontos: " + i.getPontos() + "\n";
            text = text + log;
        }
        listaRank.setText(text);
        text = "";



        btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tela1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(tela1);
            }
        });

    }
}