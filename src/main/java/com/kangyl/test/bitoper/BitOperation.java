package com.kangyl.test.bitoper;

/**
 * <p> Description:
 * <p>
 *
 * @author kangyl (460720197@qq.com)
 * @since 2018年10月29日
 */
public class BitOperation {

    public static void main(String[] args) {
        System.out.println(add(5,22));
    }

    public static int add(int x,int j){
        int xor= x^j;
        int forward=(x&j)<<1;
        if(forward!=0){
            return add(xor,forward);
        }else {
            return xor;
        }
    }

}
