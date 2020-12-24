package com.training.ykb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.injection.IMyIntf;
import com.training.ykb.injection.MyUsingBean;

import a.b.c.OtherBeanA;

@RestController
public class MyFirstRest {

    @Autowired
    @Qualifier("pokemon")
    private MyUsingBean mub;

    @Autowired
    private OtherBeanA  oba;

    @Autowired
    private IMyIntf     imf;

    @GetMapping
    public String hello() {
        this.mub.proc();
        this.oba.xyz();
        this.imf.test();
        return "Hello world";
    }

}
