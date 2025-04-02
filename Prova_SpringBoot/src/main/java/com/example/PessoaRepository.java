package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepository {
    private final List<Pessoa> pessoas = new ArrayList<>();

    public void adicionar(Pessoa pessoa) {
        // Aqui você pode incluir a validação de CPF antes de adicionar
        if(!validarCpf(pessoa.getCpf())){
            throw new IllegalArgumentException("CPF inválido");
        }
        pessoas.add(pessoa);
    }

    public List<Pessoa> listarTodos() {
        return pessoas;
    }

    // Simples validação de CPF (exemplo, verificação de tamanho; substitua pela validação real se necessário)
    private boolean validarCpf(String cpf) {
        // Exemplo: CPF deve ter 11 dígitos (você pode implementar a lógica completa do CPF)
        return cpf != null && cpf.replaceAll("[^0-9]", "").length() == 11;
    }
}
