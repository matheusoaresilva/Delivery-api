package com.matheus.fastfoodie.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.matheus.fastfoodie.domain.model.Cozinha;
@Repository
public interface CozinhaRepository {
	
	List<Cozinha> listar();
	Cozinha buscar(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Long id);

}
