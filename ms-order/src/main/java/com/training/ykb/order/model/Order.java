package com.training.ykb.order.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Order {

    private String       customerId;
    @NotNull
    @Size(min = 1)
    private List<String> meals;

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final String customerIdParam) {
        this.customerId = customerIdParam;
    }

    public List<String> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<String> mealsParam) {
        this.meals = mealsParam;
    }


}
