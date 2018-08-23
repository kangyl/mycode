/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/8/16
 */
public class CharSetUtil {

    private static final Charset CHAR_SET = Charset.forName("UTF-8");

    public static String decode(ByteBuffer byteBuffer) {
        return CHAR_SET.decode(byteBuffer).toString();
    }
}
