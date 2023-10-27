package com.vinicius.api_pro.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "fornecedor")
public class FornecedorEntity {

    public FornecedorEntity() {
    }

    public FornecedorEntity(String nome) {
        this.nome = nome;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Campo nome é obrigatório.")
    private String nome;
    
    @NotBlank(message="Campo cpf/cnpj é obrigatório.")
    private String cpf_cnpj;
    @NotBlank(message="Campo telefone é obrigatório.")
    private String telefone_celular;
    @NotBlank(message="Campo especialidade é obrigatório.")
    private String especialidade;
    @NotBlank(message="Campo rua é obrigatório.")
    private String rua;
    @NotBlank(message="Campo bairro é obrigatório.")
    private String bairro;
    @NotBlank(message="Campo número é obrigatório.")
    private int numero;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private CidadeEntity cidade;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoEntity estado;
}
