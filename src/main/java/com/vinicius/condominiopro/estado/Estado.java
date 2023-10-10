package com.vinicius.condominiopro.estado;

import com.vinicius.condominiopro.pais.Pais;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "Estado")
@Table(name = "estado")
@Getter
@Setter
@EqualsAndHashCode(of = "estado_id")
public class Estado {

	public Estado() {
	}

	public Estado(Long estado_id) {
		this.estado_id = estado_id;
	}

	public Estado(String nome) {
		this.nome = nome;
	}

	public Estado(Long estado_id, String nome, Pais pais) {
		this.estado_id = estado_id;
		this.nome = nome;
		this.pais = pais;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long estado_id;
	
	@Column(name = "nome")
    private String nome;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
    private Pais pais;
}
