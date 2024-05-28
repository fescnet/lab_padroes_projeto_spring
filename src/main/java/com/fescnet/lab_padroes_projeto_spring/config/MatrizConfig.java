package com.fescnet.lab_padroes_projeto_spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Dados de configuração de uma matriz obtidos do arquivo application.properties
 */

@Configuration
@ConfigurationProperties(prefix = "matriz")
public class MatrizConfig extends LojaConfig {

}
