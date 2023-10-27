
package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.EntradaEstoqueEntity;
import com.vinicius.api_pro.data.EntradaEstoqueRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaEstoqueService {
    
    @Autowired
    private EntradaEstoqueRepository repository;
    @Autowired
    private ItemEstoqueService itemEstoqueService;
    @Autowired
    private FornecedorService fornecedorService;
    
    public EntradaEstoqueEntity getEntradaEstoqueId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Entrada no estoque não encontrado." + id));
    }

    public List<EntradaEstoqueEntity> listarTodasEntradaEstoque() {
        return repository.findAll().stream().toList();
    }

    public EntradaEstoqueEntity criarEntradaEstoque(EntradaEstoqueEntity entradaEstoque) {
        entradaEstoque.setId(null);

        entradaEstoque.setNome(entradaEstoque.getNome());
        entradaEstoque.setQuantidade(entradaEstoque.getQuantidade());
        entradaEstoque.setValor_unitario(entradaEstoque.getValor_unitario());
        entradaEstoque.setData_entrada(entradaEstoque.getData_entrada());
        entradaEstoque.setItemEstoque(itemEstoqueService.buscarPorDescricao(entradaEstoque.getItemEstoque().getDescricao()));
        entradaEstoque.setFornecedor(fornecedorService.buscarPorNome(entradaEstoque.getFornecedor().getNome()));

        repository.save(entradaEstoque);
        return entradaEstoque;
    }

    public EntradaEstoqueEntity atualizarEntradaEstoque(Long id, EntradaEstoqueEntity entradaEstoque) {

        EntradaEstoqueEntity ee = getEntradaEstoqueId(id);

        ee.setNome(entradaEstoque.getNome());
        ee.setQuantidade(entradaEstoque.getQuantidade());
        ee.setValor_unitario(entradaEstoque.getValor_unitario());
        ee.setData_entrada(entradaEstoque.getData_entrada());
        ee.setItemEstoque(itemEstoqueService.buscarPorDescricao(entradaEstoque.getItemEstoque().getDescricao()));
        ee.setFornecedor(fornecedorService.buscarPorNome(entradaEstoque.getFornecedor().getNome()));

        repository.save(ee);
        return ee;
    }

    public void deletarEntradaEstoque(Long id) {
        EntradaEstoqueEntity entradaEstoque = getEntradaEstoqueId(id);
        repository.deleteById(entradaEstoque.getId());
    }    
}
