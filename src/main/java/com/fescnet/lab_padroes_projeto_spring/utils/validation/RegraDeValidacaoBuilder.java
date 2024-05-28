package com.fescnet.lab_padroes_projeto_spring.utils.validation;

import java.util.Optional;

/**
 * Aplica o padrão Builder para a criação de regras de validação
 * 
 */
public class RegraDeValidacaoBuilder {

    Optional<Boolean> ehObrigatorio;
    Optional<Double> min;
    Optional<Double> max;

    public RegraDeValidacaoBuilder ehObrigatorio() {
        this.ehObrigatorio = Optional.of(true);
        return this;
    }

    public RegraDeValidacaoBuilder min(double min) {
        this.min = Optional.of(min);
        return this;

    }

    public RegraDeValidacaoBuilder max(double max) {
        this.max = Optional.of(max);
        return this;
    }

    public RegraDeValidacao build() {
        return new RegraDeValidacao(this);
    }

}