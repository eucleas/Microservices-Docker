package com.training.ykb.rest.error;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

public class RestErrorDecoder implements ErrorDecoder {

    private static final Logger logger = LoggerFactory.getLogger(RestErrorDecoder.class);


    @Override
    public RestException decode(final String methodKeyParam,
                                final Response responseParam) {
        try {
            if (responseParam.status() != 404) {
                InputStream asInputStreamLoc = responseParam.body()
                                                            .asInputStream();
                ObjectMapper om = new ObjectMapper();
                ErrorObj err = om.readValue(asInputStreamLoc,
                                            ErrorObj.class);
                return new RestException(err);
            } else {
                return new RestException(new ErrorObj().setSubDomain(ErrorAdvice.SUBDOMAIN)
                                                       .setBoundedContext(ErrorAdvice.BOUNDED_CONTEXT)
                                                       .setMicroservice(ErrorAdvice.MICROSERVICE)
                                                       .setErrorDesc("Resource not found exception")
                                                       .setCause(404));

            }
        } catch (Exception eLoc) {
            RestErrorDecoder.logger.error("[RestErrorDecoder][decode]-> *Error* : " + eLoc.getMessage(),
                                          eLoc);
        }

        return new RestException(new ErrorObj().setSubDomain(ErrorAdvice.SUBDOMAIN)
                                               .setBoundedContext(ErrorAdvice.BOUNDED_CONTEXT)
                                               .setMicroservice(ErrorAdvice.MICROSERVICE)
                                               .setErrorDesc("Internal Error")
                                               .setCause(500));
    }

}
