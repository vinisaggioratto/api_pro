package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.condomino.Condomino;
import com.vinicius.condominiopro.repository.CondominoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondominoService {

    @Autowired
    CondominoRepository repository;

    public List<Condomino> listar(){
        return repository.findAll().stream().toList();
    }

    public void salvar(Condomino condomino){
        repository.save(condomino);
    }

    public Condomino retornarIdCondomino(String condominoNome) {
        Condomino condomino = repository.findByNome(condominoNome);
        System.out.println("Condômino localizado: "+condomino.getNome());
        return condomino;
    }

    public Condomino retornarCpfCondomino(String cpf){
        Condomino condomino = repository.findByCpf(cpf);
        return condomino;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
