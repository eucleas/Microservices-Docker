package com.training.ykb;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notification_q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notification_ex",
                                                                  durable = "true",
                                                                  autoDelete = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notification_request"))
    @SendTo("notification_res_ex/notification_reponse")
    public String handle(final Notification notf) {
        System.out.println(notf);
        return "Request : " + notf + " --> processed...";
    }

}
