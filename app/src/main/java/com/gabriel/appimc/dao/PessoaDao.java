package com.gabriel.appimc.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.gabriel.appimc.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaDao extends SQLiteOpenHelper {
    public PessoaDao(Context context) {
        super(context, "AppImc", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Pessoas (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, peso REAL, altura REAL, data TEXT, imc REAL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Pessoas";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Pessoa pessoa){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosDaPessoa(pessoa);
        db.insert("Pessoas",null,dados);
    }

    @NonNull
    private ContentValues pegaDadosDaPessoa(Pessoa pessoa) {
        ContentValues dados = new ContentValues();
        dados.put("nome", pessoa.getNome());
        dados.put("peso", pessoa.getPeso());
        dados.put("altura", pessoa.getAltura());
        dados.put("data", pessoa.getData());
        dados.put("imc", pessoa.getImc());
        return dados;
    }

    public List<Pessoa> buscaPessoas(){
        String sql = "SELECT * from Pessoas;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Pessoa> pessoas = new ArrayList<>();
        while (c.moveToNext()){
            Pessoa pessoa = new Pessoa();
            double peso = c.getDouble(c.getColumnIndex("peso"));
            double altura = c.getDouble(c.getColumnIndex("altura"));

            pessoa.setId(c.getLong(c.getColumnIndex("id")));
            pessoa.setNome(c.getString(c.getColumnIndex("nome")));
            pessoa.setAltura(altura);
            pessoa.setPeso(peso);
            pessoa.setImc(peso, altura);
            pessoa.setData(c.getString(c.getColumnIndex("data")));
            pessoas.add(pessoa);
        }
        c.close();
        return pessoas;
    }

    public List<String> buscarDatas() {
        String sql = "SELECT * from Pessoas;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<String> datas = new ArrayList<>();
        while (c.moveToNext()){
            datas.add(c.getString(c.getColumnIndex("data")));
        }
        c.close();
        return datas;
    }

    public List<Pessoa> buscaPessoasPorData(String data) {
        String sql = "SELECT * from Pessoas where data ="+data+";";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Pessoa> pessoas = new ArrayList<>();
        while (c.moveToNext()){
            Pessoa pessoa = new Pessoa();
            double peso = c.getDouble(c.getColumnIndex("peso"));
            double altura = c.getDouble(c.getColumnIndex("altura"));

            pessoa.setId(c.getLong(c.getColumnIndex("id")));
            pessoa.setNome(c.getString(c.getColumnIndex("nome")));
            pessoa.setAltura(altura);
            pessoa.setPeso(peso);
            pessoa.setImc(peso, altura);
            pessoa.setData(c.getString(c.getColumnIndex("data")));
            pessoas.add(pessoa);
        }
        c.close();
        return pessoas;
    }
}
