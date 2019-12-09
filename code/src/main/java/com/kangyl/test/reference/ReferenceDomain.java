/**
 * Copyright  2018
 */
package com.kangyl.test.reference;

import com.kangyl.test.proxy.TestObject;

import java.lang.reflect.Constructor;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/2/26
 */
public class ReferenceDomain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
//        SoftReference<MyDate> myDateSoftReference = new SoftReference<MyDate>(new MyDate());
//        ReferenceTest.drawMemeory();

//        WeakReference<MyDate> myDateWeakReference = new WeakReference<MyDate>(new MyDate());
//        ReferenceTest.drawMemeory();

//        ReferenceQueue<MyDate> referenceQueue = new ReferenceQueue<MyDate>();
//        PhantomReference<MyDate> myDatePhantomReference = new PhantomReference<MyDate>(new MyDate(),referenceQueue);
//        System.gc();
//        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//        theUnsafe.setAccessible(true);
//
//        Unsafe unsafe1 = (Unsafe) theUnsafe.get(null);
//        TestObject testObject = (TestObject)unsafe1.allocateInstance(TestObject.class);
//        testObject.tt();
//        System.out.print(1);

        Constructor<?>[] constructors = TestObject.class.getConstructors();
        System.out.print(constructors.length);
        TestObject testObject = TestObject.class.newInstance();
        testObject.tt();

    }
}
