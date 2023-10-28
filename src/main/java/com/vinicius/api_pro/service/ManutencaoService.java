package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.ManutencaoEntity;
import com.vinicius.api_pro.data.ManutencaoRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManutencaoService {

    @Autowired
    private ManutencaoRepository repository;
    @Autowired
    private FornecedorService fornecedorService;
    
        public ManutencaoEntity getManutencaoId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Manutenção não encontrado." + id));
    }

    public List<ManutencaoEntity> listarTodasManutencao() {
        return repository.findAll().stream().toList();
    }

    public ManutencaoEntity buscarPorNome(String nome) {
        ManutencaoEntity manutencao = repository.findByNome(nome);
        return manutencao;
    }

    public ManutencaoEntity criarManutencao(ManutencaoEntity manutencao) {
        manutencao.setId(null);

        manutencao.setNome(manutencao.getNome());
        manutencao.setDescricao(manutencao.getDescricao());
        manutencao.setValor(manutencao.getValor());
        manutencao.setData_inicial(manutencao.getData_inicial());
        manutencao.setData_final(manutencao.getData_final());
        manutencao.setFornecedor(fornecedorService.buscarPorNome(manutencao.getFornecedor().getNome()));
        repository.save(manutencao);
        return manutencao;
    }

    public ManutencaoEntity atualizarManutencao(Long id, ManutencaoEntity manutencao) {

        ManutencaoEntity man = getManutencaoId(id);

        man.setNome(manutencao.getNome());
        man.setDescricao(manutencao.getDescricao());
        man.setValor(manutencao.getValor());
        man.setData_inicial(manutencao.getData_inicial());
        man.setData_final(manutencao.getData_final());
        man.setFornecedor(fornecedorService.buscarPorNome(manutencao.getFornecedor().getNome()));
        repository.save(man);
        return man;
    }

    public void deletarManutencao(Long id) {
        ManutencaoEntity manutencao = getManutencaoId(id);
        repository.deleteById(manutencao.getId());
    }
}
