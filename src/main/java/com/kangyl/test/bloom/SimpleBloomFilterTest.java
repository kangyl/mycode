package com.kangyl.test.bloom;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p> Description:布隆过滤测试类
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年10月12日
 */
public class SimpleBloomFilterTest {
    public static void main(String[] args) {
        SimpleBloomFilterExtend bloomFilterExtend = new SimpleBloomFilterExtend();
        List<String> template = generateStrList();
        int count = 0;
        for (String value : template) {
            boolean bloomContain = bloomFilterExtend.contains(value);
            boolean actualContain = bloomFilterExtend.actualContain(value);
            if(bloomContain&& !actualContain){
                count++;
            }
            if (bloomContain && actualContain) {
                System.out.println("已包含:"+value);
            }
            bloomFilterExtend.add(value);
        }

        BigDecimal percent = new BigDecimal(count).multiply(new BigDecimal(100)).divide(new BigDecimal(template.size()),10,RoundingMode.HALF_UP);
        System.out.println("布隆过滤器总共判定:" + template.size() + "个,误判数量为:" + count + ",误差率为:" + percent.toString()+"%");


    }

    private static List<String> generateStrList() {
        int generateSize = 1111100;
        List<String> strings = new ArrayList<>(generateSize);
        for (int i = 0; i < generateSize; i++) {
            strings.add(genenateStr(10));
        }
        return strings;
    }

    private static final char[] TOTAL_STR = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public static String genenateStr(int length) {
        int size = TOTAL_STR.length;
        char[] result = new char[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result[i] = TOTAL_STR[random.nextInt(size)];
        }

        return String.valueOf(result);
    }
}
