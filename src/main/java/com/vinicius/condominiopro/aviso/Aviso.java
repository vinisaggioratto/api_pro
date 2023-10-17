package com.vinicius.condominiopro.aviso;

import java.sql.Date;

import com.vinicius.condominiopro.sindico.Sindico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "Aviso")
@Table(name = "avisos")
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "aviso_id")
public class Aviso {

    public Aviso() {
    }

    public Aviso(Long id) {
        this.id = id;
    }

    public Aviso(Long id, String nome, String descricao, Date data_aviso, Sindico sindico) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data_aviso = data_aviso;
        this.sindico = sindico;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "nome")
    private String nome;
	
	@Column(name = "descricao")
    private String descricao;
	
    private Date data_aviso;
    
    @ManyToOne
    @JoinColumn(name = "sindico_id")
    private Sindico sindico;
}
