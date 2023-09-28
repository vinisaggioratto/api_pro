package com.vinicius.condominiopro.estado;

import com.vinicius.condominiopro.pais.Pais;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarEstado(
		@NotBlank
		String estado_nome,
		Pais pais
		) {

}
