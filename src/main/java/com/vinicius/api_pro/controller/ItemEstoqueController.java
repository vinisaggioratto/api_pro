package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.ItemEstoqueEntity;
import com.vinicius.api_pro.service.ItemEstoqueService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itensestoque")
@CrossOrigin(origins = "*")
public class ItemEstoqueController {

    @Autowired
    private ItemEstoqueService service;

    @GetMapping
    public ResponseEntity<List> getAllItems() {
        List<ItemEstoqueEntity> item = service.listarTodosItemEstoque();
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<ItemEstoqueEntity> getItemEstoqueById(@PathVariable Long id) {
        ItemEstoqueEntity item = service.getItemEstoqueId(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ItemEstoqueEntity> addItemEstoque(@Valid @RequestBody ItemEstoqueEntity item) {
        var novoItemEstoque = service.criarItemEstoque(item);

        return new ResponseEntity<>(novoItemEstoque, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ItemEstoqueEntity> atualizarItemEstoque(@PathVariable Long id, 
            @RequestBody ItemEstoqueEntity item) {

        ItemEstoqueEntity itemExistente = service.getItemEstoqueId(id);

        if (itemExistente != null) {

            itemExistente.setDescricao(item.getDescricao());
            itemExistente.setEstoque(item.getEstoque());

            var itemAtualizado = service.atualizarItemEstoque(id, itemExistente);
            return new ResponseEntity<>(itemAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarItemEstoque(@PathVariable Long id) {
        service.deletarItemEstoque(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }    
}
