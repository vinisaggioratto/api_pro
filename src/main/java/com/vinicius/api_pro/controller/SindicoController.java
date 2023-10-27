package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.SindicoEntity;
import com.vinicius.api_pro.service.CondominoService;
import com.vinicius.api_pro.service.SindicoService;
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
@RequestMapping("/sindico")
@CrossOrigin(origins = "*")
public class SindicoController {

    @Autowired
    private SindicoService service;
    @Autowired
    private CondominoService condominoService;

    @GetMapping
    public ResponseEntity<List> getAllSindicos() {
        List<SindicoEntity> sindicos = service.listarTodosSindicos();
        return new ResponseEntity<>(sindicos, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<SindicoEntity> getSindicoById(@PathVariable Long id) {
        SindicoEntity sindico = service.getSindicoId(id);
        return new ResponseEntity<>(sindico, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<SindicoEntity> addSindico(@Valid @RequestBody SindicoEntity sindico) {
        var novoSindico = service.criarSindico(sindico);

        return new ResponseEntity<>(novoSindico, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<SindicoEntity> atualizarSindico(@PathVariable Long id, @RequestBody SindicoEntity sindico) {

        SindicoEntity sindicoExistente = service.getSindicoId(id);

        if (sindicoExistente != null) {

            sindicoExistente.setData_inicial(sindico.getData_inicial());
            sindicoExistente.setData_final_prevista(sindico.getData_final_prevista());
            sindicoExistente.setData_final(sindico.getData_final());
            sindicoExistente.setNome(sindico.getNome());
            sindicoExistente.setAtivo(sindico.getAtivo());

            var avisoAtualizado = service.atualizarSindico(id, sindicoExistente);
            return new ResponseEntity<>(avisoAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarSindico(@PathVariable Long id) {
        service.deletarSindico(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
