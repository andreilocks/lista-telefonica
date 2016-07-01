package com.tecweb.dto;

import com.tecweb.enterprise.AbstractRepresentationBuilder;
import com.tecweb.model.Contatos;
import com.tecweb.model.ContatosTelefones;
import com.tecweb.utils.CollectionsBuilder;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by andrei on 30/06/16.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ContatosDTO {

    private Long id;
    private String nome;
    private String email;
    private List<ContatosTelefonesDTO> telefones;

    public ContatosDTO() {

    }

    public ContatosDTO(Long id, String nome, String email, List<ContatosTelefonesDTO> telefones) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ContatosTelefonesDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<ContatosTelefonesDTO> telefones) {
        this.telefones = telefones;
    }

    public static class Builder {
        private Long id;
        private String nome;
        private String email;
        private List<ContatosTelefonesDTO> telefones;


        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder telefones(final List<ContatosTelefonesDTO> telefones) {
            this.telefones = telefones;
            return this;
        }

        public ContatosDTO build() {
            return new ContatosDTO(id, nome, email, telefones);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Contatos, ContatosDTO, Contatos.Builder> {

        @Inject
        ContatosTelefonesDTO.RepresentationBuilder telefonesBuilder;

        public static Builder builder() {
            return new Builder();
        }

        @Override
        public Contatos fromRepresentation(ContatosDTO dto, Contatos.Builder builder) {
            List<ContatosTelefones> telefones = CollectionsBuilder.createDefaultArrayList();
            if (dto.getTelefones() != null) {
                telefones = dto.getTelefones().stream().map(telefone -> telefonesBuilder.fromRepresentation(telefone)).collect(Collectors.toList());
            }
            Contatos contatos = builder.id(dto.getId()).nome(dto.getNome()).telefones(telefones).email(dto.getEmail()).build();
            contatos.getTelefones().stream().forEach(telefone -> telefone.setContatos(contatos));
            return contatos;
        }

        @Override
        public ContatosDTO toRepresentation(Contatos contatos) {
            List<ContatosTelefonesDTO> telefonesDTOs = Collections.emptyList();
            if (contatos.getTelefones() != null) {
                telefonesDTOs = contatos.getTelefones().stream().map(telefone -> telefonesBuilder.toRepresentation(telefone)).collect(Collectors.toList());
            }
            return builder().id(contatos.getId()).nome(contatos.getNome()).email(contatos.getEmail()).telefones(telefonesDTOs).build();
        }
    }
}
