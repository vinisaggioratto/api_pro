package com.vinicius.condominiopro.tipoDependente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "TipoDependente")
@Table(name = "tipo_dependente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "tipoDepend_id")
public class TipoDependente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long tipoDepend_id;

	@Column(name = "nome")
	private String tipoDepend_descricao;

	// GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO

	public long getTipoDepend_id() {
		return tipoDepend_id;
	}

	public void setTipoDepend_id(Integer tipoDepend_id) {
		this.tipoDepend_id = tipoDepend_id;
	}

	public String getTipoDepend_descricao() {
		return tipoDepend_descricao;
	}

	public void setTipoDepend_descricao(String tipoDepend_descricao) {
		this.tipoDepend_descricao = tipoDepend_descricao;
	}

}
