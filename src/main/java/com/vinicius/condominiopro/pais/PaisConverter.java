package com.vinicius.condominiopro.pais;

import com.vinicius.condominiopro.repository.PaisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PaisConverter implements Converter<String, Pais> {
    @Autowired
    private PaisRepository repository;

    @Override
    public Pais convert(String nome) {
        return repository.findByNome(nome);
    }

    public Pais converterNome(String nome){
        Pais pais = new Pais();
        for (Pais p : pais.getPaisList()){
            if (nome.equals(p.getNome())){
                return p;
            }
        }
        return null;
    }


}