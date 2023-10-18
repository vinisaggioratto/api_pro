package com.vinicius.condominiopro.controllers;

import java.util.List;

import com.vinicius.condominiopro.services.ItemEstoqueService;
import com.vinicius.condominiopro.services.SaidaEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.repository.SaidaEstoqueRepository;
import com.vinicius.condominiopro.saidaEstoque.SaidaEstoque;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/saidasestoque")
@CrossOrigin(origins = "*")
public class SaidaEstoqueController {

    @Autowired
    private SaidaEstoqueRepository repository;
    @Autowired
    private SaidaEstoqueService service;
    @Autowired
    private ItemEstoqueService itemEstoqueService;

    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody SaidaEstoque dados) {
        dados.setItemEstoque(itemEstoqueService.buscarItemEstoque(dados.getItemEstoque().getDescricao()));
        service.salvar(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> atualizar(@Valid @RequestBody SaidaEstoque dados, @PathVariable Long id) {
        SaidaEstoque saidaEstoqueExistente = service.buscarPorId(id);

        if (saidaEstoqueExistente != null) {
            saidaEstoqueExistente.setItemEstoque(itemEstoqueService.buscarItemEstoque(dados.getItemEstoque().
                    getDescricao()));
            saidaEstoqueExistente.setQuantidade(dados.getQuantidade());
            saidaEstoqueExistente.setData_saida(dados.getData_saida());
            service.salvar(saidaEstoqueExistente);
            return ResponseEntity.ok("Saída de estoque atualizada com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public List<SaidaEstoque> listar() {
        List<SaidaEstoque> saidaEstoques = service.listar();
        return saidaEstoques;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
