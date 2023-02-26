package com.example.demo.service.rpc;

/**
 * @author gaonan1
 * @date 2021/1/19 21:29
 **/
public interface StudentService {

    public Student getInfo();

    public boolean printInfo(Student student);
}
