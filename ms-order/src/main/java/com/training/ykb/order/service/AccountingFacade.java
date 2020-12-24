package com.training.ykb.order.service;

import java.util.List;
import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.ykb.order.clients.IAccountingClient;
import com.training.ykb.order.model.Notification;
import com.training.ykb.order.model.Order;
import com.training.ykb.order.model.PaymentRequest;
import com.training.ykb.rest.error.RestException;

@Service
public class AccountingFacade {

    @Autowired
    private RestTemplate      rt;

    @Autowired
    private IAccountingClient iac;

    @Autowired
    private EurekaClient      eurekaClient;

    @Autowired
    private RabbitTemplate    rabt;

    public String charge2(final Order order) throws RestException {
        PaymentRequest pr = new PaymentRequest();
        pr.setCustomerId(order.getCustomerId());
        pr.setAmount(100);
        String chargeLoc = this.iac.charge(pr);
        Notification not = new Notification();
        not.setDestination("3456345");
        not.setMessage("Random : " + (new Random().nextInt()));
        this.rabt.convertAndSend("notification_ex",
                                 "notification_request",
                                 not);
        return chargeLoc;

    }

    public String charge(final Order order) {
        PaymentRequest pr = new PaymentRequest();
        pr.setCustomerId(order.getCustomerId());
        pr.setAmount(100);
        String responseLoc = this.rt.postForObject("http://ACCOUNTING/payment/charge",
                                                   pr,
                                                   String.class);
        return responseLoc;
    }

    public String charge3(final Order order) {
        Application applicationLoc = this.eurekaClient.getApplication("ACCOUTING");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc);
        }
        InstanceInfo ns = this.eurekaClient.getNextServerFromEureka("ACCOUNTING",
                                                                    false);
        RestTemplate crt = new RestTemplate();
        PaymentRequest pr = new PaymentRequest();
        pr.setCustomerId(order.getCustomerId());
        pr.setAmount(100);
        String responseLoc = crt.postForObject("http://" + ns.getIPAddr() + ":" + ns.getPort() + "/payment/charge",
                                               pr,
                                               String.class);
        return responseLoc;
    }


}
