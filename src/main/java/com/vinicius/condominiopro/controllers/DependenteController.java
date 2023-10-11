package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.services.CondominoService;
import com.vinicius.condominiopro.services.DependenteService;
import com.vinicius.condominiopro.services.TipoDependenteService;
import com.vinicius.condominiopro.sindico.Sindico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.dependentes.Dependente;
import com.vinicius.condominiopro.repository.DependenteRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/dependentes")
@CrossOrigin(origins = "*")
public class DependenteController {

    @Autowired
    private DependenteService service;
    @Autowired
    private DependenteRepository repository;
    @Autowired
    private CondominoService condominoService;
    @Autowired
    private TipoDependenteService tipoDependenteService;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid Dependente dados) {

        dados.setCondomino(condominoService.retornarIdCondomino(dados.getCondomino().getNome()));
        dados.setTipoDependente(tipoDependenteService.retornarIdTipoDependente(dados.getTipoDependente().getDescricao()));
        service.salvar(dados);
    }

    @GetMapping
    public List<Dependente> list() {
        return repository.findAll().stream().toList();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> atualizar(@Valid @RequestBody Dependente dados, @PathVariable Long id) {

        Optional<Dependente> dependenteExistente = repository.findById(id);
        if (dependenteExistente.isPresent()) {
            Dependente dependente = dependenteExistente.get();
            dependente.setNome(dados.getNome());
            dependente.setTelefone_celular(dados.getTelefone_celular());
            dependente.setMorador(dados.getMorador());
            dados.setCondomino(condominoService.retornarIdCondomino(dados.getCondomino().getNome()));
            dados.setTipoDependente(tipoDependenteService.retornarIdTipoDependente(dados.getTipoDependente().getDescricao()));
            service.salvar(dados);
            return ResponseEntity.ok("Dependente atualizado com sucesso!");
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
