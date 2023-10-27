
package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.FornecedorEntity;
import com.vinicius.api_pro.data.FornecedorRepository;
import com.vinicius.api_pro.data.SindicoEntity;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class FornecedorService {

    @Autowired
    private FornecedorRepository repository;
    @Autowired
    private CidadeService cidadeService;
    @Autowired
    private EstadoService estadoService; 
    
    public FornecedorEntity getFornecedorId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Fornecedor não encontrado." + id));
    }

    public List<FornecedorEntity> listarTodosFornecedores() {
        return repository.findAll().stream().toList();
    }

    public FornecedorEntity buscarPorNome(String nome) {
        FornecedorEntity fornecedor = repository.findByNome(nome);
        return fornecedor;
    }

    public FornecedorEntity criarFornecedor(FornecedorEntity fornecedor) {
        fornecedor.setId(null);

        fornecedor.setBairro(fornecedor.getBairro());
        fornecedor.setCidade(cidadeService.buscarPorNome(fornecedor.getCidade().getNome()));
        fornecedor.setCpf_cnpj(fornecedor.getCpf_cnpj());
        fornecedor.setEspecialidade(fornecedor.getEspecialidade());
        fornecedor.setEstado(estadoService.buscarPorNome(fornecedor.getEstado().getNome()));
        fornecedor.setNome(fornecedor.getNome());
        fornecedor.setNumero(fornecedor.getNumero());
        fornecedor.setRua(fornecedor.getRua());
        fornecedor.setTelefone_celular(fornecedor.getTelefone_celular());
        repository.save(fornecedor);
        return fornecedor;
    }

    public FornecedorEntity atualizarFornecedor(Long id, FornecedorEntity fornecedor) {

        FornecedorEntity forn = getFornecedorId(id);

        forn.setBairro(fornecedor.getBairro());
        forn.setCidade(cidadeService.buscarPorNome(fornecedor.getCidade().getNome()));
        forn.setCpf_cnpj(fornecedor.getCpf_cnpj());
        forn.setEspecialidade(fornecedor.getEspecialidade());
        forn.setEstado(estadoService.buscarPorNome(fornecedor.getEstado().getNome()));
        forn.setNome(fornecedor.getNome());
        forn.setNumero(fornecedor.getNumero());
        forn.setRua(fornecedor.getRua());
        forn.setTelefone_celular(fornecedor.getTelefone_celular());
        repository.save(forn);
        return forn;
    }

    public void deletarFornecedor(Long id) {
        FornecedorEntity fornecedor = getFornecedorId(id);
        repository.deleteById(fornecedor.getId());
    }    
}
