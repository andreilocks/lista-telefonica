package com.tecweb.dto;

import com.tecweb.enterprise.AbstractRepresentationBuilder;
import com.tecweb.model.ContatosTelefones;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by andrei on 30/06/16.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ContatosTelefonesDTO {

    private Long id;
    private String telefone;

    public ContatosTelefonesDTO() {

    }

    public static class Builder {

    }

    public ContatosTelefonesDTO(Long id, String telefone) {
        this.id = id;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<ContatosTelefones, ContatosTelefonesDTO, ContatosTelefones.Builder> {

        public static Builder builder() {
            return new Builder();
        }


        @Override
        protected ContatosTelefones fromRepresentation(ContatosTelefonesDTO dto, ContatosTelefones.Builder builder) {
            return null;
        }

        @Override
        protected ContatosTelefonesDTO toRepresentation(ContatosTelefones contatosTelefones) {
            return null;
        }
    }
}
