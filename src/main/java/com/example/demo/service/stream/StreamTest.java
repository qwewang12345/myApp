package com.example.demo.service.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;

/**
 * @author gaonan1
 * @date 2020/4/7
 **/
public class StreamTest {

    public static void main(String[] args) {
        List<Long> a = Arrays.asList(1000L, 2000L, 3000L, 4000L);
        List<Long> b = a.stream()
                .limit(2)
                .collect(Collectors.toList());
        Long c = a.stream()
                .skip(2)
                .reduce(Long::sum)
                .get();

        String[] words = new String[]{"Hello,xiaoming","World,xiaohua"};
        List<String> wordList = Arrays.stream(words)
                .map(word -> word.split(","))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        BigDecimal decimal = new BigDecimal("0.000000");
        boolean res = decimal.compareTo(BigDecimal.ZERO) == 0;
    }
}
