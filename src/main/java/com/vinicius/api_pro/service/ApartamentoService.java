package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.ApartamentoEntity;
import com.vinicius.api_pro.data.ApartamentoRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartamentoService {

    @Autowired
    private ApartamentoRepository repository;

    public ApartamentoEntity buscarPorNumero(Integer numero) {
        return repository.findByNumero(numero);
    }

    public ApartamentoEntity getApartamentoId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Apartamento não encontrado." + id));
    }

    public List<ApartamentoEntity> listarTodosApartamentos() {
        return repository.findAll().stream().toList();
    }

    public ApartamentoEntity criarApartamento(ApartamentoEntity apartamento) {
        apartamento.setId(null);

        apartamento.setNumero(apartamento.getNumero());
        apartamento.setAndar(apartamento.getAndar());
        apartamento.setBloco(apartamento.getBloco());
        apartamento.setStatus(apartamento.getStatus());

        repository.save(apartamento);
        return apartamento;
    }

    public ApartamentoEntity atualizarApartamento(Long id, ApartamentoEntity apartamento) {

        ApartamentoEntity apto = getApartamentoId(id);

        apto.setNumero(apartamento.getNumero());
        apto.setAndar(apartamento.getAndar());
        apto.setBloco(apartamento.getBloco());
        apto.setStatus(apartamento.getStatus());
        repository.save(apto);
        return apto;
    }

    public void deletarApartamento(Long id) {
        ApartamentoEntity apto = getApartamentoId(id);
        repository.deleteById(apto.getId());
    }
}
