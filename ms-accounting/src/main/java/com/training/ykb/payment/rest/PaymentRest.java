package com.training.ykb.payment.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.payment.model.PaymentRequest;

@RestController
@RequestMapping("/payment")
public class PaymentRest {

    @Value("${server.port}")
    private int port;

    @PostMapping("/charge")
    public String charge(@Validated @RequestBody final PaymentRequest pr) {
        System.out.println("" + pr);
        return "OK-" + this.port;
    }


}

