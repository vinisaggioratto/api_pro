package com.vinicius.condominiopro.cidade;

import com.vinicius.condominiopro.estado.Estado;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarCidade(
		@NotBlank
		String cidade_nome,
		Estado estado
		) {

}
