package com.vinicius.condominiopro.apartamento;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarApartamento(
        @NotNull
        Long apartamento_id,
        Integer numero,
        Integer andar,
        String bloco,
        String status
) {

}
