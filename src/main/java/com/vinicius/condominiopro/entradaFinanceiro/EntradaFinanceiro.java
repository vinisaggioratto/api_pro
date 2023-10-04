package com.vinicius.condominiopro.entradaFinanceiro;

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

@Entity(name = "EntradaFinanceiro")
@Table(name = "entrada_financeiro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "recebCond_id")
public class EntradaFinanceiro {

	public EntradaFinanceiro(DadosCadastrarEntradaFinanceiro dados) {
		super();
		this.data_operacao = dados.data_operacao();
		this.condomino = dados.condomino();
		this.valor = dados.valor();
		this.parcelamento = dados.parcelamento();
		this.recebCond_descricao = dados.recebCond_descricao();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long recebCond_id;
    
    private Date data_operacao;
    
	@ManyToOne
	@JoinColumn(name = "condomino_id")
    private Condomino condomino;

	@Column(name = "valor")
    private double valor;
    private String parcelamento;
    
	@Column(name = "descricao")
    private String recebCond_descricao;
	

}
