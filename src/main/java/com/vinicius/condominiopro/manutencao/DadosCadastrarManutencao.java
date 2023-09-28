package com.vinicius.condominiopro.manutencao;

import java.sql.Date;

import com.vinicius.condominiopro.fornecedor.Fornecedor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarManutencao(
	
		@NotBlank
		String manutencao_nome,
		@NotBlank
		String manutencao_descricao,
		Double valor,
		Date data_inicial,
		Date data_final,
		Fornecedor fornecedor
		) {

}
