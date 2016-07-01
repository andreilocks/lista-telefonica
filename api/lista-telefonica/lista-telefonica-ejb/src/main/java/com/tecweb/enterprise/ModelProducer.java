package com.tecweb.enterprise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

/**
 * Created by andrei on 18/05/16.
 */
@Dependent
public class ModelProducer {

    @Inject
    javax.validation.Validator validator;

    @Produces
    public final Logger produceLogger(final InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

}
