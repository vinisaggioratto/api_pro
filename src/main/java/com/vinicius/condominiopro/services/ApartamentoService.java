package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.apartamento.Apartamento;
import com.vinicius.condominiopro.repository.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartamentoService {

    @Autowired
    ApartamentoRepository repository;


    public List<Apartamento> listar(){
        return repository.findAll().stream().toList();
    }

    public void salvar(Apartamento apartamento){
        repository.save(apartamento);
    }

    public Apartamento buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        repository.deleteById(id);
        //this.buscarPorId(id);
    }
}
