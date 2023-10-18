package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.pais.Pais;
import com.vinicius.condominiopro.services.ItemEstoqueService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.itemEstoque.ItemEstoque;
import com.vinicius.condominiopro.repository.ItemEstoqueRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/itensestoque")
@CrossOrigin(origins = "*")
public class ItemEstoqueController {

    @Autowired
    private ItemEstoqueRepository repository;
    @Autowired
    private ItemEstoqueService service;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ItemEstoque dados) {
        service.salvar(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> atualizar(@Valid @RequestBody ItemEstoque dados, @PathVariable Long id) {

        Optional<ItemEstoque> itemEstoqueExistente = repository.findById(id);
        if (itemEstoqueExistente.isPresent()) {
            ItemEstoque itemEstoque = itemEstoqueExistente.get();
            itemEstoque.setDescricao(dados.getDescricao());
            itemEstoque.setEstoque(dados.getEstoque());
            service.salvar(itemEstoque);
            return ResponseEntity.ok("Item do estoque atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<ItemEstoque> listar() {
        List<ItemEstoque> itemEstoques = service.listar();
        return itemEstoques;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
