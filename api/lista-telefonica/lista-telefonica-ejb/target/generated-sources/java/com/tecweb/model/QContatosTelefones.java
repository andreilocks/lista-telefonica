package com.tecweb.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QContatosTelefones is a Querydsl query type for ContatosTelefones
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QContatosTelefones extends EntityPathBase<ContatosTelefones> {

    private static final long serialVersionUID = -316232772L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QContatosTelefones contatosTelefones = new QContatosTelefones("contatosTelefones");

    public final QContatos contatos;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath telefone = createString("telefone");

    public QContatosTelefones(String variable) {
        this(ContatosTelefones.class, forVariable(variable), INITS);
    }

    public QContatosTelefones(Path<? extends ContatosTelefones> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QContatosTelefones(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QContatosTelefones(PathMetadata<?> metadata, PathInits inits) {
        this(ContatosTelefones.class, metadata, inits);
    }

    public QContatosTelefones(Class<? extends ContatosTelefones> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.contatos = inits.isInitialized("contatos") ? new QContatos(forProperty("contatos")) : null;
    }

}

