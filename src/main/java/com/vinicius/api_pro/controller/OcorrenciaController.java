package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.OcorrenciaEntity;
import com.vinicius.api_pro.service.CondominoService;
import com.vinicius.api_pro.service.OcorrenciaService;
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
@RequestMapping("/ocorrencias")
@CrossOrigin(origins = "*")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService service;
    @Autowired
    private SindicoService sindicoService;
    @Autowired
    private CondominoService condominoService;

    @GetMapping
    public ResponseEntity<List> getAllOcorrencia() {
        List<OcorrenciaEntity> ocorrencia = service.listarTodasOcorrencias();
        return new ResponseEntity<>(ocorrencia, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<OcorrenciaEntity> getOcorrenciaById(@PathVariable Long id) {
        OcorrenciaEntity ocorrencia = service.getOcorrenciaId(id);
        return new ResponseEntity<>(ocorrencia, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<OcorrenciaEntity> addOcorrencia(@Valid @RequestBody OcorrenciaEntity ocorrencia) {

        ocorrencia.setSindico(sindicoService.buscarPorNome(ocorrencia.getSindico().getNome()));
        ocorrencia.setCondomino(condominoService.buscarPorNome(ocorrencia.getCondomino().getNome()));
        var novaOcorrencia = service.criarOcorrencia(ocorrencia);
        return new ResponseEntity<>(novaOcorrencia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<OcorrenciaEntity> atualizarOcorrencia(@PathVariable Long id,
            @RequestBody OcorrenciaEntity ocorrencia) {

        OcorrenciaEntity ocorrenciaExistente = service.getOcorrenciaId(id);

        if (ocorrenciaExistente != null) {

            ocorrenciaExistente.setNome(ocorrencia.getNome());
            ocorrenciaExistente.setDescricao(ocorrencia.getDescricao());
            ocorrenciaExistente.setData_ocorrencia(ocorrencia.getData_ocorrencia());
            ocorrenciaExistente.setSindico(sindicoService.buscarPorNome(ocorrencia.getSindico().getNome()));
            ocorrenciaExistente.setCondomino(condominoService.buscarPorNome(ocorrencia.getCondomino().getNome()));

            var ocorrenciaAtualizado = service.atualizarOcorrencia(id, ocorrenciaExistente);
            return new ResponseEntity<>(ocorrenciaAtualizado, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarOcorrencia(@PathVariable Long id) {
        service.deletarOcorrencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
