package com.tecweb.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QContatosTelefones is a Querydsl query type for ContatosTelefones
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QContatosTelefones extends EntityPathBase<ContatosTelefones> {

    private static final long serialVersionUID = -316232772L;

    public static final QContatosTelefones contatosTelefones = new QContatosTelefones("contatosTelefones");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath telefone = createString("telefone");

    public QContatosTelefones(String variable) {
        super(ContatosTelefones.class, forVariable(variable));
    }

    public QContatosTelefones(Path<? extends ContatosTelefones> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContatosTelefones(PathMetadata<?> metadata) {
        super(ContatosTelefones.class, metadata);
    }

}

