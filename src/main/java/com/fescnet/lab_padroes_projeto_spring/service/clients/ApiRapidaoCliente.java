package com.fescnet.lab_padroes_projeto_spring.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fescnet.lab_padroes_projeto_spring.mock_api_parceiros.dto.RequisicaoCotacaoDeFrete;
import com.fescnet.lab_padroes_projeto_spring.mock_api_parceiros.dto.RespostaCotacaoDeFrete;

/**
 * consulta a API do parceiro
 */
@FeignClient(name = "rapidao", url = "http://localhost:8080/simulacao/parceiro/rapidao")
public interface ApiRapidaoCliente {

    @PostMapping("/frete/cotacao")
    public RespostaCotacaoDeFrete criarCotacaoRapidao(@RequestBody RequisicaoCotacaoDeFrete requisicao);
}