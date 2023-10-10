package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.fornecedor.Fornecedor;
import com.vinicius.condominiopro.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private EstadoService estadoService;

    public List<Fornecedor> listar(){
        return repository.findAll().stream().toList();
    }

    public void salvar(Fornecedor fornecedor){
        fornecedor.setNome(fornecedor.getNome());
        fornecedor.setCpf_cnpj(fornecedor.getCpf_cnpj());
        fornecedor.setTelefone_celular(fornecedor.getTelefone_celular());
        fornecedor.setEspecialidade(fornecedor.getEspecialidade());
        fornecedor.setRua(fornecedor.getRua());
        fornecedor.setBairro(fornecedor.getBairro());
        fornecedor.setNumero(fornecedor.getNumero());
        fornecedor.setCidade(cidadeService.retornarIdCidade(fornecedor.getCidade().getNome()));
        fornecedor.setEstado(estadoService.retornarIdEstado(fornecedor.getEstado().getNome()));
        repository.save(fornecedor);
    }

    public Fornecedor buscarPorId(Long id){

        return repository.findById(id).orElse(null);
    }

    public Fornecedor retornarIdFornecedor(String fornecedorNome) {
        Fornecedor fornecedor = repository.findByNome(fornecedorNome);
        return fornecedor;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
