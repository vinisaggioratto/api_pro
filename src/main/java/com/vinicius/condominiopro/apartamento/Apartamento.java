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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "apartamento_id")
public class Apartamento {

	public Apartamento(DadosCadastrarApartamento dados) {
		this.numero = dados.numero();
		this.andar = dados.andar();
		this.bloco = dados.bloco();
		this.status = dados.status();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long apartamento_id;

	private Integer numero;
	private Integer andar;
	private String bloco;
	private String status;

	public void atualizar(@Valid DadosAtualizarApartamento dados) {

		if(dados.numero() != null){
			this.numero = dados.numero();
			this.andar = dados.andar();
			this.bloco = dados.bloco();
			this.status = dados.status();
		}
	}
}
