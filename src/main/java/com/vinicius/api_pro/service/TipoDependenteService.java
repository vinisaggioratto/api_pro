package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.TipoDependenteEntity;
import com.vinicius.api_pro.data.TipoDependenteRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class TipoDependenteService {

    @Autowired
    private TipoDependenteRepository repository;
    
    public TipoDependenteEntity getTipoDependenteId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Tipo de dependente não encontrado." + id));
    }

    public List<TipoDependenteEntity> listarTodosTipoDependentes() {
        return repository.findAll().stream().toList();
    }

    public TipoDependenteEntity buscarPorNome(String nome) {
        TipoDependenteEntity tipoDependente = repository.findByDescricao(nome);
        return tipoDependente;
    }

    public TipoDependenteEntity criarTipoDependente(TipoDependenteEntity tipoDependente) {
        tipoDependente.setId(null);

        repository.save(tipoDependente);
        return tipoDependente;
    }

    public TipoDependenteEntity atualizarTipoDependente(Long id, TipoDependenteEntity tipoDependente) {

        TipoDependenteEntity tip = getTipoDependenteId(id);

        tip.setDescricao(tipoDependente.getDescricao());

        repository.save(tip);
        return tip;
    }

    public void deletarTipoDependente(Long id) {
        TipoDependenteEntity tipoDependente = getTipoDependenteId(id);
        repository.deleteById(tipoDependente.getId());
    }    
}
