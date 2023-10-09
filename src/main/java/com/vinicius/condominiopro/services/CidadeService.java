package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.cidade.Cidade;
import com.vinicius.condominiopro.estado.Estado;
import com.vinicius.condominiopro.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository repository;

    @Autowired
    EstadoService estadoService;

    public List<Cidade> listar(){
        return repository.findAll().stream().toList();
    }

    public void salvar(Cidade cidade){
        cidade.setNome(cidade.getNome());
        cidade.setEstado(estadoService.retornarIdEstado(cidade.getEstado().getNome()));
        repository.save(cidade);
    }

    public Cidade buscarPorId(Long id){

        return repository.findById(id).orElse(null);
    }

    public Cidade retornarIdCidade(String cidadeNome) {
        Cidade cidade = repository.findByNome(cidadeNome);
        return cidade;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
