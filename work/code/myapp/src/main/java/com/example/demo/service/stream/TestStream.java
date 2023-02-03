package com.example.demo.service.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gaonan1
 * @date 2020/4/20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStream {

    @Test
    public void sortTest() {
        Student a = Student.builder()
                .name("a")
                .age(12)
                .build();

        Student b = Student.builder()
                .name("b")
                .age(12)
                .build();

        Student c = Student.builder()
                .name("c")
                .age(12)
                .build();

        Student d = Student.builder()
                .name("d")
                .age(11)
                .build();

        List<Student> students = new ArrayList<>(16);
        students.add(c);
        students.add(a);
        students.add(b);
        students.add(d);

        List<Student> sortedStudentList = students.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        Map<Integer, BigDecimal> map = new HashMap<>();
        map.put(1, new BigDecimal("1.2"));
        map.put(2, new BigDecimal("1.2"));

    }
}
