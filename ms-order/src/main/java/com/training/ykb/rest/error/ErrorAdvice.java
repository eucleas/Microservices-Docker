package com.training.ykb.rest.error;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    public static final String SUBDOMAIN       = "RESTAURANT";
    public static final String BOUNDED_CONTEXT = "ORDER";
    public static final String MICROSERVICE    = "ORDER";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(final MethodArgumentNotValidException mex) {
        ErrorObj rootError = new ErrorObj().setSubDomain(ErrorAdvice.SUBDOMAIN)
                                           .setBoundedContext(ErrorAdvice.BOUNDED_CONTEXT)
                                           .setMicroservice(ErrorAdvice.MICROSERVICE)
                                           .setErrorDesc("Validation Error")
                                           .setCause(200);

        List<ObjectError> allErrorsLoc = mex.getBindingResult()
                                            .getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootError.addSubError(new ErrorObj().setSubDomain(ErrorAdvice.SUBDOMAIN)
                                                .setBoundedContext(ErrorAdvice.BOUNDED_CONTEXT)
                                                .setMicroservice(ErrorAdvice.MICROSERVICE)
                                                .setErrorDesc(objectErrorLoc.toString())
                                                .setCause(201));
        }
        return rootError;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(final IllegalArgumentException iex) {
        return new ErrorObj().setSubDomain(ErrorAdvice.SUBDOMAIN)
                             .setBoundedContext(ErrorAdvice.BOUNDED_CONTEXT)
                             .setMicroservice(ErrorAdvice.MICROSERVICE)
                             .setErrorDesc(iex.getMessage())
                             .setCause(101);
    }

    @ExceptionHandler(RestException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorObj handle(final RestException rex) {
        return new ErrorObj().setSubDomain(ErrorAdvice.SUBDOMAIN)
                             .setBoundedContext(ErrorAdvice.BOUNDED_CONTEXT)
                             .setMicroservice(ErrorAdvice.MICROSERVICE)
                             .setErrorDesc("Error while calling other MS")
                             .addSubError(rex.getError())
                             .setCause(701);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handle(final Exception iex) {
        if (iex instanceof NullPointerException) {
            ErrorObj eo = new ErrorObj().setSubDomain(ErrorAdvice.SUBDOMAIN)
                                        .setBoundedContext(ErrorAdvice.BOUNDED_CONTEXT)
                                        .setMicroservice(ErrorAdvice.MICROSERVICE)
                                        .setErrorDesc(iex.getMessage())
                                        .setCause(501);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(eo);
        }
        ErrorObj eo = new ErrorObj().setSubDomain(ErrorAdvice.SUBDOMAIN)
                                    .setBoundedContext(ErrorAdvice.BOUNDED_CONTEXT)
                                    .setMicroservice(ErrorAdvice.MICROSERVICE)
                                    .setErrorDesc(iex.getMessage())
                                    .setCause(501);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(eo);
    }


}
