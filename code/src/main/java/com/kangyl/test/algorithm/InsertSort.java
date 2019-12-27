package com.kangyl.test.algorithm;

/**
 * 插入排序算法，时间复杂度 c1*n*n
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/26
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] results = {5, 3, 7, 1, 14, 6, 8};
        sort(results);
        for (int result : results) {
            System.out.print(result + "\t");
        }
    }

    private static void sort(int[] results) {
        if (results == null || results.length == 1) {
            return;
        }
        int length = results.length;
        for (int i = 1; i < length; i++) {
            int key = results[i];
            int j = i - 1;
            while (j >= 0 && results[j] >= key) {
                results[j + 1] = results[j];
                j--;
            }
            results[j + 1] = key;
        }
    }
}
