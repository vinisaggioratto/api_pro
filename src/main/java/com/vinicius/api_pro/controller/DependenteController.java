package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.DependenteEntity;
import com.vinicius.api_pro.service.CondominoService;
import com.vinicius.api_pro.service.DependenteService;
import com.vinicius.api_pro.service.TipoDependenteService;
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
@RequestMapping("/dependentes")
@CrossOrigin(origins = "*")
public class DependenteController {

    @Autowired
    private DependenteService service;
    @Autowired
    private CondominoService condominoService;
    @Autowired
    private TipoDependenteService tipoDependenteService;

    @GetMapping
    public ResponseEntity<List> getAllDependente() {
        List<DependenteEntity> dependente = service.listarTodosDependentes();
        return new ResponseEntity<>(dependente, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<DependenteEntity> getDependenteById(@PathVariable Long id) {
        DependenteEntity dependente = service.getDependenteId(id);
        return new ResponseEntity<>(dependente, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DependenteEntity> addDependente(@Valid @RequestBody DependenteEntity dependente) {

        dependente.setCondomino(condominoService.buscarPorNome(dependente.getCondomino().getNome()));
        dependente.setTipoDependente(tipoDependenteService.buscarPorNome(dependente.getTipoDependente().getDescricao()));
        var novoDependente = service.criarDependente(dependente);
        return new ResponseEntity<>(novoDependente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DependenteEntity> atualizarDependente(@PathVariable Long id,
            @RequestBody DependenteEntity dependente) {

        DependenteEntity dependenteExistente = service.getDependenteId(id);

        if (dependenteExistente != null) {

            dependenteExistente.setNome(dependente.getNome());
            dependenteExistente.setRg(dependente.getRg());
            dependenteExistente.setTelefone_celular(dependente.getTelefone_celular());
            dependenteExistente.setMorador(dependente.getMorador());
            dependenteExistente.setCondomino(condominoService.buscarPorNome(dependente.getCondomino().getNome()));
            dependenteExistente.setTipoDependente(tipoDependenteService.buscarPorNome(dependente.getTipoDependente().getDescricao()));

            var dependenteAtualizado = service.atualizarDependente(id, dependenteExistente);
            return new ResponseEntity<>(dependenteAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarDependente(@PathVariable Long id) {
        service.deletarDependente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
