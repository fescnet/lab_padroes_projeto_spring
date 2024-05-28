package com.fescnet.lab_padroes_projeto_spring.utils.validation;

/**
 * Representa uma estratégia de validação para valores do tipo String
 * 
 */
public class ValidadorStringStrategy extends ValidadorStrategy {

    private String valor;

    public ValidadorStringStrategy(String valor, RegraDeValidacao regraDeValidacao) {
        super();
        this.valor = valor;
        this.regra = regraDeValidacao;
    }

    @Override
    public boolean validarObrigatoriedade() {
        if (!precisaValidarObrigatoriedade()) {
            return true;
        }
        return valor != null && !valor.trim().isEmpty();
    }

    /**
     * Retorna o tamanho da string para validação quando é uma String
     * Se fosse um double retornaria o próprio valor
     * Assim consigo reaproveitar o método validarMin e validarMax
     */
    @Override
    public double obterValorParaValidarMin() {
        return valor != null ? valor.length() : 0;
    }

    @Override
    public double obterValorParaValidarMax() {
        return valor != null ? valor.length() : 0;
    }

}
