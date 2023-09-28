package com.vinicius.condominiopro.sindico;

import java.sql.Date;

import com.vinicius.condominiopro.condomino.Condomino;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarSindico(
		
		Date data_inicial,
		Date data_final_prevista,
		Date data_final,
		Condomino condomino,
		@NotBlank
		String ativo
		) {

}
