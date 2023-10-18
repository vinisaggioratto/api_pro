package com.vinicius.condominiopro.controllers;

import java.util.List;

import com.vinicius.condominiopro.services.ApartamentoService;
import com.vinicius.condominiopro.services.CondominoApartamentoService;
import com.vinicius.condominiopro.services.CondominoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.condominoApartamento.CondominoApartamento;
import com.vinicius.condominiopro.repository.CondominoApartamentoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vincular")
@CrossOrigin(origins = "*")
public class CondominoApartamentoController {

    @Autowired
    private CondominoApartamentoRepository repository;
    @Autowired
    private CondominoApartamentoService service;
    @Autowired
    private CondominoService condominoService;
    @Autowired
    private ApartamentoService apartamentoService;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CondominoApartamento dados) {
        dados.setCondomino(condominoService.retornarIdCondomino(dados.getCondomino().getNome()));
        dados.setApartamento(apartamentoService.buscarPorNumero(dados.getApartamento().getNumero()));
        service.salvar(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> atualizar(@Valid @RequestBody CondominoApartamento dados, @PathVariable Long id) {
        CondominoApartamento condominoApartamentoExistente = service.buscarPorId(id);
        if (condominoApartamentoExistente != null) {
            condominoApartamentoExistente.setCondomino(condominoService.retornarIdCondomino(dados.getCondomino().getNome()));
            condominoApartamentoExistente.setApartamento(apartamentoService.buscarPorNumero(dados.getApartamento().getNumero()));
            condominoApartamentoExistente.setData_entrada(dados.getData_entrada());
            condominoApartamentoExistente.setData_saida(dados.getData_saida());
            service.salvar(condominoApartamentoExistente);
            return ResponseEntity.ok("Vínculo atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<CondominoApartamento> listar() {
        List<CondominoApartamento> condominoApartamentos = service.listar();
        return condominoApartamentos;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
