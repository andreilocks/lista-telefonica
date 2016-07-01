package com.tecweb.model;

import com.tecweb.enterprise.AbstractEntityId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by andrei on 17/01/16.
 */

@Entity
@XmlRootElement
@Table(name = "contatos", schema = "lista_telefonica")
public class ContatosTelefones implements AbstractEntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O telefone não pode ser nulo.")
    @Column(name = "telefone")
    private String telefone;

    public ContatosTelefones() {
    }


    @Override
    public Long getId() {
        return null;
    }
}
