package com.kangyl.test.bloom;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * <p> Description:简单布隆过滤器实现
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年10月12日
 */
public class BloomFilter {

    private static final int SIZE = 1 << 25;
    private static final int[] HASH_FACTOR = {7, 11, 13, 31, 37, 61};
    private final List<SimpleHash> simpleHashList;
    private BitSet bitSet = new BitSet(SIZE);


    public BloomFilter() {
        simpleHashList = new ArrayList<SimpleHash>();
        for (int factor : HASH_FACTOR) {
            simpleHashList.add(new SimpleHash(SIZE, factor));
        }
    }

    public void add(String value) {
        if (value == null) {
            return;
        }
        for (SimpleHash simpleHash : simpleHashList) {
            bitSet.set(simpleHash.getHashCode(value));
        }
        afterAdd(value);

    }

    /**
     * 钩子方法,方便子类扩展
     * @param value
     */
    protected void afterAdd(String value) {

    }

    /**
     * 是否已经包含
     * @param value     待判定的字符串
     * @return  value
     */
    public boolean contains(String value) {
        if (value == null) {
            return false;
        }

        boolean contain = true;
        for (SimpleHash simpleHash : simpleHashList) {
            contain = contain && bitSet.get(simpleHash.getHashCode(value));
        }

        return contain;
    }


    private class SimpleHash{

        private int cap;

        private int factor;

        private SimpleHash(int cap, int factor) {
            this.cap = cap;
            this.factor = factor;
        }

        int getHashCode(String value) {
            char[] chars = value.toCharArray();
            int result = 0;
            for (char aChar : chars) {
                result += factor * result + aChar;
            }
            return result & (cap-1);
        }


    }
}
