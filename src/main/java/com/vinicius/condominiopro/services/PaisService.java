package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.apartamento.Apartamento;
import com.vinicius.condominiopro.pais.Pais;
import com.vinicius.condominiopro.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    PaisRepository repository;

    public List<Pais> listar(){

        return repository.findAll().stream().toList();
    }

    public void salvar(Pais pais){
        repository.save(pais);
    }

    public Pais buscarPorId(Long id){

        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
