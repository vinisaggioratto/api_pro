package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.EntradaFinanceiroEntity;
import com.vinicius.api_pro.data.EntradaFinanceiroRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaFinanceiroService {

    @Autowired
    private EntradaFinanceiroRepository repository;
    @Autowired
    private CondominoService condominoService;

    public EntradaFinanceiroEntity getEntradaFinanceiroId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Entrada não encontrado." + id));
    }

    public List<EntradaFinanceiroEntity> listarTodasEntradaFinanceiro() {
        return repository.findAll().stream().toList();
    }

    public EntradaFinanceiroEntity criarEntradaFinanceiro(EntradaFinanceiroEntity entradaFinanceiro) {
        entradaFinanceiro.setId(null);

        entradaFinanceiro.setData_operacao(entradaFinanceiro.getData_operacao());
        entradaFinanceiro.setCondomino(condominoService.buscarPorNome(entradaFinanceiro.getCondomino().getNome()));
        entradaFinanceiro.setValor(entradaFinanceiro.getValor());
        entradaFinanceiro.setParcelamento(entradaFinanceiro.getParcelamento());
        entradaFinanceiro.setDescricao(entradaFinanceiro.getDescricao());

        repository.save(entradaFinanceiro);
        return entradaFinanceiro;
    }

    public EntradaFinanceiroEntity atualizarEntradaFinanceiro(Long id, EntradaFinanceiroEntity entradaFinanceiro) {

        EntradaFinanceiroEntity entrada = getEntradaFinanceiroId(id);

        entrada.setData_operacao(entradaFinanceiro.getData_operacao());
        entrada.setCondomino(condominoService.buscarPorNome(entradaFinanceiro.getCondomino().getNome()));
        entrada.setValor(entradaFinanceiro.getValor());
        entrada.setParcelamento(entradaFinanceiro.getParcelamento());
        entrada.setDescricao(entradaFinanceiro.getDescricao());

        repository.save(entrada);
        return entrada;
    }

    public void deletarEntradaFinanceiro(Long id) {
        EntradaFinanceiroEntity entrada = getEntradaFinanceiroId(id);
        repository.deleteById(entrada.getId());
    }
}
