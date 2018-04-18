package com.gabriel.appimc.model;

import java.io.Serializable;
import java.util.List;

public class Pessoa implements Serializable {
    private Long id;
    private String nome;
    private double peso;
    private double altura;
    private String data;
    private double imc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double peso, double altura) {
        this.imc = (peso/(altura*altura));
    }

    @Override
    public String toString() {
        return getData() + " - " + getImc();
    }
}
