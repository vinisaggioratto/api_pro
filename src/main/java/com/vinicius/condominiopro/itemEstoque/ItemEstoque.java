package com.vinicius.condominiopro.itemEstoque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "ItemEstoque")
@Table(name = "item_estoque")
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "itemEstoque_id")
@Getter
@Setter
public class ItemEstoque {
	public ItemEstoque() {
	}

	public ItemEstoque(Long id) {
		this.id = id;
	}

	public ItemEstoque(String descricao) {
		this.descricao = descricao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;

    private String descricao;
    private Integer estoque;

}
