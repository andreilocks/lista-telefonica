package com.tecweb.model;

import com.tecweb.enterprise.AbstractBuilder;
import com.tecweb.enterprise.AbstractEntityId;
import com.tecweb.utils.CollectionsBuilder;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by andrei on 17/01/16.
 */

@Entity
@XmlRootElement
@Table(name = "contatos", schema = "lista_telefonica")
public class Contatos implements AbstractEntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo.")
    @Column(name = "nome")
    private String nome;

    @Email(message = "Email inválido")
    @NotNull(message = "O email não pode ser nulo.")
    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContatosTelefones> telefones = CollectionsBuilder.createDefaultArrayList();

    public Contatos() {
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

    public List<ContatosTelefones> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<ContatosTelefones> telefones) {
        this.telefones = telefones;
    }

    @Override
    public Long getId() {
        return id;
    }

    public static class Builder extends AbstractBuilder<Contatos, Builder> {

        protected Builder(Contatos entity) {
            super(entity);
        }

        public static Builder create() {
            return new Builder(new Contatos());
        }

        public static Builder from(final Contatos contatos) {
            return new Builder(contatos);
        }

        public Builder id(final Long id) {
            entity.setId(id);
            return this;
        }

        public Builder nome(final String nome) {
            entity.setNome(nome);
            return this;
        }

        public Builder email(final String email) {
            entity.setEmail(email);
            return this;
        }

        public Builder telefones(final List<ContatosTelefones> telefones) {
            entity.setTelefones(telefones);
            return this;
        }
    }

}
