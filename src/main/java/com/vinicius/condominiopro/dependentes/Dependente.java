package com.vinicius.condominiopro.dependentes;

import com.vinicius.condominiopro.condomino.Condomino;
import com.vinicius.condominiopro.tipoDependente.TipoDependente;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Entity(name = "Dependente")
@Table(name = "dependentes")

//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "dependente_id")
public class Dependente {

    public Dependente() {
    }

    public Dependente(TipoDependente tipoDependente) {
        this.tipoDependente = tipoDependente;
    }

    public Dependente(Condomino condomino) {
        this.condomino = condomino;
    }

    public Dependente(String nome, String rg, String telefone_celular, String morador,
                      TipoDependente tipoDependente, Condomino condomino) {
        this.nome = nome;
        this.rg = rg;
        this.telefone_celular = telefone_celular;
        this.morador = morador;
        this.tipoDependente = tipoDependente;
        this.condomino = condomino;
    }

    public Dependente(long dependente_id) {
        this.dependente_id = dependente_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long dependente_id;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone_celular;
    private String morador;

    @ManyToOne
    @JoinColumn(name = "tipo_dependente_id")
    private TipoDependente tipoDependente;

    @ManyToOne
    @JoinColumn(name = "condomino_id")
    private Condomino condomino;
}
