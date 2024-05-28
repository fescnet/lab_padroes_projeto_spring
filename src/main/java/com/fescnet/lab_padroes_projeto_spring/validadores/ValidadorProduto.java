package com.fescnet.lab_padroes_projeto_spring.validadores;

import org.springframework.stereotype.Component;

import com.fescnet.lab_padroes_projeto_spring.exception.ExcecaoDadosInvalidos;
import com.fescnet.lab_padroes_projeto_spring.model.Produto;
import com.fescnet.lab_padroes_projeto_spring.utils.validation.RegraDeValidacao;
import com.fescnet.lab_padroes_projeto_spring.utils.validation.RegraDeValidacaoBuilder;
import com.fescnet.lab_padroes_projeto_spring.utils.validation.ValidadorContext;

/**
 * Classe que valida os dados de um produto
 * Cada entidade teria uma destas
 * Para cada campo inválido, uma exceção é lançada
 * As exceções são tratadas no arquivo
 * src/main/java/com/fescnet/lab_padroes_projeto_spring/exception/TratadorGlobalDeExcecoes.java
 * Uso o padrão Builder para criar as regras de validação
 */
@Component
public class ValidadorProduto {

        private static final RegraDeValidacao REGRA_VALIDACAO_NOME = new RegraDeValidacaoBuilder()
                        .ehObrigatorio().min(2).max(255).build();

        private static final RegraDeValidacao REGRA_VALIDACAO_PRECO = new RegraDeValidacaoBuilder()
                        .ehObrigatorio().min(0.01).max(100000).build();

        private static final RegraDeValidacao REGRA_VALIDACAO_PESO_EM_GRAMAS = new RegraDeValidacaoBuilder()
                        .ehObrigatorio().min(10).max(10000).build();

        private static final RegraDeValidacao REGRA_VALIDACAO_LARGURA_EM_CM = new RegraDeValidacaoBuilder()
                        .ehObrigatorio().min(5).max(200).build();

        private static final RegraDeValidacao REGRA_VALIDACAO_ALTURA_EM_CM = new RegraDeValidacaoBuilder()
                        .ehObrigatorio().min(5).max(200).build();

        private static final RegraDeValidacao REGRA_VALIDACAO_COMPRIMENTO_EM_CM = new RegraDeValidacaoBuilder()
                        .ehObrigatorio().min(5).max(200).build();

        private static final String MENSAGEM_EXCECAO_NOME = "'nome' inválido.  O nome deve ter entre 2 e 255 caracteres e é obrigatório.";
        private static final String MENSAGEM_EXCECAO_PRECO = "'preco' inválido.  O preço deve ser maior ou igual a R$ 0,01 e menor ou igual a R$ 100.000,00 e é obrigatório.";
        private static final String MENSAGEM_EXCECAO_PESO_EM_GRAMAS = "'pesoEmGramas' inválido.  O peso deve ser maior ou igual a 10g e menor ou igual a 10.000g e é obrigatório.";
        private static final String MENSAGEM_EXCECAO_LARGURA_EM_CM = "'larguraEmCm' inválido.  A largura deve ser maior ou igual a 5cm e menor ou igual a 200cm e é obrigatório.";
        private static final String MENSAGEM_EXCECAO_ALTURA_EM_CM = "'alturaEmCm' inválido.  A altura deve ser maior ou igual a 5cm e menor ou igual a 200cm e é obrigatório.";
        private static final String MENSAGEM_EXCECAO_COMPRIMENTO_EM_CM = "'comprimentoEmCm' inválido.  O comprimento deve ser maior ou igual a 5cm e menor ou igual a 200cm e é obrigatório.";

        /**
         * Valida os dados de um produto e lança exceções caso os dados sejam inválidos
         * 
         * @param produto
         */
        public void seNaoEhValidoLancaExcecao(Produto produto) {

                new ValidadorContext(produto.getNome(), REGRA_VALIDACAO_NOME)
                                .seNaoEhValidoLancaExcecao(new ExcecaoDadosInvalidos(MENSAGEM_EXCECAO_NOME));
                new ValidadorContext(produto.getPreco(), REGRA_VALIDACAO_PRECO)
                                .seNaoEhValidoLancaExcecao(new ExcecaoDadosInvalidos(MENSAGEM_EXCECAO_PRECO));
                new ValidadorContext(produto.getPesoEmGramas(), REGRA_VALIDACAO_PESO_EM_GRAMAS)
                                .seNaoEhValidoLancaExcecao(new ExcecaoDadosInvalidos(MENSAGEM_EXCECAO_PESO_EM_GRAMAS));
                new ValidadorContext(produto.getLarguraEmCm(), REGRA_VALIDACAO_LARGURA_EM_CM)
                                .seNaoEhValidoLancaExcecao(new ExcecaoDadosInvalidos(MENSAGEM_EXCECAO_LARGURA_EM_CM));
                new ValidadorContext(produto.getAlturaEmCm(), REGRA_VALIDACAO_ALTURA_EM_CM)
                                .seNaoEhValidoLancaExcecao(new ExcecaoDadosInvalidos(MENSAGEM_EXCECAO_ALTURA_EM_CM));
                new ValidadorContext(produto.getComprimentoEmCm(), REGRA_VALIDACAO_COMPRIMENTO_EM_CM)
                                .seNaoEhValidoLancaExcecao(
                                                new ExcecaoDadosInvalidos(MENSAGEM_EXCECAO_COMPRIMENTO_EM_CM));
        }
}
