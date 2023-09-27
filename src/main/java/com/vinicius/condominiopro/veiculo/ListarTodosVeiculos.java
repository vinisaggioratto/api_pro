package com.vinicius.condominiopro.veiculo;

public record ListarTodosVeiculos(
	    long veiculo_id,
		String placa,
	    String marca,
	    String cor,
	    String ativo,
	    String modelo,
	    String condomino
	    ) {
	
	public ListarTodosVeiculos(Veiculo veiculo) {
		this(veiculo.getVeiculo_id(), veiculo.getPlaca(), veiculo.getMarca(), veiculo.getCor(), veiculo.getAtivo(),
				veiculo.getModelo(), veiculo.getCondomino().getNome());
	}

}
