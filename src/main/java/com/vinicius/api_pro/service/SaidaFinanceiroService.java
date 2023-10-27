package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.SaidaFinanceiroEntity;
import com.vinicius.api_pro.data.SaidaFinanceiroRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaidaFinanceiroService {

    @Autowired
    private SaidaFinanceiroRepository repository;
    @Autowired
    private FornecedorService fornecedorService;

    public SaidaFinanceiroEntity getSaidaFinanceiroId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Saida financeira não encontrado." + id));
    }

    public List<SaidaFinanceiroEntity> listarTodasSaidaFinanceiro() {
        return repository.findAll().stream().toList();
    }

    public SaidaFinanceiroEntity criarSaidaFinanceiroEntity(SaidaFinanceiroEntity saidaFinanceiro) {
        saidaFinanceiro.setId(null);

        saidaFinanceiro.setData_operacao(saidaFinanceiro.getData_operacao());
        saidaFinanceiro.setFornecedor(fornecedorService.buscarPorNome(saidaFinanceiro.getFornecedor().getNome()));
        saidaFinanceiro.setNota_fiscal(saidaFinanceiro.getNota_fiscal());
        saidaFinanceiro.setValor(saidaFinanceiro.getValor());
        saidaFinanceiro.setParcelamento(saidaFinanceiro.getParcelamento());
        saidaFinanceiro.setDescricao(saidaFinanceiro.getDescricao());

        repository.save(saidaFinanceiro);
        return saidaFinanceiro;
    }

    public SaidaFinanceiroEntity atualizarSindico(Long id, SaidaFinanceiroEntity saidaFinanceiro) {

        SaidaFinanceiroEntity saida = getSaidaFinanceiroId(id);

        saida.setData_operacao(saidaFinanceiro.getData_operacao());
        saida.setFornecedor(fornecedorService.buscarPorNome(saidaFinanceiro.getFornecedor().getNome()));
        saida.setNota_fiscal(saidaFinanceiro.getNota_fiscal());
        saida.setValor(saidaFinanceiro.getValor());
        saida.setParcelamento(saidaFinanceiro.getParcelamento());
        saida.setDescricao(saidaFinanceiro.getDescricao());

        repository.save(saida);
        return saida;
    }

    public void deletarSindico(Long id) {
        SaidaFinanceiroEntity saida = getSaidaFinanceiroId(id);
        repository.deleteById(saida.getId());
    }
}
