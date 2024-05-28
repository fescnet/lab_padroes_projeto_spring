package com.fescnet.lab_padroes_projeto_spring.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fescnet.lab_padroes_projeto_spring.config.FilialConfig;
import com.fescnet.lab_padroes_projeto_spring.config.MatrizConfig;
import com.fescnet.lab_padroes_projeto_spring.exception.ExcecaoItemNaoEncontrado;
import com.fescnet.lab_padroes_projeto_spring.mock_api_parceiros.dto.RequisicaoCotacaoDeFrete;
import com.fescnet.lab_padroes_projeto_spring.mock_api_parceiros.dto.RespostaCotacaoDeFrete;
import com.fescnet.lab_padroes_projeto_spring.model.Produto;
import com.fescnet.lab_padroes_projeto_spring.repository.ProdutoRepository;
import com.fescnet.lab_padroes_projeto_spring.service.clients.ApiCorreiosCliente;
import com.fescnet.lab_padroes_projeto_spring.service.clients.ApiJetLogCliente;
import com.fescnet.lab_padroes_projeto_spring.service.clients.ApiRapidaoCliente;
import com.fescnet.lab_padroes_projeto_spring.service.decorators.ProdutoComImposto;
import com.fescnet.lab_padroes_projeto_spring.service.interfaces.ProdutoService;
import com.fescnet.lab_padroes_projeto_spring.validadores.ValidadorProduto;

/**
 * Regras de negócio relacionadas ao produto
 * Agora o produto é validado ao ser inserido ou atualizado
 * Se um produto for solicitado e não existir é emitido um erro 404
 */
@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private MatrizConfig matrizConfig;

	@Autowired
	private FilialConfig filialConfig;

	@Autowired
	private ApiCorreiosCliente apiCorreiosCliente;

	@Autowired
	private ApiJetLogCliente apiJetLogCliente;

	@Autowired
	private ApiRapidaoCliente apiRapidaoCliente;

	@Autowired
	private ValidadorProduto validador;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Iterable<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto buscarPorId(Long id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new ExcecaoItemNaoEncontrado("Produto não encontrado."));
	}

	/**
	 * Uso do padrão de projeto Decorator
	 */
	@Override
	public Produto buscarPorIdComImposto(Long id) {
		Produto produto = buscarPorId(id);
		ProdutoComImposto produtoComImposto = new ProdutoComImposto(produto);
		produto.setPreco(produtoComImposto.getPreco());
		return produto;
	}

	/**
	 * Validações usam Builder e Strategy
	 */
	@Override
	public Produto inserir(Produto produto) {
		validador.seNaoEhValidoLancaExcecao(produto);
		produto.setId(null); // maior segurança, evita atualizar registros através do método inserir
		return produtoRepository.save(produto);
	}

	@Override
	public Produto atualizar(Long id, Produto produto) {
		validador.seNaoEhValidoLancaExcecao(produto);
		buscarPorId(id); // lança exceção se não encontrar
		produto.setId(id); // maior segurança
		return produtoRepository.save(produto);
	}

	@Override
	public void deletar(Long id) {
		produtoRepository.deleteById(id);
	}

	/**
	 * Cálculo de frete para o produto
	 * São consultas as APIs de 3 parceiros
	 * Implementação do Padrão de Projeto Facade
	 */
	@Override
	public Iterable<RespostaCotacaoDeFrete> buscarOpcoesDeFreteDoProduto(Produto produto) {

		RequisicaoCotacaoDeFrete requisicao = new RequisicaoCotacaoDeFrete();
		requisicao.setCepOrigem(matrizConfig.getCep());
		requisicao.setCepDestino(filialConfig.getCep());
		requisicao.setValorNotaFiscal(produto.getPreco());
		requisicao.setPesoEmGramas(produto.getPesoEmGramas());
		requisicao.setLarguraEmCm(produto.getLarguraEmCm());
		requisicao.setAlturaEmCm(produto.getAlturaEmCm());
		requisicao.setComprimentoEmCm(produto.getComprimentoEmCm());

		RespostaCotacaoDeFrete respostaCorreios = apiCorreiosCliente.criarCotacaoNosCorreios(requisicao);
		RespostaCotacaoDeFrete respostaJetLog = apiJetLogCliente.criarCotacaoJetLog(requisicao);
		RespostaCotacaoDeFrete respostaRapidao = apiRapidaoCliente.criarCotacaoRapidao(requisicao);

		List<RespostaCotacaoDeFrete> respostas = Arrays.asList(respostaCorreios, respostaJetLog, respostaRapidao);
		return respostas;
	}
}
