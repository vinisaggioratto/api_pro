package com.vinicius.condominiopro.apartamento;

public record ListarTodosApartamentos(

		Long apartamento_id, Integer numero, Integer andar, String bloco, String status) {

	public ListarTodosApartamentos(Apartamento apartamento) {
		this(apartamento.getApartamento_id(), apartamento.getNumero(), apartamento.getAndar(), apartamento.getBloco(),
				apartamento.getStatus());
	}

}
