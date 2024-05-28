package com.fescnet.lab_padroes_projeto_spring.model;

import com.fescnet.lab_padroes_projeto_spring.service.decorators.ItemAVenda;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GenerationType;

/**
 * O modelo Produto implementa a interface ItemAVenda para que siga o padrão
 * Decorator usado em
 * src/main/java/com/fescnet/lab_padroes_projeto_spring/service/decorators
 */
@Entity
public class Produto implements ItemAVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter Long id;
    private @Getter @Setter String nome;
    private @Setter double preco;
    private @Getter @Setter double pesoEmGramas;
    private @Getter @Setter double larguraEmCm;
    private @Getter @Setter double alturaEmCm;
    private @Getter @Setter double comprimentoEmCm;

    /**
     * O Decorator vai decorar este método
     */
    @Override
    public double getPreco() {
        return preco;
    }
}
