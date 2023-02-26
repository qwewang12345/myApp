package com.example.demo.service.builder;

/**
 * @author gaonan1
 * @date 2020/2/4
 **/
public class Test {

    public static void main(String[] args) {
        Child child = Child.builder()
                .c("abc")
                .build();
        /*child = new Child("a", "c");*/
        Normal normal = Normal.builder()
                .m("m")
                .build();
        normal = normal.toBuilder().n("nnnn").build();
    }
}
