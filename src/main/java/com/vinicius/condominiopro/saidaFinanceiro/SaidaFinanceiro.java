package com.vinicius.condominiopro.saidaFinanceiro;

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

@Entity(name = "SaidaFinanceiro")
@Table(name = "saidas_financeiro")
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "saidaPag_id")
public class SaidaFinanceiro {

    public SaidaFinanceiro() {
    }

    public SaidaFinanceiro(long saidaPag_id) {
        this.saidaPag_id = saidaPag_id;
    }

    public SaidaFinanceiro(Long saidaPag_id, Date data_operacao, Fornecedor fornecedor, Integer nota_fiscal,
                           double valor, String parcelamento, String descricao) {
        this.saidaPag_id = saidaPag_id;
        this.data_operacao = data_operacao;
        this.fornecedor = fornecedor;
        this.nota_fiscal = nota_fiscal;
        this.valor = valor;
        this.parcelamento = parcelamento;
        this.descricao = descricao;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long saidaPag_id;
	
	
    private Date data_operacao;
    
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    
    private Integer nota_fiscal;
    private double valor;
    private String parcelamento; //S/N
    
	@Column(name = "descricao")
    private String descricao;

}
