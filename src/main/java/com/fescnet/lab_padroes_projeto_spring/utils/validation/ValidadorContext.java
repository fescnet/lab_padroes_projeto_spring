package com.fescnet.lab_padroes_projeto_spring.utils.validation;

/**
 * Validador de valores
 * Apliquei o padrão Strategy para permitir a validação de diferentes tipos de
 * valores
 * No momento é possível validar valores do tipo double e String
 * Esta classe é responsável por delegar a validação para a classe correta
 */
public class ValidadorContext {

    private ValidadorStrategy validador;

    public ValidadorContext(int valor, RegraDeValidacao regraDeValidacao) {
        this.validador = new ValidadorDoubleStrategy(valor, regraDeValidacao);
    }

    public ValidadorContext(double valor, RegraDeValidacao regraDeValidacao) {
        this.validador = new ValidadorDoubleStrategy(valor, regraDeValidacao);
    }

    public ValidadorContext(String valor, RegraDeValidacao regraDeValidacao) {
        this.validador = new ValidadorStringStrategy(valor, regraDeValidacao);
    }

    public boolean ehValido() {
        return validador.ehValido();
    }

    public void seNaoEhValidoLancaExcecao(RuntimeException excecao) {
        validador.seNaoEhValidoLancaExcecao(excecao);
    }
}
