package com.training.ykb.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         subDomain;
    private String         boundedContext;
    private String         microservice;
    private String         errorDesc;
    private int            cause;


    public ErrorObj addSubError(final ErrorObj subError) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(subError);
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public ErrorObj setSubErrors(final List<ErrorObj> subErrorsParam) {
        this.subErrors = subErrorsParam;
        return this;
    }

    public String getSubDomain() {
        return this.subDomain;
    }

    public ErrorObj setSubDomain(final String subDomainParam) {
        this.subDomain = subDomainParam;
        return this;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public ErrorObj setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
        return this;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public ErrorObj setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
        return this;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public ErrorObj setErrorDesc(final String errorDescParam) {
        this.errorDesc = errorDescParam;
        return this;
    }

    public int getCause() {
        return this.cause;
    }

    public ErrorObj setCause(final int causeParam) {
        this.cause = causeParam;
        return this;
    }


}
