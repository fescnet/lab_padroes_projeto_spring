package com.fescnet.lab_padroes_projeto_spring.service.decorators;

/**
 * Decorador base
 */
public abstract class ItemAVendaDecorator implements ItemAVenda {

    protected ItemAVenda itemAVenda;

    public ItemAVendaDecorator(ItemAVenda itemAVenda) {
        this.itemAVenda = itemAVenda;
    }

    @Override
    public double getPreco() {
        return itemAVenda.getPreco();
    }
}
