package com.tecweb.dto;

import com.tecweb.enterprise.AbstractRepresentationBuilder;
import com.tecweb.model.ContatosTelefones;

import javax.inject.Inject;
import javax.persistence.EntityManager;
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

    public static class Builder {

        private Long id;
        private String telefone;

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public Builder telefone(final String telefone) {
            this.telefone = telefone;
            return this;
        }

        public ContatosTelefonesDTO build() {
            return new ContatosTelefonesDTO(id, telefone);
        }

    }


    public static class RepresentationBuilder extends AbstractRepresentationBuilder<ContatosTelefones, ContatosTelefonesDTO, ContatosTelefones.Builder> {

        @Inject
        EntityManager em;

        public static Builder builder() {
            return new Builder();
        }

        public ContatosTelefones fromRepresentation(ContatosTelefonesDTO dto) {
            return fromRepresentation(dto, dto.getId() == null ? ContatosTelefones.Builder.create() : ContatosTelefones.Builder.from(em.find(ContatosTelefones.class, dto.getId())));
        }

        @Override
        public ContatosTelefones fromRepresentation(ContatosTelefonesDTO dto, ContatosTelefones.Builder builder) {
            return builder.id(dto.getId()).telefone(dto.getTelefone()).build();
        }

        @Override
        public ContatosTelefonesDTO toRepresentation(ContatosTelefones contatosTelefones) {
            return builder().id(contatosTelefones.getId()).telefone(contatosTelefones.getTelefone()).build();
        }
    }
}
