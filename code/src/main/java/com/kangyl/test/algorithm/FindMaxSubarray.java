package com.kangyl.test.algorithm;

/**
 * 分治算法，获取最大子数组
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/28
 */
public class FindMaxSubarray {

    public static void main(String[] args) {
        int[] arrays = {4, 5, -4, 6, 10, -2,-15,8, 21, -4, -2, 25, 12,31,-5};
        System.out.println(findMaxSubArray(arrays, 0, arrays.length - 1));
    }

    private static SubResult findMaxSubArray(int[] arrays, int lowIndex, int highIndex) {
        if (lowIndex == highIndex) {
            return SubResult.build().setHighIndex(highIndex).setHighIndex(lowIndex).setSum(arrays[lowIndex]);
        }
        int mid = (lowIndex + highIndex) / 2;
        SubResult leftResult = findMaxSubArray(arrays, lowIndex, mid);
        SubResult rightResult = findMaxSubArray(arrays, mid + 1, highIndex);
        SubResult crossSubArray = findMaxCrossSubArray(arrays, lowIndex, mid, highIndex);
        if (leftResult.getSum() > rightResult.getSum() && leftResult.getSum() > crossSubArray.getSum()) {
            return leftResult;
        } else if (rightResult.getSum() > leftResult.getSum() && rightResult.getSum() > crossSubArray.getSum()) {
            return rightResult;
        }else
            return crossSubArray;


    }

    private static SubResult findMaxCrossSubArray(int[] arrays,int lowIndex,int midIndex,int highIndex){
        int maxLeftSum = Integer.MIN_VALUE;
        int maxLeftIndex = 0;
        int currentLeftSum = 0;
        for (int i = midIndex; i >= lowIndex; i--) {
            currentLeftSum += arrays[i];
            if (currentLeftSum > maxLeftSum) {
                maxLeftSum = currentLeftSum;
                maxLeftIndex = i;
            }
        }

        int maxRightSum = Integer.MIN_VALUE;
        int maxRightIndex = 0;
        int rightSum = 0;
        for (int i = midIndex+1; i <= highIndex; i++) {
            rightSum += arrays[i];
            if (rightSum > maxRightSum) {
                maxRightIndex = i;
                maxRightSum = rightSum;
            }
        }

        return SubResult.build().setLowIndex(maxLeftIndex).setHighIndex(maxRightIndex).setSum(maxLeftSum + maxRightSum);
    }

    private static class SubResult {
        private int lowIndex;
        private int highIndex;
        private int sum;

        public static SubResult build() {
            return new SubResult();
        }
        public int getLowIndex() {
            return lowIndex;
        }

        public SubResult setLowIndex(int lowIndex) {
            this.lowIndex = lowIndex;
            return this;
        }

        public int getHighIndex() {
            return highIndex;
        }

        public SubResult setHighIndex(int highIndex) {
            this.highIndex = highIndex;
            return this;
        }

        public int getSum() {
            return sum;
        }

        public SubResult setSum(int sum) {
            this.sum = sum;
            return this;
        }

        @Override
        public String toString() {
            return "SubResult{" +
                    "lowIndex=" + lowIndex +
                    ", highIndex=" + highIndex +
                    ", sum=" + sum +
                    '}';
        }
    }
}
