package com.vinicius.condominiopro.pais;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.pl.PESEL;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Pais")
@Table(name = "pais")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "pais_id")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long pais_id;
	
	@Column(name = "nome")
    private String nome;

	@ManyToMany
	public List<Pais> paisList = new ArrayList<>();
}
