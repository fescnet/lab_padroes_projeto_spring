package com.fescnet.lab_padroes_projeto_spring.mock_api_parceiros.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Resposta recebida das cotações de frete solicitadas nas APIs dos parceiros. O
 * formato é o mesmo para as 3 empresas por questão de simplicidade no
 * exercício.
 */
public class RespostaCotacaoDeFrete {
    private @Getter @Setter double valorFrete;
    private @Getter @Setter String prazoEntrega;
    private @Getter @Setter String codigoCotacaoGerada;
    private @Getter @Setter String parceiro;

    public RespostaCotacaoDeFrete(double valorFrete, String prazoEntrega, String codigoCotacaoGerada, String parceiro) {
        this.valorFrete = valorFrete;
        this.prazoEntrega = prazoEntrega;
        this.codigoCotacaoGerada = codigoCotacaoGerada;
        this.parceiro = parceiro;
    }
}
