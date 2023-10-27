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

@Data
@Entity
@Table(name = "apartamento_condomino")
public class CondominoApartamentoEntity {

    public CondominoApartamentoEntity() {
    }

    public CondominoApartamentoEntity(CondominoEntity condomino, ApartamentoEntity apartamento) {
        this.condomino = condomino;
        this.apartamento = apartamento;
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "condomino_id")
    private CondominoEntity condomino;

    @ManyToOne
    @JoinColumn(name = "apartamento_id")
    private ApartamentoEntity apartamento;

    private Date data_entrada;

    private Date data_saida;
}
