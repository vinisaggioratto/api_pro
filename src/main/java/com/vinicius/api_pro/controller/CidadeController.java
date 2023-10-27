package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.CidadeEntity;
import com.vinicius.api_pro.data.UsuarioEntity;
import com.vinicius.api_pro.service.CidadeService;
import com.vinicius.api_pro.service.EstadoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/cidades")
@CrossOrigin(origins = "*")
public class CidadeController {

    @Autowired
    private CidadeService service;
    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List> getAllCidades() {
        List<CidadeEntity> cidades = service.listarTodasCidades();
        return new ResponseEntity<>(cidades, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<CidadeEntity> getCidadeById(@PathVariable Long id) {
        CidadeEntity cidades = service.getCidadeId(id);
        return new ResponseEntity<>(cidades, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CidadeEntity> addCidade(@Valid @RequestBody CidadeEntity cidade) {
        var novaCidade = service.criarCidade(cidade);

        return new ResponseEntity<>(novaCidade, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CidadeEntity> atualizarCidade(@PathVariable Long id, @RequestBody CidadeEntity cidade) {

        CidadeEntity cidadeExistente = service.getCidadeId(id);

        if (cidadeExistente != null) {
            CidadeEntity cid = new CidadeEntity();
            cid.setNome(cidade.getNome());
            cid.setEstado(estadoService.buscarPorNome(cidade.getEstado().getNome()));

            var cidadeAtualizada = service.atualizarCidade(id, cidade);
            return new ResponseEntity<>(cidadeAtualizada, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarCidade(@PathVariable Long id) {
        service.deletarCidade(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
