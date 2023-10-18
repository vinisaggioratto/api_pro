package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.itemEstoque.ItemEstoque;
import com.vinicius.condominiopro.repository.ItemEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemEstoqueService {

    @Autowired
    private ItemEstoqueRepository repository;

    public void salvar(ItemEstoque itemEstoque) {
        repository.save(itemEstoque);
    }

    public List<ItemEstoque> listar() {
        return repository.findAll().stream().toList();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public ItemEstoque buscarItemEstoque(String descricao){
        ItemEstoque itemEstoque = repository.findByDescricao(descricao);
        return itemEstoque;
    }
}
