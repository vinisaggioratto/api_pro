package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.condominoApartamento.CondominoApartamento;
import com.vinicius.condominiopro.licenca.Licenca;
import com.vinicius.condominiopro.repository.CondominoApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondominoApartamentoService {

    @Autowired
    private CondominoApartamentoRepository repository;
    @Autowired
    private CondominoService condominoService;
    @Autowired
    private ApartamentoService apartamentoService;

public void salvar(CondominoApartamento condominoApartamento){
    condominoApartamento.setCondomino(condominoService.retornarIdCondomino(condominoApartamento.
            getCondomino().getNome()));
    condominoApartamento.setApartamento(apartamentoService.buscarPorNumero(condominoApartamento.getApartamento().getNumero()));
    condominoApartamento.setData_entrada(condominoApartamento.getData_entrada());
    condominoApartamento.setData_saida(condominoApartamento.getData_saida());
    repository.save(condominoApartamento);
}

    public List<CondominoApartamento> listar(){
        return repository.findAll().stream().toList();
    }

    public CondominoApartamento buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }
    public void excluir(Long id){
        repository.deleteById(id);
    }
}
