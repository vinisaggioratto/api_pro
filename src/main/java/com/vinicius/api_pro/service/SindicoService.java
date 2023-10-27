package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.SindicoEntity;
import com.vinicius.api_pro.data.SindicoRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class SindicoService {

    @Autowired
    private SindicoRepository repository;

    public SindicoEntity getSindicoId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Síndico não encontrado." + id));
    }

    public List<SindicoEntity> listarTodosSindicos() {
        return repository.findAll().stream().toList();
    }

    public SindicoEntity buscarPorNome(String nome) {
        SindicoEntity sindico = repository.findByNome(nome);
        return sindico;
    }

    public SindicoEntity criarSindico(SindicoEntity sindico) {
        sindico.setId(null);

        sindico.setData_inicial(sindico.getData_inicial());
        sindico.setData_final_prevista(sindico.getData_final_prevista());
        sindico.setData_final(sindico.getData_final());
        sindico.setNome(sindico.getNome());
        sindico.setAtivo(sindico.getAtivo());
        repository.save(sindico);
        return sindico;
    }

    public SindicoEntity atualizarSindico(Long id, SindicoEntity sindico) {

        SindicoEntity sind = getSindicoId(id);

        sind.setData_inicial(sindico.getData_inicial());
        sind.setData_final_prevista(sindico.getData_final_prevista());
        sind.setData_final(sindico.getData_final());
        sind.setNome(sindico.getNome());
        sind.setAtivo(sindico.getAtivo());
        repository.save(sind);
        return sind;
    }

    public void deletarSindico(Long id) {
        SindicoEntity sindico = getSindicoId(id);
        repository.deleteById(sindico.getId());
    }
}
