package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.OcorrenciaEntity;
import com.vinicius.api_pro.data.OcorrenciaRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository repository;
    @Autowired
    private SindicoService sindicoService;
    @Autowired
    private CondominoService condominoService;

    
    public OcorrenciaEntity getOcorrenciaId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Ocorrência não encontrado." + id));
    }

    public List<OcorrenciaEntity> listarTodasOcorrencias() {
        return repository.findAll().stream().toList();
    }

    public OcorrenciaEntity buscarPorNome(String nome) {
        OcorrenciaEntity ocorrencia = repository.findByNome(nome);
        return ocorrencia;
    }

    public OcorrenciaEntity criarOcorrencia(OcorrenciaEntity ocorrencia) {
        ocorrencia.setId(null);

        ocorrencia.setNome(ocorrencia.getNome());
        ocorrencia.setDescricao(ocorrencia.getDescricao());
        ocorrencia.setData_ocorrencia(ocorrencia.getData_ocorrencia());
        ocorrencia.setSindico(sindicoService.buscarPorNome(ocorrencia.getSindico().getNome()));
        ocorrencia.setCondomino(condominoService.buscarPorNome(ocorrencia.getCondomino().getNome()));
        repository.save(ocorrencia);
        return ocorrencia;
    }

    public OcorrenciaEntity atualizarOcorrencia(Long id, OcorrenciaEntity ocorrencia) {

        OcorrenciaEntity ocor = getOcorrenciaId(id);

        ocor.setNome(ocorrencia.getNome());
        ocor.setDescricao(ocorrencia.getDescricao());
        ocor.setData_ocorrencia(ocorrencia.getData_ocorrencia());
        ocor.setSindico(sindicoService.buscarPorNome(ocorrencia.getSindico().getNome()));
        ocor.setCondomino(condominoService.buscarPorNome(ocorrencia.getCondomino().getNome()));
        repository.save(ocor);
        return ocor;
    }

    public void deletarOcorrencia(Long id) {
        OcorrenciaEntity ocorrencia = getOcorrenciaId(id);
        repository.deleteById(ocorrencia.getId());
    }
}
