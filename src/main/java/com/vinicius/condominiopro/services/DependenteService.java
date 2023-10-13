package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.dependentes.Dependente;
import com.vinicius.condominiopro.repository.DependenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository repository;
    @Autowired
    private CondominoService condominoService;
    @Autowired
    private TipoDependenteService tipoDependenteService;

    public List<Dependente> listar(){

        return repository.findAll().stream().toList();
    }

    public void salvar(Dependente dependente){
        dependente.setNome(dependente.getNome());
        dependente.setCpf(dependente.getCpf());
        dependente.setRg(dependente.getRg());
        dependente.setTelefone_celular(dependente.getTelefone_celular());
        dependente.setMorador(dependente.getMorador());
        dependente.setTipoDependente(tipoDependenteService.retornarIdTipoDependente(
                dependente.getTipoDependente().getDescricao()));
        dependente.setCondomino(condominoService.retornarIdCondomino(dependente.getCondomino().getNome()));

        repository.save(dependente);
    }

    public void atualizar(Dependente dependente){
        dependente.setNome(dependente.getNome());
        dependente.setRg(dependente.getRg());
        dependente.setTelefone_celular(dependente.getTelefone_celular());
        dependente.setMorador(dependente.getMorador());
        dependente.setTipoDependente(tipoDependenteService.retornarIdTipoDependente(
                dependente.getTipoDependente().getDescricao()));
        dependente.setCondomino(condominoService.retornarIdCondomino(dependente.getCondomino().getNome()));

        repository.save(dependente);
    }

    public Dependente buscarPorId(Long id){

        return repository.findById(id).orElse(null);
    }

    public Dependente retornarIdDependente(String dependenteNome) {
        Dependente dependente = repository.findByNome(dependenteNome);
        return dependente;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

}
