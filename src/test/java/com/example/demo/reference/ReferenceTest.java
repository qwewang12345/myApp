package com.example.demo.reference;

import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 测试赋值时引用赋值和普通赋值的区别
 * @author gaonan1
 * @date 2020/1/7
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceTest {

    @Test
    public void basicAssignTest() {
        int a = 1;
        int b = 2;
        a = b;
        System.out.print(a);
        System.out.print(b);
        Collection<Integer> res = new ArrayList<>(16);
        res.add(1);
        res.add(2);
    }

    @Test
    public void objectAssignTest() {
        Student a = new Student(1L, "gn");
        Student b = new Student(2L, "xmy");
        a = b;
    }

    @Test
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<String>();
        list2.add("C");
        list2.add("B");
        list2.add("D");
        // 并集
        //list1.addAll(list2);
        // 去重复并集
        //list2.removeAll(list1);
        //list1.addAll(list2);
        // 交集
        list1.retainAll(list2);
        // 差集
        //list1.removeAll(list2);
    }
}
