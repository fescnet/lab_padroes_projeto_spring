package com.fescnet.lab_padroes_projeto_spring.utils.validation;

public abstract class ValidadorStrategy {

    protected RegraDeValidacao regra;

    public boolean ehValido() {
        return validarObrigatoriedade() && validarMin() && validarMax();
    }

    protected boolean validarMin() {
        if (!precisaValidarMin()) {
            return true;
        }
        return obterValorParaValidarMin() >= regra.getMin().get();
    }

    protected boolean validarMax() {
        if (!precisaValidarMax()) {
            return true;
        }
        return obterValorParaValidarMax() <= regra.getMax().get();
    }

    protected boolean precisaValidarMin() {
        return regra.getMin() != null;
    }

    protected boolean precisaValidarMax() {
        return regra.getMax() != null;
    }

    protected boolean precisaValidarObrigatoriedade() {
        return regra.getEhObrigatorio() != null && !regra.getEhObrigatorio().isEmpty();
    }

    /**
     * Faz a validaçao e lança uma exceção caso o dado não seja válido
     * 
     * @param excecao exceção a ser lançada
     */
    public void seNaoEhValidoLancaExcecao(RuntimeException excecao) {
        RuntimeException excecaoAux = excecao != null ? excecao
                : new RuntimeException("Defina uma exceção para lançar.");
        if (!ehValido()) {
            throw excecaoAux;
        }
    }

    protected abstract boolean validarObrigatoriedade();

    /**
     * Retorna o valor a ser validado para o min
     * Para String retorna o tamanho da string
     * Para double retorna o próprio valor
     * 
     * @return
     */
    protected abstract double obterValorParaValidarMin();

    /**
     * Retorna o valor a ser validado para o max
     * Para String retorna o tamanho da string
     * Para double retorna o próprio valor
     * 
     * @return
     */
    protected abstract double obterValorParaValidarMax();
}
