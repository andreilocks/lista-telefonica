package com.tecweb.enterprise;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by andrei on 30/06/16.
 */

public abstract class AbstractRepresentationBuilder<E, R, B> {

    public abstract E fromRepresentation(R dto, B builder);

    public abstract R toRepresentation(E e);

    public List<R> toRepresentation(List<E> e) {
        return e.stream().map(this::toRepresentation).collect(Collectors.toList());
    }

    public List<E> fromRepresentation(List<R> r, B builder) {
        return r.stream().map(e -> fromRepresentation(e, builder)).collect(Collectors.toList());
    }
}