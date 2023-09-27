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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "CondominoApartamento")
@Table(name = "apartamento_condomino")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "apartamento_id")
public class CondominoApartamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "condomino_id")
	private Condomino condomino;

	@ManyToOne
	@JoinColumn(name = "apartamento_id")
	private Apartamento apartamento;

	private Date data_entrada;
	private Date data_saida;

	// GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	public Date getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

}
