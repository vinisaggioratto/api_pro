package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.cidade.Cidade;
import com.vinicius.condominiopro.services.CidadeService;
import com.vinicius.condominiopro.services.EstadoService;
import com.vinicius.condominiopro.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.fornecedor.Fornecedor;
import com.vinicius.condominiopro.repository.FornecedorRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedores")
@CrossOrigin(origins = "*")
public class FornecedorController {

    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private FornecedorService service;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid Fornecedor dados) {
        service.salvar(dados);
    }

    @GetMapping
    public List<Fornecedor> listar() {
        List<Fornecedor> fornecedor = service.listar();
        return fornecedor;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> atualizar(@Valid @RequestBody Fornecedor dados, @PathVariable Long id) {

        Optional<Fornecedor> fornecedorExistente = repository.findById(id);
        if (fornecedorExistente.isPresent()) {
            Fornecedor fornecedor = fornecedorExistente.get();

            fornecedor.setBairro(dados.getBairro());
            fornecedor.setCidade(cidadeService.retornarIdCidade(dados.getCidade().getNome()));
            fornecedor.setCpf_cnpj(dados.getCpf_cnpj());
            fornecedor.setEspecialidade(dados.getEspecialidade());
            fornecedor.setEstado(estadoService.retornarIdEstado(dados.getEstado().getNome()));
            fornecedor.setNome(dados.getNome());
            fornecedor.setNumero(dados.getNumero());
            fornecedor.setRua(dados.getRua());
            fornecedor.setTelefone_celular(dados.getTelefone_celular());

            service.salvar(fornecedor);
            return ResponseEntity.ok("Fornecedor atualizado com sucesso!");
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
