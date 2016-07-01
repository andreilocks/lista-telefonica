package com.tecweb.service;

import com.google.common.base.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by andrei on 17/01/16.
 */
@SuppressWarnings("serial")
public abstract class AbstractService<T> implements Serializable {

    @Inject
    protected EntityManager em;

    public T persist(final T entity) {
        return em.merge(entity);
    }

    public Optional<T> remove(final T entity) {
        if (em.contains(entity)) {
            em.remove(entity);
        } else {
            em.remove(em.merge(entity));
        }
        return Optional.absent();
    }

}

