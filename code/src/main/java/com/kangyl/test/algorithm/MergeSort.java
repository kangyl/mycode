package com.kangyl.test.algorithm;

/**
 * 归并排序算法
 * 最坏时间复杂度 n*log(n) 平均时间复杂度 n*log(n)
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/27
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        mergeSort(arrays, 0, 8);
        print(arrays);

        int[] newarrays = {9, 8, 7, 6, 5, 4};
        mergeSort(newarrays, 0,  5);
        print(newarrays);

        int[] arrays3 = {4, 54, 7, 34, 86, 98, 43, 22, 35};
        mergeSort(arrays3, 0,  8);
        print(arrays3);
    }

    private static void mergeSort(int[] arrays,int begin,int end){
        if (begin < end) {
            int mid = (end +begin) / 2;
            mergeSort(arrays, begin, mid);
            mergeSort(arrays, mid + 1, end);
            sort(arrays, begin, mid, end);
        }
    }


    private static void print(int[] arrays) {
        for (int array : arrays) {
            System.out.printf(array + ", \t");
        }
        System.out.println();
    }
    private static void sort(int[] arrays,int begin,int spliceIndex,int end){
        if (arrays == null || arrays.length <= 1) {
            return;
        }

        int leftLength = spliceIndex - begin + 1;
        int rightLength = end - spliceIndex;

        int[] leftArray = new int[leftLength+1];
        int[] rightArray = new int[rightLength + 1];

        for (int i = 0; i < leftLength;i++) {
            leftArray[i] = arrays[begin + i];
        }

        for (int j =0;j<rightLength;j++){
            rightArray[j] = arrays[spliceIndex + j+1];
        }
        leftArray[leftLength] = Integer.MAX_VALUE;
        rightArray[rightLength] = Integer.MAX_VALUE;

        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = begin; i <= end; i++) {
            if (leftArray[leftIndex] <= rightArray[rightIndex] ) {
                arrays[i] = leftArray[leftIndex];
                leftIndex++;
            }else{
                arrays[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }

    }
}
