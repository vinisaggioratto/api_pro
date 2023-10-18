package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.entradaEstoque.EntradaEstoque;
import com.vinicius.condominiopro.repository.EntradaEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaEstoqueService {

    @Autowired
    private EntradaEstoqueRepository repository;
    @Autowired
    private ItemEstoqueService itemEstoqueService;
    @Autowired
    private FornecedorService fornecedorService;


    public void salvar(EntradaEstoque entradaEstoque){

        entradaEstoque.setNome(entradaEstoque.getNome());
        entradaEstoque.setQuantidade(entradaEstoque.getQuantidade());
        entradaEstoque.setValor_unitario(entradaEstoque.getValor_unitario());
        entradaEstoque.setData_entrada(entradaEstoque.getData_entrada());
        entradaEstoque.setItemEstoque(itemEstoqueService.buscarItemEstoque(entradaEstoque.getItemEstoque().getDescricao()));
        entradaEstoque.setFornecedor(fornecedorService.retornarIdFornecedor(entradaEstoque.getFornecedor().getNome()));

        repository.save(entradaEstoque);
    }

    public EntradaEstoque buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<EntradaEstoque> listar(){

        return repository.findAll().stream().toList();
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }
}
