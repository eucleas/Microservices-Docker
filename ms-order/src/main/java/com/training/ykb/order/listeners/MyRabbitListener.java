package com.training.ykb.order.listeners;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notification_res_q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notification_res_ex",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notification_reponse"))
    public void handle(final String response) {
        System.out.println(response);
    }

}
