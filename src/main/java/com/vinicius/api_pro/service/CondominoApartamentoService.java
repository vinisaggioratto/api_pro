
package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.CondominoApartamentoEntity;
import com.vinicius.api_pro.data.CondominoApartamentoRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondominoApartamentoService {

    @Autowired
    private CondominoApartamentoRepository repository;
    @Autowired
    private CondominoService condominoService;
    @Autowired
    private ApartamentoService apartamentoService;

 
    public CondominoApartamentoEntity getCondominoApartamentoId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Associação não encontrado." + id));
    }

    public List<CondominoApartamentoEntity> listarTodosCondominoApartamento() {
        return repository.findAll().stream().toList();
    }

    public CondominoApartamentoEntity criarCondominoApartamento(CondominoApartamentoEntity condominoApartamento) {
        condominoApartamento.setId(null);

        condominoApartamento.setCondomino(condominoService.buscarPorNome(condominoApartamento.
                getCondomino().getNome()));
        condominoApartamento.setApartamento(apartamentoService.buscarPorNumero(condominoApartamento.getApartamento().getNumero()));
        condominoApartamento.setData_entrada(condominoApartamento.getData_entrada());
        condominoApartamento.setData_saida(condominoApartamento.getData_saida());
        repository.save(condominoApartamento);
        return condominoApartamento;
    }

    public CondominoApartamentoEntity atualizarCondominoApartamento(Long id, CondominoApartamentoEntity condominoApartamento) {

        CondominoApartamentoEntity ca = getCondominoApartamentoId(id);

        ca.setCondomino(condominoService.buscarPorNome(condominoApartamento.
                getCondomino().getNome()));
        ca.setApartamento(apartamentoService.buscarPorNumero(condominoApartamento.getApartamento().getNumero()));
        ca.setData_entrada(condominoApartamento.getData_entrada());
        ca.setData_saida(condominoApartamento.getData_saida());
        repository.save(ca);
        repository.save(ca);
        return ca;
    }

    public void deletarCondominoApartamento(Long id) {
        CondominoApartamentoEntity condominoApartamento = getCondominoApartamentoId(id);
        repository.deleteById(condominoApartamento.getId());
    }
}
