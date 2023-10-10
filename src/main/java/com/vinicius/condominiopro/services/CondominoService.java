package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.condomino.Condomino;
import com.vinicius.condominiopro.estado.Estado;
import com.vinicius.condominiopro.repository.CondominoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondominoService {

    @Autowired
    CondominoRepository repository;

    public Condomino retornarIdCondomino(String condominoNome) {
        Condomino condomino = repository.findByNome(condominoNome);
        System.out.println("Condômino localizado: "+condomino);
        return condomino;
    }
}
