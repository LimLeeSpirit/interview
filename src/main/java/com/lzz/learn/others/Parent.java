package com.lzz.learn.others;

/**
 * @author LimLee
 * @data 2020-09-24
 **/
public class Parent {
    public void init() {
        System.out.println("parent init");
        initPos();
    }

    public void initPos() {
        System.out.println("parent init pos");
    }
}

class Child extends Parent {
    @Override
    public void init() {
//        super.init();
        initPos();
        System.out.println("child ini");
    }

    @Override
    public void initPos() {
//        super.initPos();
        System.out.println("child ini pos");
    }

    public static void main(String[] args) {
        Parent child = new Child();
        child.init();
    }
}
