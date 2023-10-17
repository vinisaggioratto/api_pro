package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.repository.AvisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvisoService {

    @Autowired
    private AvisoRepository repository;

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
