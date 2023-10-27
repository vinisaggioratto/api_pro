package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.SaidaEstoqueEntity;
import com.vinicius.api_pro.data.SaidaEstoqueRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaidaEstoqueService {

    @Autowired
    private SaidaEstoqueRepository repository;
    @Autowired
    private ItemEstoqueService itemEstoqueService;

    public SaidaEstoqueEntity getSaidaEstoqueId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Saida do estoque não encontrada." + id));
    }

    public List<SaidaEstoqueEntity> listarTodasSaidaEstoque() {
        return repository.findAll().stream().toList();
    }

    public SaidaEstoqueEntity criarSaidaEstoque(SaidaEstoqueEntity saidaEstoque) {
        saidaEstoque.setId(null);

        saidaEstoque.setItemEstoque(itemEstoqueService.buscarPorDescricao(saidaEstoque.getItemEstoque().
                getDescricao()));
        saidaEstoque.setQuantidade(saidaEstoque.getQuantidade());
        saidaEstoque.setData_saida(saidaEstoque.getData_saida());
        repository.save(saidaEstoque);
        return saidaEstoque;
    }

    public SaidaEstoqueEntity atualizarSaidaEstoque(Long id, SaidaEstoqueEntity saidaEstoque) {

        SaidaEstoqueEntity saida = getSaidaEstoqueId(id);

        saida.setItemEstoque(itemEstoqueService.buscarPorDescricao(saidaEstoque.getItemEstoque().
                getDescricao()));
        saida.setQuantidade(saidaEstoque.getQuantidade());
        saida.setData_saida(saidaEstoque.getData_saida());
        repository.save(saida);
        return saida;
    }

    public void deletarSaidaEstoque(Long id) {
        SaidaEstoqueEntity saida = getSaidaEstoqueId(id);
        repository.deleteById(saida.getId());
    }
}
