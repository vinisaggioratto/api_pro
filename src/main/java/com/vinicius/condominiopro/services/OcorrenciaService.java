package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.ocorrencia.Ocorrencia;
import com.vinicius.condominiopro.pais.Pais;
import com.vinicius.condominiopro.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository repository;

    @Autowired
    private SindicoService sindicoService;
    @Autowired
    private CondominoService condominoService;

    public List<Ocorrencia> listar() {
        return repository.findAll().stream().toList();
    }

    public void salvar(Ocorrencia ocorrencia){
        ocorrencia.setNome(ocorrencia.getNome());
        ocorrencia.setDescricao(ocorrencia.getDescricao());
        ocorrencia.setData_ocorrencia(ocorrencia.getData_ocorrencia());
        ocorrencia.setSindico(sindicoService.buscarPorNome(ocorrencia.getSindico().getNome()));
        ocorrencia.setCondomino(condominoService.retornarIdCondomino(ocorrencia.getCondomino().getNome()));
        repository.save(ocorrencia);
    }

    public Ocorrencia buscarPorId(Long id){

        return repository.findById(id).orElse(null);
    }
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
