package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.VeiculoEntity;
import com.vinicius.api_pro.service.CondominoService;
import com.vinicius.api_pro.service.VeiculoService;
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
@RequestMapping("/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController {

    @Autowired
    private VeiculoService service;
    @Autowired
    private CondominoService condominoService;

    @GetMapping
    public ResponseEntity<List> getAllVeiculos() {
        List<VeiculoEntity> veiculos = service.listarTodosVeiculos();
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<VeiculoEntity> getVeiculoById(@PathVariable Long id) {
        VeiculoEntity veiculos = service.getVeiculoId(id);
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<VeiculoEntity> addVeiculo(@Valid @RequestBody VeiculoEntity veiculos) {
        
        veiculos.setCondomino(condominoService.buscarPorNome(veiculos.getCondomino().getNome()));
        var novoVeiculo = service.criarVeiculo(veiculos);

        return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<VeiculoEntity> atualizarVeiculo(@PathVariable Long id,
            @RequestBody VeiculoEntity veiculos) {

        VeiculoEntity veiculoExistente = service.getVeiculoId(id);

        if (veiculoExistente != null) {

            veiculoExistente.setPlaca(veiculos.getPlaca());
            veiculoExistente.setMarca(veiculos.getMarca());
            veiculoExistente.setCor(veiculos.getCor());
            veiculoExistente.setAtivo(veiculos.getAtivo());
            veiculoExistente.setModelo(veiculos.getModelo());
            veiculoExistente.setCondomino(condominoService.buscarPorNome(veiculos.getCondomino().getNome()));

            var veiculoAtualizado = service.atualizarVeiculo(id, veiculoExistente);
            return new ResponseEntity<>(veiculoAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarVeiculo(@PathVariable Long id) {
        service.deletarVeiculo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
