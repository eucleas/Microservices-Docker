package com.training.ykb.injection;

import org.springframework.stereotype.Component;

@Component
public class MyIntfImpl implements IMyIntf {

    @Override
    public void test() {
        System.out.println("test called");
    }

}
