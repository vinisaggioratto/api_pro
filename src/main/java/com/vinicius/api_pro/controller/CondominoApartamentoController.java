package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.CondominoApartamentoEntity;
import com.vinicius.api_pro.service.ApartamentoService;
import com.vinicius.api_pro.service.CondominoApartamentoService;
import com.vinicius.api_pro.service.CondominoService;
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
@RequestMapping("/vincular")
@CrossOrigin(origins = "*")
public class CondominoApartamentoController {

    @Autowired
    private CondominoApartamentoService service;
    @Autowired
    private CondominoService condominoService;
    @Autowired
    private ApartamentoService apartamentoService;

    @GetMapping
    public ResponseEntity<List> getAllCondominoApartamento() {
        List<CondominoApartamentoEntity> condapto = service.listarTodosCondominoApartamento();
        return new ResponseEntity<>(condapto, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<CondominoApartamentoEntity> getCondominoApartamentoById(@PathVariable Long id) {
        CondominoApartamentoEntity condapto = service.getCondominoApartamentoId(id);
        return new ResponseEntity<>(condapto, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CondominoApartamentoEntity> addCondominoApartamento(@Valid
            @RequestBody CondominoApartamentoEntity condapto) {
        
        condapto.setCondomino(condominoService.buscarPorNome(condapto.getCondomino().getNome()));
        condapto.setApartamento(apartamentoService.buscarPorNumero(condapto.getApartamento().getNumero()));        
        var novoCondominoApartamento = service.criarCondominoApartamento(condapto);

        return new ResponseEntity<>(novoCondominoApartamento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CondominoApartamentoEntity> atualizarCondominoApartamento(@PathVariable Long id,
            @RequestBody CondominoApartamentoEntity condapto) {

        CondominoApartamentoEntity condaptoExistente = service.getCondominoApartamentoId(id);

        if (condaptoExistente != null) {

            condaptoExistente.setCondomino(condominoService.buscarPorNome(condapto.getCondomino().getNome()));
            condaptoExistente.setApartamento(apartamentoService.buscarPorNumero(condapto.getApartamento().getNumero()));
            condaptoExistente.setData_entrada(condapto.getData_entrada());
            condaptoExistente.setData_saida(condapto.getData_saida());

            var condaptoAtualizado = service.atualizarCondominoApartamento(id, condaptoExistente);
            return new ResponseEntity<>(condapto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarCondominoApartamento(@PathVariable Long id) {
        service.deletarCondominoApartamento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
