package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.PaisEntity;
import com.vinicius.api_pro.service.PaisService;
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
@RequestMapping("/pais")
@CrossOrigin(origins = "*")
public class PaisController {

    @Autowired
    private PaisService service;

    @GetMapping
    public ResponseEntity<List> getAllPais() {
        List<PaisEntity> pais = service.listarTodosPaises();
        return new ResponseEntity<>(pais, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<PaisEntity> getPaisById(@PathVariable Long id) {
        PaisEntity pais = service.getPaisId(id);
        return new ResponseEntity<>(pais, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PaisEntity> addPais(@Valid @RequestBody PaisEntity pais) {
        var novoPais = service.criarPais(pais);
        return new ResponseEntity<>(novoPais, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PaisEntity> atualizarPais(@PathVariable Long id, @RequestBody PaisEntity pais) {
        var paisAtualizado = service.atualizarPais(id, pais);
        return new ResponseEntity<>(paisAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPais(@PathVariable Long id) {
        service.deletarPais(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
