package com.kangyl.test.bloom;

import java.util.HashSet;
import java.util.Set;

/**
 * <p> Description:布隆过滤器的扩展,新增是否实际存在判定
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年10月12日
 */
public class SimpleBloomFilterExtend extends BloomFilter {

    private Set<String> existStr = new HashSet<String>();

    @Override
    protected void afterAdd(String value) {
        existStr.add(value);
    }

    /**
     * 是否实际存在判定(统计误判率)
     *
     * @param value
     * @return
     */
    public boolean actualContain(String value) {
        return existStr.contains(value);
    }
}
