package com.example.jogo_dados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText campoJogador1, campoJogador2;
    Button btCadastrar, btApostas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campoJogador1 = findViewById(R.id.campoJogador1);
        campoJogador2 = findViewById(R.id.campoJogador2);
        btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btApostas = (Button) findViewById(R.id.btApostas);

        BancoDados banco = new BancoDados(this);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Inscritos jog = new Inscritos(campoJogador1.getText().toString(), campoJogador2.getText().toString());
                    banco.adInscritos(jog);
                    Toast.makeText(getApplicationContext(), "Jogadores inseridos com sucesso!", Toast.LENGTH_LONG).show();
            }
        });

        btApostas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tela2 = new Intent(getApplicationContext(), ActivityApostar.class);
                startActivity(tela2);
            }
        });

    }
}