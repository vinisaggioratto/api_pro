package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.repository.SindicoRepository;
import com.vinicius.condominiopro.sindico.Sindico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SindicoService {

    @Autowired
    private SindicoRepository repository;

    @Autowired
    private CondominoService condominoService;

    public List<Sindico> listar(){
        return repository.findAll().stream().toList();
    }

    public void salvar(Sindico sindico){

        sindico.setData_inicial(sindico.getData_inicial());
        sindico.setData_final_prevista(sindico.getData_final_prevista());
        sindico.setData_final(sindico.getData_final());
        sindico.setCondomino(condominoService.retornarIdCondomino(sindico.getCondomino().getNome()));
        sindico.setAtivo(sindico.getAtivo());
        repository.save(sindico);
    }

    public Sindico buscarPorId(Long id){

        return repository.findById(id).orElse(null);
    }

    public Sindico retornarIdSindico(String sindicoNome) {
        Sindico sindico = repository.findByCondominoNome(sindicoNome);
        return sindico;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
