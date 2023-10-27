
package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.ItemEstoqueEntity;
import com.vinicius.api_pro.data.ItemEstoqueRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemEstoqueService {

    @Autowired
    private ItemEstoqueRepository repository;    
    
    public ItemEstoqueEntity getItemEstoqueId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Item não encontrado." + id));
    }

    public List<ItemEstoqueEntity> listarTodosItemEstoque() {
        return repository.findAll().stream().toList();
    }

    public ItemEstoqueEntity buscarPorDescricao(String nome) {
        ItemEstoqueEntity itemEstoque = repository.findByDescricao(nome);
        return itemEstoque;
    }

    public ItemEstoqueEntity criarItemEstoque(ItemEstoqueEntity itemEstoque) {
        itemEstoque.setId(null);

        repository.save(itemEstoque);
        return itemEstoque;
    }

    public ItemEstoqueEntity atualizarItemEstoque(Long id, ItemEstoqueEntity itemEstoque) {

        ItemEstoqueEntity item = getItemEstoqueId(id);

        item.setDescricao(itemEstoque.getDescricao());
        item.setEstoque(itemEstoque.getEstoque());
        repository.save(item);
        return item;
    }

    public void deletarItemEstoque(Long id) {
        ItemEstoqueEntity itemEstoque = getItemEstoqueId(id);
        repository.deleteById(itemEstoque.getId());
    }    
}
