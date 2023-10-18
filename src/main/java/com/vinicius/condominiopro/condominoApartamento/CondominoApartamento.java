package com.vinicius.condominiopro.condominoApartamento;

import java.sql.Date;

import com.vinicius.condominiopro.apartamento.Apartamento;
import com.vinicius.condominiopro.condomino.Condomino;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "CondominoApartamento")
@Table(name = "apartamento_condomino")
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "apartamento_id")
public class CondominoApartamento {

	public CondominoApartamento() {
	}

	public CondominoApartamento(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "condomino_id")
	private Condomino condomino;

	@ManyToOne
	@JoinColumn(name = "apartamento_id")
	private Apartamento apartamento;

	private Date data_entrada;
	private Date data_saida;

}
