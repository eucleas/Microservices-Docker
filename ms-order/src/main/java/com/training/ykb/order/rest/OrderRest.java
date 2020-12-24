package com.training.ykb.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.order.model.Order;
import com.training.ykb.order.service.OrderService;
import com.training.ykb.rest.error.RestException;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderRest {

    @Autowired
    private OrderService os;

    @Value("${refresh.test}")
    private String       testStr;

    @PostMapping("/place")
    public String place(@Validated @RequestBody final Order order) {
        return this.os.orderPlace(order);
    }

    @PostMapping("/place2")
    public String place2(@Validated @RequestBody final Order order) throws RestException {
        // Feign client
        return this.os.orderPlace2(order);
    }

    @GetMapping("/test")
    public String test() {
        return this.testStr;
    }

}
