package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.condomino.Condomino;
import com.vinicius.condominiopro.dependentes.Dependente;
import com.vinicius.condominiopro.fornecedor.Fornecedor;
import com.vinicius.condominiopro.repository.SindicoRepository;
import com.vinicius.condominiopro.services.AvisoService;
import com.vinicius.condominiopro.services.CondominoService;
import com.vinicius.condominiopro.services.SindicoService;
import com.vinicius.condominiopro.sindico.Sindico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.aviso.Aviso;
import com.vinicius.condominiopro.repository.AvisoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/avisos")
@CrossOrigin(origins = "*")
public class AvisoController {

    @Autowired
    private AvisoRepository repository;

    @Autowired
    private AvisoService service;

    @Autowired
    private SindicoService sindicoService;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid Aviso dados) {
        service.salvar(dados);
        System.out.println("ID: " + dados.getId());
        System.out.println("NOME: " + dados.getNome());
        System.out.println("DESCRIÇAO: " + dados.getDescricao());
        System.out.println("DATA: " + dados.getData_aviso());
        System.out.println("SINDICO ID:" + dados.getSindico().getNome());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> atualizar(@Valid @RequestBody Aviso dados, @PathVariable Long id) {

        System.out.println("ID: " + dados.getId());
        System.out.println("NOME: " + dados.getNome());
        System.out.println("DESCRIÇAO: " + dados.getDescricao());
        System.out.println("DATA: " + dados.getData_aviso());
        System.out.println("Nome condômino: " + dados.getSindico());
        System.out.println("SINDICO ID:" + dados.getSindico().getNome());

        Optional<Aviso> avisoExistente = repository.findById(id);
        if (avisoExistente.isPresent()) {
            Aviso aviso = avisoExistente.get();

            aviso.setNome(dados.getNome());
            aviso.setDescricao(dados.getDescricao());
            aviso.setData_aviso(dados.getData_aviso());
            aviso.setSindico(sindicoService.buscarPorNome(dados.getSindico().getNome()));
            service.salvar(aviso);
            return ResponseEntity.ok("Aviso atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Aviso> listar() {
        return repository.findAll().stream().toList();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
