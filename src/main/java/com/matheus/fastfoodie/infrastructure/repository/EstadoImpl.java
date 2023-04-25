package com.matheus.fastfoodie.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.fastfoodie.domain.model.Estado;
import com.matheus.fastfoodie.domain.repository.EstadoRepository;

@Repository
public class EstadoImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Estado> listar() {
        return entityManager.createQuery("from Estado", Estado.class)
                .getResultList();
    }

    public Estado buscar(Long id) {
        return entityManager.find(Estado.class, id);
    }

    @Transactional
    public Estado salvar(Estado estado) {
        return entityManager.merge(estado);
    }

    @Transactional
    public void remover(Estado estado) {
    	estado = buscar(estado.getId());
        entityManager.remove(estado);
    }

}

