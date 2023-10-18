package com.vinicius.condominiopro.controllers;

import java.util.List;

import com.vinicius.condominiopro.services.EntradaEstoqueService;
import com.vinicius.condominiopro.services.FornecedorService;
import com.vinicius.condominiopro.services.ItemEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.entradaEstoque.EntradaEstoque;
import com.vinicius.condominiopro.repository.EntradaEstoqueRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/entradaestoque")
@CrossOrigin(origins = "*")
public class EntradaEstoqueController {

    @Autowired
    private EntradaEstoqueRepository repository;
    @Autowired
    private EntradaEstoqueService service;
    @Autowired
    private ItemEstoqueService itemEstoqueService;
    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody EntradaEstoque dados) {
        dados.setItemEstoque(itemEstoqueService.buscarItemEstoque(dados.getItemEstoque().getDescricao()));
        dados.setFornecedor(fornecedorService.retornarIdFornecedor(dados.getFornecedor().getNome()));
        service.salvar(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> atualizar(@Valid @RequestBody EntradaEstoque dados, @PathVariable Long id) {
        EntradaEstoque entradaEstoqueExistente = service.buscarPorId(dados.getId());

        if (entradaEstoqueExistente != null) {
            entradaEstoqueExistente.setNome(dados.getNome());
            entradaEstoqueExistente.setQuantidade(dados.getQuantidade());
            entradaEstoqueExistente.setValor_unitario(dados.getValor_unitario());
            entradaEstoqueExistente.setData_entrada(dados.getData_entrada());
            entradaEstoqueExistente.setItemEstoque(itemEstoqueService.buscarItemEstoque(dados.getItemEstoque().getDescricao()));
            entradaEstoqueExistente.setFornecedor(fornecedorService.retornarIdFornecedor(dados.getFornecedor().getNome()));
            service.salvar(entradaEstoqueExistente);
            return ResponseEntity.ok("Entrada de estoque atualizada com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<EntradaEstoque> listar() {
        List<EntradaEstoque> entradaEstoques = service.listar();
        return entradaEstoques;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
