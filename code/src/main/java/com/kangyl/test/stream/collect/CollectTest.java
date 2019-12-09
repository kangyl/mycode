package com.kangyl.test.stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/7
 */
public class CollectTest {
    public static void main(String[] args) {
        String[] values = {"abc", "def", "asdf", "sdfds"};
        List<String> strings = Arrays.asList(values);
        Stream<String> stream = strings.stream();
        String result = stream.collect(Collectors.joining(","));
        System.out.println(result);

        Stream<String> stream1 = strings.stream();
        Map<String, List<String>> abc = stream1.collect(Collectors.groupingBy((value) -> {
            if (value.equals("abc")) {
                return "1";
            } else {
                return "2";
            }
        }));
        System.out.println(abc);
    }
}
