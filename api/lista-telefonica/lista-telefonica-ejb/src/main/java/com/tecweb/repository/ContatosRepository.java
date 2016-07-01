package com.tecweb.repository;

import com.tecweb.model.Contatos;
import com.tecweb.model.QContatos;

/**
 * Created by andrei on 30/06/16.
 */
public class ContatosRepository extends AbstractRepository<Contatos, QContatos> {

    public ContatosRepository(QContatos entityPath) {
        super(entityPath);
    }
}
