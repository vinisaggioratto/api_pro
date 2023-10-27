package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.ApartamentoEntity;
import com.vinicius.api_pro.service.ApartamentoService;
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
@RequestMapping("/apartamentos")
@CrossOrigin(origins = "*")
public class ApartamentoController {

    @Autowired
    private ApartamentoService service;

    @GetMapping
    public ResponseEntity<List> getAllApartamentos() {
        List<ApartamentoEntity> apto = service.listarTodosApartamentos();
        return new ResponseEntity<>(apto, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<ApartamentoEntity> getApartamentoById(@PathVariable Long id) {
        ApartamentoEntity apto = service.getApartamentoId(id);
        return new ResponseEntity<>(apto, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ApartamentoEntity> addApartamento(@Valid @RequestBody ApartamentoEntity apto) {
        var novoApto = service.criarApartamento(apto);

        return new ResponseEntity<>(novoApto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ApartamentoEntity> atualizarApartamento(@PathVariable Long id, 
            @RequestBody ApartamentoEntity apto) {

        ApartamentoEntity cidadeExistente = service.getApartamentoId(id);

        if (cidadeExistente != null) {

            cidadeExistente.setNumero(apto.getNumero());
            cidadeExistente.setAndar(apto.getAndar());
            cidadeExistente.setBloco(apto.getBloco());
            cidadeExistente.setStatus(apto.getStatus());

            var apartamentoAtualizada = service.atualizarApartamento(id, cidadeExistente);
            return new ResponseEntity<>(apartamentoAtualizada, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarApartamento(@PathVariable Long id) {
        service.deletarApartamento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
