package com.fescnet.lab_padroes_projeto_spring.exception;

/**
 * Exceção retornada quando um item solicitado não é encontrado
 */
public class ExcecaoItemNaoEncontrado extends RuntimeException {

    private static final String MENSAGEM_PADRAO = "Item não encontrado";

    public ExcecaoItemNaoEncontrado() {
        super(MENSAGEM_PADRAO);
    }

    public ExcecaoItemNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}
