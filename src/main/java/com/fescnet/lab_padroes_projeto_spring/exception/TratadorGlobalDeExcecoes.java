package com.fescnet.lab_padroes_projeto_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fescnet.lab_padroes_projeto_spring.dto.RespostaRestParaExcecao;

/**
 * Toda exceção lançada na aplicação vem para cá. Aqui defino o status http para
 * cada tipo.
 */
@RestControllerAdvice
public class TratadorGlobalDeExcecoes {

    @ExceptionHandler(ExcecaoItemNaoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RespostaRestParaExcecao tratarExcecaoItemNaoEncontrado(ExcecaoItemNaoEncontrado ex) {
        return new RespostaRestParaExcecao(ex.getMessage());
    }

    @ExceptionHandler(ExcecaoDadosInvalidos.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaRestParaExcecao tratarExcecaoDadosInvalidos(ExcecaoDadosInvalidos ex) {
        return new RespostaRestParaExcecao(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaRestParaExcecao tratarMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        return new RespostaRestParaExcecao(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RespostaRestParaExcecao tratarErroInesperadoException(Exception ex) {
        return new RespostaRestParaExcecao(ex.getMessage());
    }
}
