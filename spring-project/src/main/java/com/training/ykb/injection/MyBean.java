package com.training.ykb.injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    private static final Logger log = LoggerFactory.getLogger(MyBean.class);

    public void execute() {
        MyBean.log.info("MyBean Executed");

    }


}
