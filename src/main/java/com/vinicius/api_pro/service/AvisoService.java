
package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.AvisoEntity;
import com.vinicius.api_pro.data.AvisoRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvisoService {
    
    @Autowired
    private AvisoRepository repository;
    
    @Autowired
    private SindicoService sindicoService;
    
    public AvisoEntity getAvisoId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Aviso não encontrado." + id));
    }

    public List<AvisoEntity> listarTodosAvisos() {
        return repository.findAll().stream().toList();
    }
    
    public AvisoEntity criarAviso(AvisoEntity aviso) {
        aviso.setId(null);

        aviso.setNome(aviso.getNome());
        aviso.setDescricao(aviso.getDescricao());
        aviso.setData_aviso(aviso.getData_aviso());
        aviso.setSindico(sindicoService.buscarPorNome(aviso.getSindico().getNome()));

        repository.save(aviso);
        return aviso;
    }

    public AvisoEntity atualizarAviso(Long id, AvisoEntity av) {

        AvisoEntity aviso = getAvisoId(id);

        aviso.setNome(av.getNome());
        aviso.setDescricao(av.getDescricao());
        aviso.setData_aviso(av.getData_aviso());
        aviso.setSindico(sindicoService.buscarPorNome(av.getSindico().getNome()));
        repository.save(aviso);
        return aviso;
    }

    public void deletarApartamento(Long id) {
        AvisoEntity aviso = getAvisoId(id);
        repository.deleteById(aviso.getId());
    }    
}
