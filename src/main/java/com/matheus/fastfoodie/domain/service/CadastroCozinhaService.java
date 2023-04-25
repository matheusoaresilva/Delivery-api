package com.matheus.fastfoodie.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.fastfoodie.domain.model.Cozinha;
import com.matheus.fastfoodie.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
	
	@Autowired
	private CozinhaRepository repository;
	
	public Cozinha salvar(Cozinha cozinha) {
		return repository.salvar(cozinha);
	}

}
