package com.example.demo.service.grammar;

/**
 * @author gaonan1
 * @date 2020/5/20
 **/
public class InstanceTest {

    public static void main(String[] args) {
        Student student = Student.builder()
                .name("xiaoming")
                .age(11)
                .build();
        boolean a = student instanceof Student;
        boolean b = student instanceof Person;

        Class clazz = Student.class;
        Class parentClazz = Person.class;
        boolean c =  clazz.isInstance(student);
        boolean d = parentClazz.isInstance(student);
    }
}