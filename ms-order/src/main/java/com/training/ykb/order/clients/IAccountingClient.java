package com.training.ykb.order.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.ykb.order.model.PaymentRequest;
import com.training.ykb.rest.error.RestException;

@FeignClient(name = "ACCOUNTING")
@RequestMapping("/payment")
public interface IAccountingClient {

    @PostMapping("/charge")
    public String charge(@RequestBody final PaymentRequest pr) throws RestException;

}
