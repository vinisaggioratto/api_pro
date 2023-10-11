package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.pais.Pais;
import com.vinicius.condominiopro.repository.TipoDependenteRepository;
import com.vinicius.condominiopro.tipoDependente.TipoDependente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDependenteService {

    @Autowired
    private TipoDependenteRepository repository;

    public List<TipoDependente> listar(){

        return repository.findAll().stream().toList();
    }

    public void salvar(TipoDependente tipoDependente){
        repository.save(tipoDependente);
    }

    public TipoDependente buscarPorId(Long id){

        return repository.findById(id).orElse(null);
    }

    public TipoDependente retornarIdTipoDependente(String tipoDependenteNome) {
        TipoDependente tipoDependente = repository.findByDescricao(tipoDependenteNome);
        return tipoDependente;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

}
