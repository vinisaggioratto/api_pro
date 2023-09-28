package com.vinicius.condominiopro.aviso;

import java.sql.Date;

import com.vinicius.condominiopro.sindico.Sindico;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarAviso(
		@NotBlank
		String aviso_nome,
		@NotBlank
		String aviso_descricao,
		Date data_aviso,
		Sindico sindico
		) {

}
