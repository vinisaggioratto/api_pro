package com.vinicius.condominiopro.ocorrencia;

import java.sql.Date;

import com.vinicius.condominiopro.condomino.Condomino;
import com.vinicius.condominiopro.sindico.Sindico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "Ocorrencia")
@Table(name = "ocorrencias")
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "ocorrencia_id")
public class Ocorrencia {

	public Ocorrencia() {
	}

	public Ocorrencia(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
    private String nome;
	
    private String descricao;
	
    private Date data_ocorrencia;
    
	@ManyToOne
	@JoinColumn(name = "sindico_id")
    private Sindico sindico;
	
	@ManyToOne
	@JoinColumn(name = "condomino_id")
    private Condomino condomino;

}
