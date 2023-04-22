package com.matheus.fastfoodie.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.fastfoodie.domain.model.Restaurante;
import com.matheus.fastfoodie.domain.repository.RestauranteRepository;

@Repository
public class RestauranteImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Restaurante> listar() {
        return entityManager.createQuery("from Restaurante", Restaurante.class)
                .getResultList();
    }

    public Restaurante buscar(Long id) {
        return entityManager.find(Restaurante.class, id);
    }

    @Transactional
    public Restaurante salvar(Restaurante restaurante) {
        return entityManager.merge(restaurante);
    }

    @Transactional
    public void remover(Restaurante restaurante) {
    	restaurante = buscar(restaurante.getId());
        entityManager.remove(restaurante);
    }

}

