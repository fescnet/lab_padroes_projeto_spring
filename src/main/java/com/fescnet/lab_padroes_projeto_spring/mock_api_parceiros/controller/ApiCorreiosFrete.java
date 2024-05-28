package com.fescnet.lab_padroes_projeto_spring.mock_api_parceiros.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fescnet.lab_padroes_projeto_spring.mock_api_parceiros.dto.RequisicaoCotacaoDeFrete;
import com.fescnet.lab_padroes_projeto_spring.mock_api_parceiros.dto.RespostaCotacaoDeFrete;

/**
 * Aqui faço a simulação de uma API para criação de cotações de frete. Este
 * código não faria parte do sistema se fosse um projeto real.
 */
@RestController
@RequestMapping("simulacao/parceiro/correios/frete")
public class ApiCorreiosFrete {

    @PostMapping("cotacao")
    public ResponseEntity<RespostaCotacaoDeFrete> inserirCotacao(@RequestBody RequisicaoCotacaoDeFrete requisicao) {
        RespostaCotacaoDeFrete resposta = new RespostaCotacaoDeFrete(10.0, "5 dias", "123456", "Correios");
        return ResponseEntity.ok(resposta);
    }

}
