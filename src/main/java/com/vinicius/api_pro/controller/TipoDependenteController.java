package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.FornecedorEntity;
import com.vinicius.api_pro.data.TipoDependenteEntity;
import com.vinicius.api_pro.service.TipoDependenteService;
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
@RequestMapping("/tipodependentes")
@CrossOrigin(origins = "*")
public class TipoDependenteController {

    @Autowired
    private TipoDependenteService service;

    @GetMapping
    public ResponseEntity<List> getAllTipoDependentes() {
        List<TipoDependenteEntity> tipoDep = service.listarTodosTipoDependentes();
        return new ResponseEntity<>(tipoDep, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<TipoDependenteEntity> getTipoDependenteById(@PathVariable Long id) {
        TipoDependenteEntity tipoDep = service.getTipoDependenteId(id);
        return new ResponseEntity<>(tipoDep, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TipoDependenteEntity> addTipoDependente(@Valid @RequestBody TipoDependenteEntity tipoDep) {
        var novoTipoDependente = service.criarTipoDependente(tipoDep);

        return new ResponseEntity<>(novoTipoDependente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TipoDependenteEntity> atualizarTipoDependente(@PathVariable Long id,
            @RequestBody TipoDependenteEntity tipoDep) {

        TipoDependenteEntity tipoDependenteExistente = service.getTipoDependenteId(id);

        if (tipoDependenteExistente != null) {

            tipoDependenteExistente.setDescricao(tipoDep.getDescricao());

            var tipoDependenteAtualizado = service.atualizarTipoDependente(id, tipoDependenteExistente);
            return new ResponseEntity<>(tipoDependenteAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTipoDependente(@PathVariable Long id) {
        service.deletarTipoDependente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
