package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.PaisEntity;
import com.vinicius.api_pro.data.PaisRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {

    @Autowired
    private PaisRepository repository;

    public PaisEntity getPaisId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("País não encontrado." + id));
    }

    public PaisEntity retornarIdPais(String paisNome) {
        PaisEntity pais = repository.findByNome(paisNome);
        return pais;
    }

    public List<PaisEntity> listarTodosPaises() {
        return repository.findAll().stream().toList();
    }

    public PaisEntity criarPais(PaisEntity pais) {
        pais.setId(null);

        pais.setNome(pais.getNome());

        repository.save(pais);
        return pais;
    }

    public PaisEntity atualizarPais(Long id, PaisEntity pa) {

        PaisEntity pais = getPaisId(id);

        pais.setNome(pa.getNome());

        repository.save(pais);
        return pais;
    }

    public void deletarPais(Long id) {
        PaisEntity pais = getPaisId(id);
        repository.deleteById(pais.getId());
    }

}
