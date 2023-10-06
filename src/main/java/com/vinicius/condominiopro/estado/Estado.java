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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "estado_id")
public class Estado {

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
