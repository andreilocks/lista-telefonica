package com.tecweb.resources;

import com.tecweb.repository.ContatosRepository;
import com.tecweb.service.ContatosService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by andrei on 30/06/16.
 */

@Stateless
@Produces({APPLICATION_JSON})
@Consumes({APPLICATION_JSON})
public class ContatosResource {

    @Inject
    ContatosRepository contatosRepository;

    @Inject
    ContatosService contatosService;

}
