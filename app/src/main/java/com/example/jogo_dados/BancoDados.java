package com.example.jogo_dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BancoDados extends SQLiteOpenHelper {
    private static String BANCO_NOMES = "bancoInscritos";
    private static int VERSAO = 1;
    public static final String TABELA_INSCRITOS = "inscritos";
    public static final String CAMPO_ID = "id";
    public static final String JOGADOR1 = "jogador1";
    public static final String JOGADOR2 = "jogador2";
    public static final String CAMPO_APOSTA1 = "aposta1";
    public static final String CAMPO_APOSTA2 = "aposta2";
    public static final String CAMPO_PONTOS = "pontos";

    public BancoDados(Context context) {
        super(context, BANCO_NOMES, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase banco) {
        String TabelaInscritos = "CREATE TABLE " + TABELA_INSCRITOS + "(" +
                CAMPO_ID + " INTEGER PRIMARY KEY," +
                JOGADOR1 + " TEXT," +
                JOGADOR2 + " TEXT," +
                CAMPO_APOSTA1 + " INT," +
                CAMPO_APOSTA2 + " INT," +
                CAMPO_PONTOS + " INT"+")";
        banco.execSQL(TabelaInscritos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase banco, int i, int i1) {
        banco.execSQL("DROP TABLE IF EXISTS " + TABELA_INSCRITOS);
        onCreate(banco);
    }

    public void adInscritos(Inscritos inscritos) {

        SQLiteDatabase banco = getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(JOGADOR1, inscritos.getJogador1());
        values.put(JOGADOR2, inscritos.getJogador2());

        banco.insert(TABELA_INSCRITOS, null, values);
        banco.close();
    }

    public void pontuacao(Inscritos inscritos) {
        SQLiteDatabase banco = getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(CAMPO_PONTOS, inscritos.getPontos());

        banco.insert(TABELA_INSCRITOS, null, values);
        banco.close();
    }

    public void adApostas(Inscritos inscritos) {
        SQLiteDatabase banco = getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(CAMPO_APOSTA1, inscritos.getAposta1());
        values.put(CAMPO_APOSTA2, inscritos.getAposta2());

        banco.insert(TABELA_INSCRITOS, null, values);
        banco.close();
    }



    public List<Inscritos> listaTodosInscritos() {
        List<Inscritos> listaInscritos = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABELA_INSCRITOS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do
            {
                Inscritos inscritos = new Inscritos();
                inscritos.setJogador1(cursor.getString(0));
                inscritos.setJogador2(cursor.getString(1));
                inscritos.setPontos(Integer.parseInt(cursor.getString(2)));
                listaInscritos.add(inscritos);
            }
            while (cursor.moveToNext());
        }
        return listaInscritos;
    }



}
