package com.vinicius.condominiopro.licenca;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "Licenca")
@Table(name = "licencas")
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "licenca_id")
public class Licenca {

    public Licenca() {
    }

    public Licenca(Long licenca_id) {
        this.licenca_id = licenca_id;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long licenca_id;
	
	@Column(name = "nome")
    private String nome;
	
	@Column(name = "descricao")
    private String descricao;
	
    private String numero;
    private String emissor;
    private Date data_emissao;
    private Date data_validade;
    private String valido;

}
