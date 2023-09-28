package com.vinicius.condominiopro.condominoApartamento;

import java.sql.Date;

import com.vinicius.condominiopro.apartamento.Apartamento;
import com.vinicius.condominiopro.condomino.Condomino;

public record DadosCadastrarCondominoApartamento(
		
		Condomino condomino,
		Apartamento apartamento,
		Date data_entrada,
		Date data_saida
		) {

}
