package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;


import com.vinicius.condominiopro.services.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vinicius.condominiopro.apartamento.Apartamento;
import com.vinicius.condominiopro.repository.ApartamentoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/apartamentos")
public class ApartamentoController {

    @Autowired
    private ApartamentoRepository repository;

    @Autowired
    private ApartamentoService service;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid Apartamento dados) {

        service.salvar(dados);
    }

    @GetMapping
    public List<Apartamento> listar(){
        List<Apartamento> apto = service.listar();
        return apto;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> atualizar(@Valid @RequestBody Apartamento dados, @PathVariable Long id) {

        Optional<Apartamento> apartamentoExistente = repository.findById(id);
        if (apartamentoExistente.isPresent()) {
            Apartamento apartamento = apartamentoExistente.get();

            apartamento.setNumero(dados.getNumero());
            apartamento.setAndar(dados.getAndar());
            apartamento.setBloco(dados.getBloco());
            apartamento.setStatus(dados.getStatus());
            service.salvar(apartamento);
            return ResponseEntity.ok("Apartamento atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        service.deletar(id);
    }
}
