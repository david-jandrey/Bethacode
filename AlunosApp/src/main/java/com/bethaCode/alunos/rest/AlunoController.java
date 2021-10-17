package com.bethaCode.alunos.rest;

import com.bethaCode.alunos.model.entity.Aluno;
import com.bethaCode.alunos.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoRepository repository;

    @Autowired
    public AlunoController(AlunoRepository repository){
        this.repository =repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar (@Valid @RequestBody Aluno aluno){
        return  repository.save(aluno);
    }

    @GetMapping("{id}")
    public Aluno acharPorId (@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository
                .findById(id)
                .map(aluno -> {
                    repository.delete(aluno);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @Valid @RequestBody Aluno dadoAtulizado){
        repository
                .findById(id)
                .map(aluno -> {
                    aluno.setNome(dadoAtulizado.getNome());
                    aluno.setIdade(dadoAtulizado.getIdade());
                    aluno.setNumero(dadoAtulizado.getNumero());
                    aluno.setRua(dadoAtulizado.getRua());
                    aluno.setCep(dadoAtulizado.getCep());
                    aluno.setBairro(dadoAtulizado.getBairro());
                    aluno.setCidade(dadoAtulizado.getCidade());
                    aluno.setUf(dadoAtulizado.getUf());
                    return repository.save(aluno);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
