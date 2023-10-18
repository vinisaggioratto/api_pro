package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.licenca.Licenca;
import com.vinicius.condominiopro.repository.LicencaRepository;
import com.vinicius.condominiopro.sindico.Sindico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicencaService {

    @Autowired
    private LicencaRepository repository;

    public List<Licenca> listar(){

        return repository.findAll().stream().toList();
    }

    public void salvar(Licenca licenca){

        licenca.setNome(licenca.getNome());
        licenca.setDescricao(licenca.getDescricao());
        licenca.setNumero(licenca.getNumero());
        licenca.setEmissor(licenca.getEmissor());
        licenca.setData_emissao(licenca.getData_emissao());
        licenca.setData_validade(licenca.getData_validade());
        licenca.setValido(licenca.getValido());
        repository.save(licenca);
    }

    public Licenca buscarPorId(Long id){

        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
