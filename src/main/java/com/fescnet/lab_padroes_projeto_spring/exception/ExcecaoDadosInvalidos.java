package com.fescnet.lab_padroes_projeto_spring.exception;

/**
 * Exceção retornada quando são enviados dados inválidos em uma requisição
 */
public class ExcecaoDadosInvalidos extends RuntimeException {

    private static final String MENSAGEM_PADRAO = "Forem encontrados dados inválidos em usa requisição";

    public ExcecaoDadosInvalidos() {
        super(MENSAGEM_PADRAO);
    }

    public ExcecaoDadosInvalidos(String mensagem) {
        super(mensagem);
    }
}
