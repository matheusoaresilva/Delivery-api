package com.matheus.fastfoodie.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.matheus.fastfoodie.domain.model.Estado;
@Repository
public interface EstadoRepository {
	
	List<Estado> listar();
	Estado buscar(Long id);
	Estado salvar(Estado estado);
	void remover(Estado estado);

}
