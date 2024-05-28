package com.fescnet.lab_padroes_projeto_spring.utils.validation;

import java.util.Optional;

import lombok.Getter;

/**
 * Representa as características de uma regra de validação
 */
public class RegraDeValidacao {
    private @Getter Optional<Boolean> ehObrigatorio;
    private @Getter Optional<Double> min;
    private @Getter Optional<Double> max;

    public RegraDeValidacao(RegraDeValidacaoBuilder builder) {
        this.ehObrigatorio = builder.ehObrigatorio;
        this.min = builder.min;
        this.max = builder.max;
    }
}