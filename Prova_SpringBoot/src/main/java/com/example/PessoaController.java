package com.example;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @PostMapping("/alunos")
public String inserirAluno(@Valid @RequestBody Aluno aluno) {
    repository.adicionar(aluno);
    return "Aluno inserido com sucesso!";
}

@PostMapping("/professores")
public String inserirProfessor(@Valid @RequestBody Professor professor) {
    repository.adicionar(professor);
    return "Professor inserido com sucesso!";
}

    // Endpoint para listar alunos
    @GetMapping("/alunos")
    public List<Pessoa> listarAlunos() {
        return repository.listarTodos()
                         .stream()
                         .filter(p -> p instanceof Aluno)
                         .collect(Collectors.toList());
    }

    

    // Endpoint para listar professores
    @GetMapping("/professores")
    public List<Pessoa> listarProfessores() {
        return repository.listarTodos()
                         .stream()
                         .filter(p -> p instanceof Professor)
                         .collect(Collectors.toList());
    }
}

