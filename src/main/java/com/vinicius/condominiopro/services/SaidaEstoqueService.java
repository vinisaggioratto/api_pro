package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.entradaEstoque.EntradaEstoque;
import com.vinicius.condominiopro.repository.SaidaEstoqueRepository;
import com.vinicius.condominiopro.saidaEstoque.SaidaEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaidaEstoqueService {

    @Autowired
    private SaidaEstoqueRepository repository;
    @Autowired
    private ItemEstoqueService itemEstoqueService;

    public void salvar(SaidaEstoque saidaEstoque) {

        saidaEstoque.setItemEstoque(itemEstoqueService.buscarItemEstoque(saidaEstoque.getItemEstoque().
                getDescricao()));
        saidaEstoque.setQuantidade(saidaEstoque.getQuantidade());
        saidaEstoque.setData_saida(saidaEstoque.getData_saida());
        repository.save(saidaEstoque);
    }

    public List<SaidaEstoque> listar() {
        return repository.findAll().stream().toList();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public SaidaEstoque buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

}
