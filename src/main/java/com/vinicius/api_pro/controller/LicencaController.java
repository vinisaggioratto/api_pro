package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.LicencaEntity;
import com.vinicius.api_pro.service.LicencaService;
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
@RequestMapping("/licencas")
@CrossOrigin(origins = "*")
public class LicencaController {

    @Autowired
    private LicencaService service;

    @GetMapping
    public ResponseEntity<List> getAllLicencas() {
        List<LicencaEntity> licencas = service.listarTodasLicencas();
        return new ResponseEntity<>(licencas, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<LicencaEntity> getLicencaById(@PathVariable Long id) {
        LicencaEntity licenca = service.getLicencaId(id);
        return new ResponseEntity<>(licenca, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LicencaEntity> addLicenca(@Valid @RequestBody LicencaEntity licenca) {
        var novaLicenca = service.criarLicenca(licenca);
        return new ResponseEntity<>(novaLicenca, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<LicencaEntity> atualizarLicenca(@PathVariable Long id, @RequestBody LicencaEntity usuario) {
        var usuarioAtualizado = service.atualizarLicenca(id, usuario);
        return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarLicenca(@PathVariable Long id) {
        service.deletarLicenca(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
