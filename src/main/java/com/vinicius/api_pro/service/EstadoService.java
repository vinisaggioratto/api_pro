
package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.EstadoEntity;
import com.vinicius.api_pro.data.EstadoRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository repository;
    
    @Autowired
    private PaisService paisService;
    
    
    public EstadoEntity getEstadoId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Estado não encontrado." + id));
    }

    public List<EstadoEntity> listarTodosEstados() {
        return repository.findAll().stream().toList();
    }

    public EstadoEntity buscarPorNome(String nome) {
        EstadoEntity estado = repository.findByNome(nome);
        return estado;
    }

    public EstadoEntity criarEstado(EstadoEntity estado) {
        estado.setId(null);

        estado.setNome(estado.getNome());
        estado.setPais(paisService.retornarIdPais(estado.getPais().getNome()));
        repository.save(estado);
        return estado;
    }

    public EstadoEntity atualizarEstado(Long id, EstadoEntity estado) {

        EstadoEntity est = getEstadoId(id);

        est.setNome(estado.getNome());
        est.setPais(paisService.retornarIdPais(estado.getPais().getNome()));
        repository.save(est);
        return est;
    }

    public void deletarEstado(Long id) {
        EstadoEntity estado = getEstadoId(id);
        repository.deleteById(estado.getId());
    }    
}
