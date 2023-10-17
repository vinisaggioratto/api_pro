package com.vinicius.condominiopro.manutencao;

import java.sql.Date;

import com.vinicius.condominiopro.fornecedor.Fornecedor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "Manutencao")
@Table(name = "manutencoes")
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "manutencao_id")
public class Manutencao {

	public Manutencao() {
	}

	public Manutencao(Long manutencao_id) {
		this.manutencao_id = manutencao_id;
	}

	public Manutencao(Long manutencao_id, String manutencao_nome, String manutencao_descricao, Double valor,
					  Date data_inicial, Date data_final, Fornecedor fornecedor) {
		this.manutencao_id = manutencao_id;
		this.manutencao_nome = manutencao_nome;
		this.manutencao_descricao = manutencao_descricao;
		this.valor = valor;
		this.data_inicial = data_inicial;
		this.data_final = data_final;
		this.fornecedor = fornecedor;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long manutencao_id;
    
	@Column(name = "nome")
    private String manutencao_nome;
	
	@Column(name = "descricao")
    private String manutencao_descricao;
	
    private Double valor;
    private Date data_inicial;
    private Date data_final;
    
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

}
