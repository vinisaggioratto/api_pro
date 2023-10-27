package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.VeiculoEntity;
import com.vinicius.api_pro.data.VeiculoRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;
    @Autowired
    private CondominoService condominoService;

    
    public VeiculoEntity getVeiculoId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Veículo não encontrado." + id));
    }

    public List<VeiculoEntity> listarTodosVeiculos() {
        return repository.findAll().stream().toList();
    }

    public VeiculoEntity buscarPorPlaca(String nome) {
        VeiculoEntity veiculo = repository.findByPlaca(nome);
        return veiculo;
    }

    public VeiculoEntity criarVeiculo(VeiculoEntity veiculo) {
        veiculo.setId(null);

        veiculo.setPlaca(veiculo.getPlaca());
        veiculo.setMarca(veiculo.getMarca());
        veiculo.setCor(veiculo.getCor());
        veiculo.setAtivo(veiculo.getAtivo());
        veiculo.setModelo(veiculo.getModelo());
        veiculo.setCondomino(condominoService.buscarPorNome(veiculo.getCondomino().getNome()));

        repository.save(veiculo);
        return veiculo;
    }

    public VeiculoEntity atualizarVeiculo(Long id, VeiculoEntity veiculo) {

        VeiculoEntity veic = getVeiculoId(id);

        veic.setPlaca(veiculo.getPlaca());
        veic.setMarca(veiculo.getMarca());
        veic.setCor(veiculo.getCor());
        veic.setAtivo(veiculo.getAtivo());
        veic.setModelo(veiculo.getModelo());
        veic.setCondomino(condominoService.buscarPorNome(veiculo.getCondomino().getNome()));

        repository.save(veic);
        return veic;
    }

    public void deletarVeiculo(Long id) {
        VeiculoEntity veiculo = getVeiculoId(id);
        repository.deleteById(veiculo.getId());
    }
}
