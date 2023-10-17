package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.manutencao.Manutencao;
import com.vinicius.condominiopro.repository.ManutencaoRepository;
import com.vinicius.condominiopro.sindico.Sindico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoService {

    @Autowired
    private ManutencaoRepository repository;

    @Autowired
    private FornecedorService fornecedorService;

    public List<Manutencao> listar(){

        return repository.findAll().stream().toList();
    }

    public void salvar(Manutencao manutencao){

        manutencao.setManutencao_nome(manutencao.getManutencao_nome());
        manutencao.setManutencao_descricao(manutencao.getManutencao_descricao());
        manutencao.setValor(manutencao.getValor());
        manutencao.setData_inicial(manutencao.getData_inicial());
        manutencao.setData_final(manutencao.getData_final());
        manutencao.setFornecedor(fornecedorService.retornarIdFornecedor(manutencao.getFornecedor().getNome()));
        repository.save(manutencao);
    }

    public Manutencao buscarPorId(Long id){

        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
