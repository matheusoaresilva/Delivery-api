package com.matheus.fastfoodie.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.matheus.fastfoodie.domain.model.Cidade;
@Repository
public interface CidadeRepository {
	
	List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Cidade cidade);

}
