package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.FornecedorEntity;
import com.vinicius.api_pro.service.CidadeService;
import com.vinicius.api_pro.service.EstadoService;
import com.vinicius.api_pro.service.FornecedorService;
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
@RequestMapping("/fornecedores")
@CrossOrigin(origins = "*")
public class FornecedorController {

    @Autowired
    private FornecedorService service;
    @Autowired
    private CidadeService cidadeService;
    @Autowired
    private EstadoService estadoService;
    
    @GetMapping
    public ResponseEntity<List> getAllFornecedores() {
        List<FornecedorEntity> fornecedor = service.listarTodosFornecedores();
        return new ResponseEntity<>(fornecedor, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<FornecedorEntity> getFornecedorById(@PathVariable Long id) {
        FornecedorEntity fornecedor = service.getFornecedorId(id);
        return new ResponseEntity<>(fornecedor, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FornecedorEntity> addFornecedor(@Valid @RequestBody FornecedorEntity fornecedor) {
        var novoFornecedor = service.criarFornecedor(fornecedor);

        return new ResponseEntity<>(novoFornecedor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FornecedorEntity> atualizarFornecedor(@PathVariable Long id, 
            @RequestBody FornecedorEntity fornecedor) {

        FornecedorEntity fornecedorExistente = service.getFornecedorId(id);

        if (fornecedorExistente != null) {

            fornecedorExistente.setBairro(fornecedor.getBairro());
            fornecedorExistente.setCidade(cidadeService.buscarPorNome(fornecedor.getCidade().getNome()));
            fornecedorExistente.setCpf_cnpj(fornecedor.getCpf_cnpj());
            fornecedorExistente.setEspecialidade(fornecedor.getEspecialidade());
            fornecedorExistente.setEstado(estadoService.buscarPorNome(fornecedor.getEstado().getNome()));
            fornecedorExistente.setNome(fornecedor.getNome());
            fornecedorExistente.setNumero(fornecedor.getNumero());
            fornecedorExistente.setRua(fornecedor.getRua());
            fornecedorExistente.setTelefone_celular(fornecedor.getTelefone_celular());

            var fornecedorAtualizado = service.atualizarFornecedor(id, fornecedorExistente);
            return new ResponseEntity<>(fornecedorAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarFornecedor(@PathVariable Long id) {
        service.deletarFornecedor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
