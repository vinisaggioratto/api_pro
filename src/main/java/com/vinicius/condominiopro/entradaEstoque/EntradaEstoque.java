package com.vinicius.condominiopro.entradaEstoque;

import java.sql.Date;

import com.vinicius.condominiopro.fornecedor.Fornecedor;
import com.vinicius.condominiopro.itemEstoque.ItemEstoque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "EntradaEstoque")
@Table(name = "entrada_estoque")
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "entradaEstoque_id")
public class EntradaEstoque {

	public EntradaEstoque() {
	}

	public EntradaEstoque(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;

    private String nome;
    private Integer quantidade;
    private double valor_unitario;
    private Date data_entrada;

	@ManyToOne
	@JoinColumn(name = "item_estoque_id")
	private ItemEstoque itemEstoque;

	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
}
