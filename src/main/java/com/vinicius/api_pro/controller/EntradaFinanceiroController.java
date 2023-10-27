package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.EntradaFinanceiroEntity;
import com.vinicius.api_pro.service.CondominoService;
import com.vinicius.api_pro.service.EntradaFinanceiroService;
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
@RequestMapping("/entradafinanceiro")
@CrossOrigin(origins = "*")
public class EntradaFinanceiroController {

    @Autowired
    private EntradaFinanceiroService service;
    @Autowired
    private CondominoService condominoService;

    @GetMapping
    public ResponseEntity<List> getAllEntradaFinanceiro() {
        List<EntradaFinanceiroEntity> entrada = service.listarTodasEntradaFinanceiro();
        return new ResponseEntity<>(entrada, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<EntradaFinanceiroEntity> getEntradaFinanceiroById(@PathVariable Long id) {
        EntradaFinanceiroEntity entrada = service.getEntradaFinanceiroId(id);
        return new ResponseEntity<>(entrada, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EntradaFinanceiroEntity> addEntradaFinanceiro(@Valid @RequestBody EntradaFinanceiroEntity entrada) {

        entrada.setCondomino(condominoService.buscarPorNome(entrada.getCondomino().getNome()));
        var novaEntrada = service.criarEntradaFinanceiro(entrada);
        return new ResponseEntity<>(novaEntrada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EntradaFinanceiroEntity> atualizarEntradaFinanceiro(@PathVariable Long id,
            @RequestBody EntradaFinanceiroEntity entrada) {

        EntradaFinanceiroEntity entradaExistente = service.getEntradaFinanceiroId(id);

        if (entradaExistente != null) {

            entradaExistente.setData_operacao(entrada.getData_operacao());
            entradaExistente.setCondomino(condominoService.buscarPorNome(entrada.getCondomino().getNome()));
            entradaExistente.setValor(entrada.getValor());
            entradaExistente.setParcelamento(entrada.getParcelamento());
            entradaExistente.setDescricao(entrada.getDescricao());

            var entradaAtualizado = service.atualizarEntradaFinanceiro(id, entradaExistente);
            return new ResponseEntity<>(entradaAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarEntradaFinanceiro(@PathVariable Long id) {
        service.deletarEntradaFinanceiro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
