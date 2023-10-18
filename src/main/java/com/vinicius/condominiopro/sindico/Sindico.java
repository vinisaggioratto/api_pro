package com.vinicius.condominiopro.sindico;

import java.sql.Date;

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

@Entity(name = "Sindico")
@Table(name = "sindico")
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "aviso_id")
public class Sindico {

	public Sindico() {
	}

	public Sindico(Long sindico_id) {
		this.sindico_id = sindico_id;
	}

	public Sindico(String nome) {
		this.nome = nome;
	}

	public Sindico(Long sindico_id, Date data_inicial, Date data_final_prevista, Date data_final,
				   String nome, String ativo) {
		this.sindico_id = sindico_id;
		this.data_inicial = data_inicial;
		this.data_final_prevista = data_final_prevista;
		this.data_final = data_final;
		this.nome = nome;
		this.ativo = ativo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long sindico_id;
	private Date data_inicial;
	private Date data_final_prevista;
	private Date data_final;
	private String nome;
	private String ativo;
}
