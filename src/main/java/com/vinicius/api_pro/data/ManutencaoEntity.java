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
@Table(name = "manutencoes")
public class ManutencaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;
    @NotBlank(message = "Campo descrição é obrigatório.")
    private String descricao;
    @NotBlank(message = "Campo valor é obrigatório.")
    private Double valor;
    @NotBlank(message = "Campo data inicial é obrigatório.")
    private Date data_inicial;
    @NotBlank(message = "Campo data final é obrigatório.")
    private Date data_final;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private FornecedorEntity fornecedor;
}
