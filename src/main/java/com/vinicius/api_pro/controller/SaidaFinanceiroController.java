package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.SaidaFinanceiroEntity;
import com.vinicius.api_pro.service.FornecedorService;
import com.vinicius.api_pro.service.SaidaFinanceiroService;
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
@RequestMapping("/saidasfinanceiro")
@CrossOrigin(origins = "*")
public class SaidaFinanceiroController {

    @Autowired
    private SaidaFinanceiroService service;
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List> getAllSaidaFinanceiro() {
        List<SaidaFinanceiroEntity> saida = service.listarTodasSaidaFinanceiro();
        return new ResponseEntity<>(saida, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<SaidaFinanceiroEntity> getSaidaFinanceiroById(@PathVariable Long id) {
        SaidaFinanceiroEntity saida = service.getSaidaFinanceiroId(id);
        return new ResponseEntity<>(saida, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<SaidaFinanceiroEntity> addSaidaFinanceiro(@Valid @RequestBody SaidaFinanceiroEntity saida) {

        saida.setFornecedor(fornecedorService.buscarPorNome(saida.getFornecedor().getNome()));
        var novaSaida = service.criarSaidaFinanceiro(saida);
        return new ResponseEntity<>(novaSaida, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<SaidaFinanceiroEntity> atualizarSaidaFinanceiro(@PathVariable Long id,
            @RequestBody SaidaFinanceiroEntity saida) {

        SaidaFinanceiroEntity saidaFinanceiroExistente = service.getSaidaFinanceiroId(id);

        if (saidaFinanceiroExistente != null) {

            saidaFinanceiroExistente.setFornecedor(fornecedorService.buscarPorNome(saida.getFornecedor().getNome()));
            saidaFinanceiroExistente.setDescricao(saida.getDescricao());
            saidaFinanceiroExistente.setData_operacao(saida.getData_operacao());
            saidaFinanceiroExistente.setValor(saida.getValor());
            saidaFinanceiroExistente.setValor(saida.getNota_fiscal());
            saidaFinanceiroExistente.setParcelamento(saida.getParcelamento());

            var saidaFinanceiroAtualizado = service.atualizarSaidaFinanceiro(id, saidaFinanceiroExistente);
            return new ResponseEntity<>(saidaFinanceiroAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarSaidaFinanceiro(@PathVariable Long id) {
        service.deletarSaidaFinanceiro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
