package com.vinicius.condominiopro.veiculo;

import com.vinicius.condominiopro.condomino.Condomino;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarVeiculo(
		
		@NotBlank
	    String placa,
	    @NotBlank
	    String marca,
	    @NotBlank
	    String cor,
	    @NotBlank
	    String ativo,
	    @NotBlank
	    String modelo,
	    Condomino condomino
		) {

}
