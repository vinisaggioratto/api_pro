
package com.vinicius.api_pro.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "apartamento")
public class ApartamentoEntity {

    public ApartamentoEntity() {
    }

    public ApartamentoEntity(Integer numero) {
        this.numero = numero;
    }
    
    
    	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

        
	private Integer numero;
        
	private Integer andar;
        @NotBlank(message="Campo número é obrigatório.")
	private String bloco;
        @NotBlank(message="Campo número é obrigatório.")
	private String status;
}
