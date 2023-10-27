package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.LicencaEntity;
import com.vinicius.api_pro.data.LicencaRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicencaService {

    @Autowired
    private LicencaRepository repository;

    public LicencaEntity getLicencaId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Licença não encontrada" + id));
    }

    public List<LicencaEntity> listarTodasLicencas() {
        return repository.findAll().stream().toList();
    }

    public LicencaEntity criarLicenca(LicencaEntity licenca) {
        licenca.setId(null);
        
        licenca.setNome(licenca.getNome());
        licenca.setDescricao(licenca.getDescricao());
        licenca.setNumero(licenca.getNumero());
        licenca.setEmissor(licenca.getEmissor());
        licenca.setData_emissao(licenca.getData_emissao());
        licenca.setData_validade(licenca.getData_validade());
        licenca.setValido(licenca.getValido());
        repository.save(licenca);
        return licenca;
    }
    
        public LicencaEntity atualizarLicenca(Long id, LicencaEntity licenca) {

        LicencaEntity lic = getLicencaId(id);

        lic.setNome(licenca.getNome());
        lic.setDescricao(licenca.getDescricao());
        lic.setNumero(licenca.getNumero());
        lic.setEmissor(licenca.getEmissor());
        lic.setData_emissao(licenca.getData_emissao());
        lic.setData_validade(licenca.getData_validade());
        lic.setValido(licenca.getValido());
        repository.save(lic);
        return lic;
    }

    public void deletarLicenca(Long id) {
        LicencaEntity licenca = getLicencaId(id);
        repository.deleteById(licenca.getId());
    }
}
