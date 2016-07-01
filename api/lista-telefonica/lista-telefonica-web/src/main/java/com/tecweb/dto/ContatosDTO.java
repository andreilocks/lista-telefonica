package com.tecweb.dto;

import com.tecweb.enterprise.AbstractRepresentationBuilder;
import com.tecweb.model.Contatos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by andrei on 30/06/16.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ContatosDTO {

    public ContatosDTO() {

    }

    public static class Builder {

    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Contatos, ContatosDTO, Contatos.Builder> {

        public static Builder builder() {
            return new Builder();
        }


        @Override
        protected Contatos fromRepresentation(ContatosDTO dto, Contatos.Builder builder) {
            return null;
        }

        @Override
        protected ContatosDTO toRepresentation(Contatos contatos) {
            return null;
        }
    }
}
