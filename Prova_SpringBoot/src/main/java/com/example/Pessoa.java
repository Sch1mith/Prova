package com.example;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public abstract class Pessoa {

    @NotBlank(message = "Nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "CPF não pode estar em branco")
    @CPF(message = "CPF inválido")
    private String cpf;

    @Min(value = 0, message = "Idade não pode ser negativa")
    private int idade;

    public Pessoa(String nome, String cpf, int idade) {
        if(nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    // Apenas permite alterar nome se a pessoa tiver mais de 18 anos
    public void setNome(String nome) {
        if(this.idade <= 18) {
            throw new IllegalArgumentException("Pessoa com 18 anos ou menos não pode trocar de nome");
        }
        if(nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }
}
