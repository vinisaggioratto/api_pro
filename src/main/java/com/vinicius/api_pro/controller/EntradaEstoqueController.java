package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.EntradaEstoqueEntity;
import com.vinicius.api_pro.service.EntradaEstoqueService;
import com.vinicius.api_pro.service.FornecedorService;
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
@RequestMapping("/entradaestoque")
@CrossOrigin(origins = "*")
public class EntradaEstoqueController {

    @Autowired
    private EntradaEstoqueService service;
    @Autowired
    private ItemEstoqueService itemEstoqueService;
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List> getAllEntradaEstoque() {
        List<EntradaEstoqueEntity> entrada = service.listarTodasEntradaEstoque();
        return new ResponseEntity<>(entrada, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<EntradaEstoqueEntity> getEntradaEstoqueById(@PathVariable Long id) {
        EntradaEstoqueEntity entrada = service.getEntradaEstoqueId(id);
        return new ResponseEntity<>(entrada, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EntradaEstoqueEntity> addEntradaEstoque(@Valid @RequestBody 
            EntradaEstoqueEntity entrada) {
        
        entrada.setItemEstoque(itemEstoqueService.buscarPorDescricao(entrada.getItemEstoque().getDescricao()));
        entrada.setFornecedor(fornecedorService.buscarPorNome(entrada.getFornecedor().getNome()));        
        var novoFornecedor = service.criarEntradaEstoque(entrada);

        return new ResponseEntity<>(novoFornecedor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EntradaEstoqueEntity> atualizarEntradaEstoque(@PathVariable Long id,
            @RequestBody EntradaEstoqueEntity entrada) {

        EntradaEstoqueEntity entradaExistente = service.getEntradaEstoqueId(id);

        if (entradaExistente != null) {

            entradaExistente.setNome(entrada.getNome());
            entradaExistente.setQuantidade(entrada.getQuantidade());
            entradaExistente.setValor_unitario(entrada.getValor_unitario());
            entradaExistente.setData_entrada(entrada.getData_entrada());
            entradaExistente.setItemEstoque(itemEstoqueService.buscarPorDescricao(entrada.getItemEstoque().getDescricao()));
            entradaExistente.setFornecedor(fornecedorService.buscarPorNome(entrada.getFornecedor().getNome()));

            var entradaAtualizado = service.atualizarEntradaEstoque(id, entradaExistente);
            return new ResponseEntity<>(entradaAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarEntradaEstoque(@PathVariable Long id) {
        service.deletarEntradaEstoque(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
