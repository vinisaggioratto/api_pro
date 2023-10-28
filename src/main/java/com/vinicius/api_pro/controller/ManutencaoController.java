package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.ManutencaoEntity;
import com.vinicius.api_pro.service.FornecedorService;
import com.vinicius.api_pro.service.ManutencaoService;
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
@RequestMapping("/manutencoes")
@CrossOrigin(origins = "*")
public class ManutencaoController {

    @Autowired
    private ManutencaoService service;
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List> getAllManutencao() {
        List<ManutencaoEntity> manutencao = service.listarTodasManutencao();
        return new ResponseEntity<>(manutencao, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<ManutencaoEntity> getManutencaoById(@PathVariable Long id) {
        ManutencaoEntity manutencao = service.getManutencaoId(id);
        return new ResponseEntity<>(manutencao, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ManutencaoEntity> addManutencao(@Valid @RequestBody ManutencaoEntity manutencao) {

        manutencao.setFornecedor(fornecedorService.buscarPorNome(manutencao.getFornecedor().getNome()));
        
        var novaManutencao = service.criarManutencao(manutencao);
        return new ResponseEntity<>(novaManutencao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ManutencaoEntity> atualizarManutencao(@PathVariable Long id,
            @RequestBody ManutencaoEntity manutencao) {

        ManutencaoEntity manutencaoExistente = service.getManutencaoId(id);

        if (manutencaoExistente != null) {

            manutencaoExistente.setNome(manutencao.getNome());
            manutencaoExistente.setDescricao(manutencao.getDescricao());
            manutencaoExistente.setValor(manutencao.getValor());
            manutencaoExistente.setData_inicial(manutencao.getData_inicial());
            manutencaoExistente.setData_final(manutencao.getData_final());
            manutencaoExistente.setFornecedor(fornecedorService.buscarPorNome(manutencao.getFornecedor().getNome()));

            var manutencaoAtualizado = service.atualizarManutencao(id, manutencaoExistente);
            return new ResponseEntity<>(manutencaoAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarManutencao(@PathVariable Long id) {
        service.deletarManutencao(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
