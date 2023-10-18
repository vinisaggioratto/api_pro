package com.vinicius.condominiopro.saidaEstoque;

import java.sql.Date;

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

@Entity(name = "SaidaEstoque")
@Table(name = "saida_estoque")
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "saidaEstoque_id")
public class SaidaEstoque {

	public SaidaEstoque() {
	}

	public SaidaEstoque(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "item_estoque_id")
    private ItemEstoque itemEstoque;
	
    private Integer quantidade;
    private Date data_saida;
    
}
