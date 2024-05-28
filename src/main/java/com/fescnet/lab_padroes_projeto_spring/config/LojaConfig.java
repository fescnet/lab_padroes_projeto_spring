package com.fescnet.lab_padroes_projeto_spring.config;

import lombok.Getter;
import lombok.Setter;

/**
 * Superclasse para configurações de lojas
 */
public abstract class LojaConfig {
    private @Getter @Setter String cep;
}
