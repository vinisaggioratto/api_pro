package com.vinicius.condominiopro.tipoDependente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "TipoDependente")
@Table(name = "tipo_dependente")
@Getter
@Setter
@EqualsAndHashCode(of = "tipoDepend_id")
public class TipoDependente {

	public TipoDependente() {
	}

	public TipoDependente(String descricao) {
		this.descricao = descricao;
	}

	public TipoDependente(Long tipoDepend_id) {
		this.tipoDepend_id = tipoDepend_id;
	}

	public TipoDependente(Long tipoDepend_id, String descricao) {
		this.tipoDepend_id = tipoDepend_id;
		this.descricao = descricao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long tipoDepend_id;
	private String descricao;
}
