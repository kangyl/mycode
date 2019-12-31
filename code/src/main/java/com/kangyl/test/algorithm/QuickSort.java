package com.kangyl.test.algorithm;

/**
 * 快速排序算法
 * 最坏时间复杂度 f(n*n)  最好时间复杂度 n*log(n) 平均复杂度
 * 平均时间复杂度 n*log(n)
 * 优点: 平均复杂度性能好，因此大多数情况下性能不错，少数情况是 n*n的时间复杂度
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/31
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] ints = {4, 2, 12, 34, 7, 8, 11, 13, 5};
        quickSort(ints, 0, ints.length - 1);
        for (int anInt : ints) {
            System.out.printf(anInt + ",");
        }
    }


    private static void quickSort(int[] arrays, int begin, int end) {
        if (end > begin) {
            int position = partition(arrays, begin, end);
            quickSort(arrays,begin,position-1);
            quickSort(arrays,position+1,end);
        }
    }

    private static int partition(int[] arrays, int begin, int end) {
        int x = arrays[end];
        int i = begin - 1;
        for (int index = begin; index <= (end - 1); index++) {
            if (arrays[index] <= x) {
                i++;
                exchange(arrays, i, index);
            }
        }
        exchange(arrays, i + 1, end);
        return i + 1;
    }

    private static void exchange(int[] arrays, int index1, int index2) {
        int from = arrays[index1];
        arrays[index1] = arrays[index2];
        arrays[index2] = from;
    }
}
