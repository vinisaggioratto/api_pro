
package com.vinicius.api_pro.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "sindico")
public class SindicoEntity {

    public SindicoEntity() {
    }

    public SindicoEntity(String nome) {
        this.nome = nome;
    }
    
    	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

        private Date data_inicial;
	private Date data_final_prevista;
        private Date data_final;
        @NotBlank(message="Campo nome é obrigatório.")
	private String nome;
        @NotBlank(message="Campo ativo é obrigatório.")
	private String ativo;
}
