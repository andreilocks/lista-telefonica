package com.tecweb.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QContatos is a Querydsl query type for Contatos
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QContatos extends EntityPathBase<Contatos> {

    private static final long serialVersionUID = 1691571597L;

    public static final QContatos contatos = new QContatos("contatos");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final ListPath<ContatosTelefones, QContatosTelefones> telefones = this.<ContatosTelefones, QContatosTelefones>createList("telefones", ContatosTelefones.class, QContatosTelefones.class, PathInits.DIRECT2);

    public QContatos(String variable) {
        super(Contatos.class, forVariable(variable));
    }

    public QContatos(Path<? extends Contatos> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContatos(PathMetadata<?> metadata) {
        super(Contatos.class, metadata);
    }

}

