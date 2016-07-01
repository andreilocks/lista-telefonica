package com.tecweb.dto;

import com.tecweb.enterprise.AbstractRepresentationBuilder;
import com.tecweb.model.Contatos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by andrei on 30/06/16.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ContatosDTO {

    private Long id;
    private String nome;
    private List<ContatosTelefonesDTO> telefones;

    public ContatosDTO() {

    }

    public ContatosDTO(Long id, String nome, List<ContatosTelefonesDTO> telefones) {
        this.id = id;
        this.nome = nome;
        this.telefones = telefones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ContatosTelefonesDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<ContatosTelefonesDTO> telefones) {
        this.telefones = telefones;
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
