package com.fescnet.lab_padroes_projeto_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fescnet.lab_padroes_projeto_spring.mock_api_parceiros.dto.RespostaCotacaoDeFrete;
import com.fescnet.lab_padroes_projeto_spring.model.Produto;
import com.fescnet.lab_padroes_projeto_spring.service.interfaces.ProdutoService;

/**
 * Controlador REST para produtos
 */

@RestController
@RequestMapping("produtos")
public class ProdutoRestController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<Iterable<Produto>> buscarTodos() {
		return ResponseEntity.ok(produtoService.buscarTodos());
	}

	/**
	 * Busca um produto por id. Se incluirImpostos for true, inclui os impostos no
	 * valor do produto.
	 * 
	 * @param id              id do produto
	 * @param incluirImpostos se deve incluir impostos
	 * @return produto
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id,
			@RequestParam(defaultValue = "false") boolean incluirImpostos) {
		if (incluirImpostos) {
			return ResponseEntity.ok(produtoService.buscarPorIdComImposto(id));
		}
		return ResponseEntity.ok(produtoService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Produto> inserir(@RequestBody Produto produto) {
		return ResponseEntity.ok(produtoService.inserir(produto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		return ResponseEntity.ok(produtoService.atualizar(id, produto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		produtoService.deletar(id);
		return ResponseEntity.ok().build();
	}

	/**
	 * Busca as opções de frete para um produto.
	 * 
	 * @param id id do produto
	 * @return opções de frete
	 */
	@GetMapping("/{id}/fretes")
	public ResponseEntity<Iterable<RespostaCotacaoDeFrete>> buscarOpcoesDeFreteDoProduto(@PathVariable Long id) {
		Produto produto = produtoService.buscarPorId(id);
		return ResponseEntity.ok(produtoService.buscarOpcoesDeFreteDoProduto(produto));

	}
}
