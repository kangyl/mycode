package com.kangyl.test.stream;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/6
 */
public class StreamTest {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("dfg");
        strings.add("abg");
        Stream<String> stream = strings.stream();
        stream.collect(Collectors.toList());
    }

    private static class StringHolder{
        private String string;

        public StringHolder(String string) {
            this.string = string;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }
}
