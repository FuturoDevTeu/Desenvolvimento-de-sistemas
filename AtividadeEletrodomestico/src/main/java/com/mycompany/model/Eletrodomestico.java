package com.mycompany.model;

public class Eletrodomestico {
    private int id;
    private String nome, marca;
    private double voltagem, preco;
    
    public Eletrodomestico() {
    }

    public Eletrodomestico(int id, String nome, String marca, double voltagem, double preco) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.voltagem = voltagem;
        this.preco = preco;
    }

    public Eletrodomestico(String nome, String marca, double voltagem, double preco) {
        this.nome = nome;
        this.marca = marca;
        this.voltagem = voltagem;
        this.preco = preco;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(double voltagem) {
        this.voltagem = voltagem;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    
}
