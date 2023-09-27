package com.example.jogo_dados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityApostar extends AppCompatActivity {

    private TextView campoAposta1, campoAposta2;
    Button btRolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apostar);
        campoAposta1 = findViewById(R.id.campoAposta1);
        campoAposta2 = findViewById(R.id.campoAposta2);
        btRolar = findViewById(R.id.btRolar);

        BancoDados banco = new BancoDados(this);

        btRolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Integer.parseInt(campoAposta1.getText().toString()) < 2 || Integer.parseInt(campoAposta1.getText().toString()) > 12) {
                    Toast.makeText(getApplicationContext(), "Apostas inválidas", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(campoAposta2.getText().toString()) < 2 || Integer.parseInt(campoAposta2.getText().toString()) > 12) {
                    Toast.makeText(getApplicationContext(), "Apostas inválidas", Toast.LENGTH_LONG).show();

                } else {

                    Inscritos jog = new Inscritos(campoAposta1.getText().toString(), campoAposta2.getText().toString());
                    banco.adApostas(jog);
                    Toast.makeText(getApplicationContext(), "Apostas feitas com sucesso!", Toast.LENGTH_LONG).show();

                    Intent tela3 = new Intent(getApplicationContext(), ActivityDados.class);

                    tela3.putExtra("valor1", campoAposta1.getText().toString());
                    tela3.putExtra("valor2", campoAposta2.getText().toString());

                    startActivity(tela3);
                }
            }
        });
    }
}