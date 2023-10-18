package com.vinicius.condominiopro.apartamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.*;

@Entity(name = "Apartamento")
@Table(name = "apartamento")
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "apartamento_id")
public class Apartamento {

	public Apartamento() {
	}

	public Apartamento(Long apartamento_id) {
		this.apartamento_id = apartamento_id;
	}

	public Apartamento(Integer numero) {
		this.numero = numero;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long apartamento_id;

	private Integer numero;
	private Integer andar;
	private String bloco;
	private String status;

}
