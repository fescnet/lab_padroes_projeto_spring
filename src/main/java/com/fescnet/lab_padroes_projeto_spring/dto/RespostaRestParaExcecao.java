package com.fescnet.lab_padroes_projeto_spring.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Quando ocorre uma exceção, retorno um objeto desta classe
 */
public class RespostaRestParaExcecao {
    private @Getter @Setter String mensagem;

    private static final String MENSAGEM_PADRAO = "Erro inesperado";

    public RespostaRestParaExcecao(String mensagem) {
        this.mensagem = mensagem == null ? MENSAGEM_PADRAO : mensagem;
    }
}