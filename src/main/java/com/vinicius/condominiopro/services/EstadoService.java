package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.estado.Estado;
import com.vinicius.condominiopro.pais.PaisConverter;
import com.vinicius.condominiopro.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository repository;

    @Autowired
    private PaisConverter paisConverter;

    public List<Estado> listar(){
        return repository.findAll().stream().toList();
    }

    public void salvar(Estado estado){

        estado.setNome(estado.getNome());
        estado.setPais(paisConverter.converterNome(estado.getNome()));
        repository.save(estado);
    }

    public Estado buscarPorId(Long id){

        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
