package com.example.demo.service.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

/**
 * @author gaonan1
 * @date 2021/6/29 10:16
 **/
public class ParentTest {

    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1L);
        student.setName("111");
        student.setAge(13);
        student.setClasses("三年二班");
        student.setScore(90L);
        Person person = student;
        Gson gson = (new GsonBuilder()).setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
        String str = gson.toJson(person);
        String str1 = person.toString();
        System.out.println(str);
        System.out.println(str1);
        Person person1 = gson.fromJson(str, Person.class);
        System.out.println(person1);
    }
}
