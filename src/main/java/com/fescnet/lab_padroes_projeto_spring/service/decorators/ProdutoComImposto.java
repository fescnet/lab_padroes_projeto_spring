package com.fescnet.lab_padroes_projeto_spring.service.decorators;

/**
 * Decora o preço de um produto com 10% de impostos
 */
public class ProdutoComImposto extends ItemAVendaDecorator {

    private static final double IMPOSTO = 0.1;

    public ProdutoComImposto(ItemAVenda itemAVenda) {
        super(itemAVenda);
    }

    @Override
    public double getPreco() {
        return itemAVenda.getPreco() * (1 + IMPOSTO);
    }
}
