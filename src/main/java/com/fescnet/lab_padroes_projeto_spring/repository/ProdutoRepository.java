package com.fescnet.lab_padroes_projeto_spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fescnet.lab_padroes_projeto_spring.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    
}
