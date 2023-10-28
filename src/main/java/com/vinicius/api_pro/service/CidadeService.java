
package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.CidadeEntity;
import com.vinicius.api_pro.data.CidadeRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    
    @Autowired
    CidadeRepository repository;

    @Autowired
    EstadoService estadoService;   
    
    public CidadeEntity getCidadeId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Cidade não encontrada." + id));
    }

    public List<CidadeEntity> listarTodasCidades() {
        return repository.findAll().stream().toList();
    }

    public CidadeEntity buscarPorNome(String nome) {
        CidadeEntity cidade = repository.findByNome(nome);
        return cidade;
    }

    public CidadeEntity criarCidade(CidadeEntity cidade) {
        cidade.setId(null);

        cidade.setNome(cidade.getNome());
        cidade.setEstado(estadoService.buscarPorNome(cidade.getEstado().getNome()));
        repository.save(cidade);
        return cidade;
    }

    public CidadeEntity atualizarCidade(Long id, CidadeEntity cidade) {

        CidadeEntity cid = getCidadeId(id);

        cid.setNome(cidade.getNome());
        cid.setEstado(estadoService.buscarPorNome(cidade.getEstado().getNome()));
        repository.save(cid);
        return cid;
    }

    public void deletarCidade(Long id) {
        CidadeEntity cidade = getCidadeId(id);
        repository.deleteById(cidade.getId());
    }    
}
