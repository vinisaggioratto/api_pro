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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Estado")
@Table(name = "estado")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "estado_id")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long estado_id;
	
	@Column(name = "nome")
    private String estado_nome;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
    private Pais pais;
	
	
	//GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO

	public long getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(int estado_id) {
		this.estado_id = estado_id;
	}

	public String getEstado_nome() {
		return estado_nome;
	}

	public void setEstado_nome(String estado_nome) {
		this.estado_nome = estado_nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}
