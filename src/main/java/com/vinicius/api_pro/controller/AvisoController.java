package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.AvisoEntity;
import com.vinicius.api_pro.service.AvisoService;
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
@RequestMapping("/avisos")
@CrossOrigin(origins = "*")
public class AvisoController {

    @Autowired
    private AvisoService service;
    @Autowired
    private SindicoService sindicoService;
    
    
    @GetMapping
    public ResponseEntity<List> getAllAvisos() {
        List<AvisoEntity> avisos = service.listarTodosAvisos();
        return new ResponseEntity<>(avisos, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<AvisoEntity> getAvisoById(@PathVariable Long id) {
        AvisoEntity avisos = service.getAvisoId(id);
        return new ResponseEntity<>(avisos, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AvisoEntity> addAviso(@Valid @RequestBody AvisoEntity avisos) {
        var novoAviso = service.criarAviso(avisos);

        return new ResponseEntity<>(novoAviso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AvisoEntity> atualizarAviso(@PathVariable Long id, @RequestBody AvisoEntity avisos) {

        AvisoEntity avisoExistente = service.getAvisoId(id);

        if (avisoExistente != null) {
            
            avisoExistente.setNome(avisos.getNome());
            avisoExistente.setDescricao(avisos.getDescricao());
            avisoExistente.setData_aviso(avisos.getData_aviso());
            avisoExistente.setSindico(sindicoService.buscarPorNome(avisos.getSindico().getNome()));
            
            var avisoAtualizado = service.atualizarAviso(id, avisoExistente);
            return new ResponseEntity<>(avisoAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarAviso(@PathVariable Long id) {
        service.deletarAviso(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }    
}
