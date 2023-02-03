package com.example.demo.service.dynamicproxy;

import com.example.demo.service.dynamicproxy.jdkproxy.StudentInterface;

/**
 * @author gaonan1
 * @date 2019/11/18
 **/
public class StudentBean implements StudentInterface {

    private String name;

    public StudentBean() {

    }

    public StudentBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println(name);
    }

    @Override
    public void print1() {
        System.out.println("我是print1");
    }
}
