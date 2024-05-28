package com.fescnet.lab_padroes_projeto_spring.utils.validation;

/**
 * Representa uma estratégia de validação para valores do tipo double
 * 
 */
public class ValidadorDoubleStrategy extends ValidadorStrategy {

    private double valor;

    public ValidadorDoubleStrategy(double valor, RegraDeValidacao regraDeValidacao) {
        super();
        this.valor = valor;
        this.regra = regraDeValidacao;
    }

    @Override
    public boolean validarObrigatoriedade() {
        if (!precisaValidarObrigatoriedade()) {
            return true;
        }
        return valor != 0;
    }

    /**
     * Retorna o valor para validação do mínimo
     * 
     */
    @Override
    public double obterValorParaValidarMin() {
        return valor;
    }

    /**
     * Retorna o valor para validação do máximo
     */
    @Override
    public double obterValorParaValidarMax() {
        return valor;
    }

}
