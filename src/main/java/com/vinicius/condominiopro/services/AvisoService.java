package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.aviso.Aviso;
import com.vinicius.condominiopro.repository.AvisoRepository;
import com.vinicius.condominiopro.sindico.Sindico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisoService {

    @Autowired
    private AvisoRepository repository;

    @Autowired
    private SindicoService sindicoService;

    public void salvar(Aviso aviso){

        aviso.setNome(aviso.getNome());
        aviso.setDescricao(aviso.getDescricao());
        aviso.setData_aviso(aviso.getData_aviso());
        aviso.setSindico(sindicoService.buscarPorNome(aviso.getSindico().getNome()));
        repository.save(aviso);
    }
    public List<Aviso> listar(){

        return repository.findAll().stream().toList();
    }


    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
