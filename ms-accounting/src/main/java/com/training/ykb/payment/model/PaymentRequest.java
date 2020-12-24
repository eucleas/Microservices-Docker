package com.training.ykb.payment.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class PaymentRequest {

    @NotEmpty
    private String  customerId;
    @Positive
    private Integer amount;

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final String customerIdParam) {
        this.customerId = customerIdParam;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(final Integer amountParam) {
        this.amount = amountParam;
    }

    @Override
    public String toString() {
        return "PaymentRequest [customerId=" + this.customerId + ", amount=" + this.amount + "]";
    }


}
