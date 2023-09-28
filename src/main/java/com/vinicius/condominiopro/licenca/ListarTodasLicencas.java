package com.vinicius.condominiopro.licenca;

import java.sql.Date;

public record ListarTodasLicencas(
		long licenca_id,
		String licenca_nome,
		String licenca_descricao,
	    String numero,
	    String emissor,
	    Date data_emissao,
	    Date data_validade,
	    String valido
		) {

	public ListarTodasLicencas(Licenca licenca) {
		this(licenca.getLicenca_id(), licenca.getLicenca_nome(), licenca.getLicenca_descricao(),
				licenca.getNumero(), licenca.getEmissor(), licenca.getData_emissao(), licenca.getData_validade(),
				licenca.getValido());
	}
}
