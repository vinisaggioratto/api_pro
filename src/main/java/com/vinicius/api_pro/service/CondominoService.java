/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.CondominoEntity;
import com.vinicius.api_pro.data.CondominoRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondominoService {

    @Autowired
    CondominoRepository repository;

    public CondominoEntity getCondominoId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Condômino não encontrado." + id));
    }

    public List<CondominoEntity> listarTodosCondominos() {
        return repository.findAll().stream().toList();
    }

    public CondominoEntity buscarPorNome(String nome) {
        CondominoEntity condomino = repository.findByNome(nome);
        return condomino;
    }

    public CondominoEntity retornarCpfCondomino(String cpf) {
        CondominoEntity condomino = repository.findByCpf(cpf);
        return condomino;
    }

    public CondominoEntity criarCondomino(CondominoEntity condomino) {
        condomino.setId(null);

        repository.save(condomino);
        return condomino;
    }

    public CondominoEntity atualizarSindico(Long id, CondominoEntity condomino) {

        CondominoEntity cond = getCondominoId(id);

        cond.setNome(condomino.getNome());
        cond.setCpf(condomino.getCpf());
        cond.setRg(condomino.getRg());
        cond.setProprietario(condomino.getProprietario());
        cond.setTelefone_celular(condomino.getTelefone_celular());
        cond.setMorador(condomino.getMorador());
        
        repository.save(cond);
        return cond;
    }

    public void deletarCondomino(Long id) {
        CondominoEntity condomino = getCondominoId(id);
        repository.deleteById(condomino.getId());
    }
}
