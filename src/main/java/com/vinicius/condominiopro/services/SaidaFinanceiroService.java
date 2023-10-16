package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.fornecedor.Fornecedor;
import com.vinicius.condominiopro.repository.SaidaFinanceiroRepository;
import com.vinicius.condominiopro.saidaFinanceiro.SaidaFinanceiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaidaFinanceiroService {

    @Autowired
    private SaidaFinanceiroRepository repository;

    @Autowired
    private FornecedorService fornecedorService;

    public List<SaidaFinanceiro> listar(){

        return repository.findAll().stream().toList();
    }

    public void salvar(SaidaFinanceiro saidaFinanceiro){

        saidaFinanceiro.setData_operacao(saidaFinanceiro.getData_operacao());
        saidaFinanceiro.setFornecedor(fornecedorService.retornarIdFornecedor(saidaFinanceiro.getFornecedor().getNome()));
        saidaFinanceiro.setNota_fiscal(saidaFinanceiro.getNota_fiscal());
        saidaFinanceiro.setValor(saidaFinanceiro.getValor());
        saidaFinanceiro.setParcelamento(saidaFinanceiro.getParcelamento());
        saidaFinanceiro.setDescricao(saidaFinanceiro.getDescricao());

        repository.save(saidaFinanceiro);
    }

    public SaidaFinanceiro buscarPorId(Long id){

        return repository.findById(id).orElse(null);
    }
    public void deletar(Long id){
        repository.deleteById(id);
    }
}
