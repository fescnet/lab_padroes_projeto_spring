package com.fescnet.lab_padroes_projeto_spring.service.interfaces;

import com.fescnet.lab_padroes_projeto_spring.mock_api_parceiros.dto.RespostaCotacaoDeFrete;
import com.fescnet.lab_padroes_projeto_spring.model.Produto;

public interface ProdutoService {
    public Produto buscarPorId(Long id);

    public Iterable<Produto> buscarTodos();

    public Produto inserir(Produto produto);

    public void deletar(Long id);

    public Produto atualizar(Long id, Produto produto);

    public Iterable<RespostaCotacaoDeFrete> buscarOpcoesDeFreteDoProduto(Produto produto);

    public Produto buscarPorIdComImposto(Long id);
}
