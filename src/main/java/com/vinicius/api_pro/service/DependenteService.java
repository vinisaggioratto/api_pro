package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.DependenteEntity;
import com.vinicius.api_pro.data.DependenteRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository repository;
    @Autowired
    private CondominoService condominoService;
    @Autowired
    private TipoDependenteService tipoDependenteService;

    public DependenteEntity getDependenteId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Dependente não encontrado." + id));
    }

    public List<DependenteEntity> listarTodosDependentes() {
        return repository.findAll().stream().toList();
    }

    public DependenteEntity buscarPorNome(String nome) {
        DependenteEntity dependente = repository.findByNome(nome);
        return dependente;
    }

    public DependenteEntity criarDependente(DependenteEntity dependente) {
        dependente.setId(null);

        dependente.setNome(dependente.getNome());
        dependente.setCpf(dependente.getCpf());
        dependente.setRg(dependente.getRg());
        dependente.setTelefone_celular(dependente.getTelefone_celular());
        dependente.setMorador(dependente.getMorador());
        dependente.setTipoDependente(tipoDependenteService.buscarPorNome(
                dependente.getTipoDependente().getDescricao()));
        dependente.setCondomino(condominoService.buscarPorNome(dependente.getCondomino().getNome()));

        repository.save(dependente);
        return dependente;
    }

    public DependenteEntity atualizarDependente(Long id, DependenteEntity dependente) {

        DependenteEntity dep = getDependenteId(id);

        dep.setNome(dependente.getNome());
        dep.setCpf(dependente.getCpf());
        dep.setRg(dependente.getRg());
        dep.setTelefone_celular(dependente.getTelefone_celular());
        dep.setMorador(dependente.getMorador());
        dependente.setTipoDependente(tipoDependenteService.buscarPorNome(
                dependente.getTipoDependente().getDescricao()));
        dep.setCondomino(condominoService.buscarPorNome(dependente.getCondomino().getNome()));

        repository.save(dep);
        return dep;
    }

    public void deletarDependente(Long id) {
        DependenteEntity dependente = getDependenteId(id);
        repository.deleteById(dependente.getId());
    }
}
