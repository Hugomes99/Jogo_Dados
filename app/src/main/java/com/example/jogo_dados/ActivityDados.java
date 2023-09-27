package com.example.jogo_dados;

import static com.example.jogo_dados.RealizarJogada.definirVencedor;
import static com.example.jogo_dados.RealizarJogada.executar_jogada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class ActivityDados extends AppCompatActivity {
    private TextView textVencedor;
    private TextView valorDado1, valorDado2, valorDados;
    VideoView dado1, dado2;
    Button btNova, btRank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        btNova = (Button) findViewById(R.id.btNova);
        btRank = (Button) findViewById(R.id.btRank);
        dado1 = (VideoView) findViewById(R.id.dado1);
        dado2 = (VideoView) findViewById(R.id.dado2);
        textVencedor = (TextView) findViewById(R.id.textVencedor);
        valorDado1 = (TextView) findViewById(R.id.valorDado1);
        valorDado2 = (TextView) findViewById(R.id.valorDado2);
        valorDados = (TextView) findViewById(R.id.valorDados);

        Intent tela3 = getIntent();
        String valor1 = tela3.getStringExtra("valor1");
        String valor2 = tela3.getStringExtra("valor2");

        valorDado1.setText(valor1);
        valorDado2.setText(valor2);

        int valor01 = executar_jogada(dado1);
        dado1.start();
        int valor02 = executar_jogada(dado2);
        dado2.start();
        int result_somaDados = valor01+valor02;

        valorDados.setText(String.valueOf(result_somaDados));

        String vencedor = definirVencedor(Integer.parseInt(valor1), Integer.parseInt(valor2), result_somaDados);
        textVencedor.setText(vencedor);


        btNova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tela3 = getIntent();
                String valor1 = tela3.getStringExtra("valor1");
                String valor2 = tela3.getStringExtra("valor2");

                valorDado1.setText(valor1);
                valorDado2.setText(valor2);

                int valor01 = executar_jogada(dado1);
                dado1.start();
                int valor02 = executar_jogada(dado2);
                dado2.start();
                int result_somaDados = valor01+valor02;

                valorDados.setText(String.valueOf(result_somaDados));

                String vencedor = definirVencedor(Integer.parseInt(valor1), Integer.parseInt(valor2), result_somaDados);
                textVencedor.setText(vencedor);


            }
        });

        btRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tela4 = new Intent(getApplicationContext(), ActivityRank.class);
                startActivity(tela4);
            }
        });
    }
}
