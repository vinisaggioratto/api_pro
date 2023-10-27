package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.EstadoEntity;
import com.vinicius.api_pro.service.EstadoService;
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
@RequestMapping("/estados")
@CrossOrigin(origins = "*")
public class EstadoController {

    @Autowired
    private EstadoService service;
    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List> getAllEstados() {
        List<EstadoEntity> estados = service.listarTodosEstados();
        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<EstadoEntity> getEstadoById(@PathVariable Long id) {
        EstadoEntity estados = service.getEstadoId(id);
        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<EstadoEntity> addEstado(@Valid @RequestBody EstadoEntity estados) {
        var novoEstado = service.criarEstado(estados);
        return new ResponseEntity<>(novoEstado, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EstadoEntity> atualizarEstado(@PathVariable Long id, @RequestBody EstadoEntity usuario) {
        var estadoAtualizado = service.atualizarEstado(id, usuario);
        return new ResponseEntity<>(estadoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarEstado(@PathVariable Long id) {
        service.deletarEstado(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
