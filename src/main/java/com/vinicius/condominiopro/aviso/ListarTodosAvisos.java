package com.vinicius.condominiopro.aviso;

import java.sql.Date;

public record ListarTodosAvisos(
	    long aviso_id,	
	    String aviso_nome,
	    String aviso_descricao,
	    Date data_aviso,
	    String sindico
		) {
	
	public ListarTodosAvisos(Aviso aviso) {
		this(aviso.getAviso_id(), aviso.getAviso_nome(), aviso.getAviso_descricao(), 
				aviso.getData_aviso(), aviso.getSindico().getCondomino().getNome());
	}

}
