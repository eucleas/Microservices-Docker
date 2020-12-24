package com.training.ykb.rest.error;


public class RestException extends Exception {

    private static final long serialVersionUID = 6671101406212160340L;

    private ErrorObj          error;


    public RestException() {
    }

    public RestException(final ErrorObj errorParam) {
        super();
        this.error = errorParam;
    }


    public ErrorObj getError() {
        return this.error;
    }

    public void setError(final ErrorObj errorParam) {
        this.error = errorParam;
    }


}
