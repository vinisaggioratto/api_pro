package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.entradaFinanceiro.EntradaFinanceiro;
import com.vinicius.condominiopro.repository.EntradaFinanceiroRepository;
import com.vinicius.condominiopro.sindico.Sindico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaFinanceiroService {

    @Autowired
    private EntradaFinanceiroRepository repository;

    @Autowired
    private CondominoService condominoService;

    public List<EntradaFinanceiro> listar(){

        return repository.findAll().stream().toList();
    }

    public void salvar(EntradaFinanceiro entradaFinanceiro){

        entradaFinanceiro.setData_operacao(entradaFinanceiro.getData_operacao());
        entradaFinanceiro.setCondomino(condominoService.retornarIdCondomino(entradaFinanceiro.getCondomino().getNome()));
        entradaFinanceiro.setValor(entradaFinanceiro.getValor());
        entradaFinanceiro.setParcelamento(entradaFinanceiro.getParcelamento());
        entradaFinanceiro.setDescricao(entradaFinanceiro.getDescricao());

        repository.save(entradaFinanceiro);
    }
    public void deletar(Long id){

        repository.deleteById(id);
    }
}
