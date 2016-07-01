package com.tecweb.enterprise;

import com.tecweb.resources.ContatosResource;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/")
public class ApiResource {

    @Inject
    private ContatosResource contatosResource;

    @Path("contatos")
    public ContatosResource contatosResource() {
        return contatosResource;
    }
}
