package com.vinicius.condominiopro.ocorrencia;

import java.sql.Date;

import com.vinicius.condominiopro.condomino.Condomino;
import com.vinicius.condominiopro.sindico.Sindico;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarOcorrencia(
		@NotBlank
		String ocorrencia_nome,
		@NotBlank
		String ocorrencia_descricao,
		Date data_ocorrencia,
		Sindico sindico,
		Condomino condomino
		) {

}
