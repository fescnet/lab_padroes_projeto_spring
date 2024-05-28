package com.fescnet.lab_padroes_projeto_spring.mock_api_parceiros.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * define o formato da requisição para as APIs dos parceiros. Por questões de
 * simplicidade usei o mesmo formato para os 3 parceiros.
 */
public class RequisicaoCotacaoDeFrete {
    private @Getter @Setter String cepOrigem;
    private @Getter @Setter String cepDestino;
    private @Getter @Setter double pesoEmGramas;
    private @Getter @Setter double valorNotaFiscal;
    private @Getter @Setter double larguraEmCm;
    private @Getter @Setter double alturaEmCm;
    private @Getter @Setter double comprimentoEmCm;
}
