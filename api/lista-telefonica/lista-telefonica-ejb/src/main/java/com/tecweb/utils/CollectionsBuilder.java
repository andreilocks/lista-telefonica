package com.tecweb.utils;

import java.util.ArrayList;

/**
 * Created by andrei on 13/02/16.
 */
public final class CollectionsBuilder {

    private static final int DEFAULT_CAPACITY = 32;

    private CollectionsBuilder() {
    }

    public static <T> ArrayList<T> createDefaultArrayList() {
        return new ArrayList<T>(DEFAULT_CAPACITY);
    }

}
