package com.vinicius.api_pro.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "apartamento_condomino")
public class CondominoApartamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Campo condômino é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "condomino_id")
    private CondominoEntity condomino;

    @NotBlank(message = "Campo apartamento é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "apartamento_id")
    private ApartamentoEntity apartamento;

    @NotBlank(message = "Campo data de entrada é obrigatório.")
    private Date data_entrada;
    
    @NotBlank(message = "Campo data de saída é obrigatório.")
    private Date data_saida;
}
