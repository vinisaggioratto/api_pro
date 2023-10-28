package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.CondominoEntity;
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
@RequestMapping("/condomino")
@CrossOrigin(origins = "*")
public class CondominoController {

    @Autowired
    private CondominoService service;

    @GetMapping
    public ResponseEntity<List> getAllCondominos() {
        List<CondominoEntity> condomino = service.listarTodosCondominos();
        return new ResponseEntity<>(condomino, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<CondominoEntity> getCondominoById(@PathVariable Long id) {
        CondominoEntity condomino = service.getCondominoId(id);
        return new ResponseEntity<>(condomino, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CondominoEntity> addCondomino(@Valid @RequestBody CondominoEntity avisos) {
        var novoCondomino = service.criarCondomino(avisos);

        return new ResponseEntity<>(novoCondomino, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CondominoEntity> atualizarCondomino(@PathVariable Long id,
            @RequestBody CondominoEntity condomino) {

        CondominoEntity condominoExistente = service.getCondominoId(id);

        if (condominoExistente != null) {

            condominoExistente.setNome(condomino.getNome());
            condominoExistente.setRg(condomino.getRg());
            condominoExistente.setTelefone_celular(condomino.getTelefone_celular());
            condominoExistente.setProprietario(condomino.getProprietario());
            condominoExistente.setMorador(condomino.getMorador());

            var condominoAtualizado = service.atualizarCondomino(id, condominoExistente);
            return new ResponseEntity<>(condominoAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarCondomino(@PathVariable Long id) {
        service.deletarCondomino(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
