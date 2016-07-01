package com.tecweb.resources;

import com.tecweb.dto.ContatosDTO;
import com.tecweb.model.Contatos;
import com.tecweb.repository.ContatosRepository;
import com.tecweb.service.ContatosService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

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

    @Inject
    ContatosDTO.RepresentationBuilder builder;

    @GET
    public Response get() {
        return Response.ok().entity(builder.toRepresentation(contatosRepository.findAll())).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        return Response.ok().entity(builder.toRepresentation(contatosRepository.findByOrElseThrow(id))).build();
    }

    @POST
    public Response post(ContatosDTO contato) {
        Contatos contatoAdd = contatosService.persist(builder.fromRepresentation(contato, Contatos.Builder.create()));
        return Response.ok().entity(builder.toRepresentation(contatoAdd)).build();
    }

    @PUT
    @Path("{id}")
    public Response put(@PathParam("id") Long id, ContatosDTO contato) {
        Contatos contatoAdd = contatosService.persist(builder.fromRepresentation(contato, Contatos.Builder.from(contatosRepository.findByOrElseThrow(id))));
        return Response.ok().entity(builder.toRepresentation(contatoAdd)).build();
    }
}
