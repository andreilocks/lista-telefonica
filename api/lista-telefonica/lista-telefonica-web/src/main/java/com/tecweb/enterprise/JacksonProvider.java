package com.tecweb.enterprise;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;

/**
 * Created by andrei on 13/03/16.
 */
@Provider
public class JacksonProvider implements ContextResolver<ObjectMapper> {

    final ObjectMapper defaultObjectMapper;

    public JacksonProvider(){
        defaultObjectMapper = createDefaultObjectMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return defaultObjectMapper;
    }

    private static ObjectMapper createDefaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
        mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, true);
        return mapper;
    }
}
