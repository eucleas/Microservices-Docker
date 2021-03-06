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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(final MethodArgumentNotValidException mex) {
        ErrorObj rootError = new ErrorObj().setSubDomain("CRM")
                                           .setBoundedContext("CAMPAIGN")
                                           .setMicroservice("person")
                                           .setErrorDesc("Validation Error")
                                           .setCause(200);

        List<ObjectError> allErrorsLoc = mex.getBindingResult()
                                            .getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootError.addSubError(new ErrorObj().setSubDomain("CRM")
                                                .setBoundedContext("CAMPAIGN")
                                                .setMicroservice("person")
                                                .setErrorDesc(objectErrorLoc.toString())
                                                .setCause(201));
        }
        return rootError;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(final IllegalArgumentException iex) {
        return new ErrorObj().setSubDomain("CRM")
                             .setBoundedContext("CAMPAIGN")
                             .setMicroservice("person")
                             .setErrorDesc(iex.getMessage())
                             .setCause(101);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handle(final Exception iex) {
        if (iex instanceof NullPointerException) {
            ErrorObj eo = new ErrorObj().setSubDomain("CRM")
                                        .setBoundedContext("CAMPAIGN")
                                        .setMicroservice("person")
                                        .setErrorDesc(iex.getMessage())
                                        .setCause(501);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(eo);
        }
        ErrorObj eo = new ErrorObj().setSubDomain("CRM")
                                    .setBoundedContext("CAMPAIGN")
                                    .setMicroservice("person")
                                    .setErrorDesc(iex.getMessage())
                                    .setCause(501);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(eo);
    }


}
