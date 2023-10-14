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
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "recebCond_id")
public class EntradaFinanceiro {

	public EntradaFinanceiro() {
	}

	public EntradaFinanceiro(long recebCond_id) {
		this.recebCond_id = recebCond_id;
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
    private String descricao;
}
