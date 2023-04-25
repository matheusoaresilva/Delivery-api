package com.matheus.fastfoodie.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matheus.fastfoodie.domain.exception.EntidadeEmUsoException;
import com.matheus.fastfoodie.domain.exception.EntidadeNaoEncontradaException;
import com.matheus.fastfoodie.domain.model.Cozinha;
import com.matheus.fastfoodie.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository repository;

	public Cozinha salvar(Cozinha cozinha) {
		return repository.salvar(cozinha);
	}

	public void excluir(Long id) {
		try {
			repository.remover(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com o codigo %d", id));

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de codigo %d não pode ser removida, está em uso", id));
		}

	}

}
