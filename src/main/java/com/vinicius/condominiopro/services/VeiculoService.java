package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.dependentes.Dependente;
import com.vinicius.condominiopro.repository.VeiculoRepository;
import com.vinicius.condominiopro.veiculo.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;
    @Autowired
    private CondominoService condominoService;

    public List<Veiculo> listar(){

        return repository.findAll().stream().toList();
    }

    public void salvar(Veiculo veiculo){
        veiculo.setPlaca(veiculo.getPlaca());
        veiculo.setMarca(veiculo.getMarca());
        veiculo.setCor(veiculo.getCor());
        veiculo.setAtivo(veiculo.getAtivo());
        veiculo.setModelo(veiculo.getModelo());
        veiculo.setCondomino(condominoService.retornarIdCondomino(veiculo.getCondomino().getNome()));

        repository.save(veiculo);
    }


    public void deletar(Long id){
        repository.deleteById(id);
    }
}
