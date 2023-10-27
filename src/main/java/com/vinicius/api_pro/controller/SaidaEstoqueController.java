package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.SaidaEstoqueEntity;
import com.vinicius.api_pro.service.ItemEstoqueService;
import com.vinicius.api_pro.service.SaidaEstoqueService;
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
@RequestMapping("/saidasestoque")
@CrossOrigin(origins = "*")
public class SaidaEstoqueController {

    @Autowired
    private SaidaEstoqueService service;
    @Autowired
    private ItemEstoqueService itemEstoqueService;

    @GetMapping
    public ResponseEntity<List> getAllSaidaEstoque() {
        List<SaidaEstoqueEntity> saida = service.listarTodasSaidaEstoque();
        return new ResponseEntity<>(saida, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<SaidaEstoqueEntity> getSaidaEstoqueById(@PathVariable Long id) {
        SaidaEstoqueEntity saida = service.getSaidaEstoqueId(id);
        return new ResponseEntity<>(saida, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<SaidaEstoqueEntity> addSaidaEstoque(@Valid @RequestBody SaidaEstoqueEntity saida) {
        
        saida.setItemEstoque(itemEstoqueService.buscarPorDescricao(saida.getItemEstoque().getDescricao()));
        var novaSaida = service.criarSaidaEstoque(saida);
        return new ResponseEntity<>(novaSaida, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<SaidaEstoqueEntity> atualizarSaidaEstoque(@PathVariable Long id,
            @RequestBody SaidaEstoqueEntity saida) {

        SaidaEstoqueEntity saidaEstoqueExistente = service.getSaidaEstoqueId(id);

        if (saidaEstoqueExistente != null) {

            saidaEstoqueExistente.setItemEstoque(itemEstoqueService.buscarPorDescricao(saida.getItemEstoque().
                    getDescricao()));
            saidaEstoqueExistente.setQuantidade(saida.getQuantidade());
            saidaEstoqueExistente.setData_saida(saida.getData_saida());

            var saidaAtualizado = service.atualizarSaidaEstoque(id, saidaEstoqueExistente);
            return new ResponseEntity<>(saidaAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarSaidaEstoque(@PathVariable Long id) {
        service.deletarSaidaEstoque(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
