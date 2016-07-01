package com.tecweb.model;

import com.tecweb.enterprise.AbstractBuilder;
import com.tecweb.enterprise.AbstractEntityId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by andrei on 17/01/16.
 */

@Entity
@XmlRootElement
@Table(name = "contatos_telefones", schema = "lista_telefonica")
public class ContatosTelefones implements AbstractEntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contatos_id")
    private Contatos contatos;


    @NotNull(message = "O telefone não pode ser nulo.")
    @Column(name = "telefone")
    private String telefone;

    public ContatosTelefones() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contatos getContatos() {
        return contatos;
    }

    public void setContatos(Contatos contatos) {
        this.contatos = contatos;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static class Builder extends AbstractBuilder<ContatosTelefones, Builder> {

        protected Builder(ContatosTelefones entity) {
            super(entity);
        }

        public static Builder create() {
            return new Builder(new ContatosTelefones());
        }

        public static Builder from(final ContatosTelefones contatosTelefones) {
            return new Builder(contatosTelefones);
        }

        public Builder id(final Long id) {
            entity.setId(id);
            return this;
        }

        public Builder contatos(final Contatos contatos) {
            entity.setContatos(contatos);
            return this;
        }

        public Builder telefone(final String telefone) {
            entity.setTelefone(telefone);
            return this;
        }
    }
}
