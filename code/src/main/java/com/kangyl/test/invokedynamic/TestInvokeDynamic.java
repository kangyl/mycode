package com.kangyl.test.invokedynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/10/13
 */
public class TestInvokeDynamic {
     class GrandFather{
        void thinking(){
            System.out.println("grand father thinking");
        }
    }

     class Father extends GrandFather{
        void thinking() {
            System.out.println("father thinking");
        }
    }

     class Son extends Father {
        void thinking() {
            try {
                //jdk7
//                MethodType methodType = MethodType.methodType(void.class);
//                MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", methodType, getClass());
//                 mh.invoke(this);
                //1.8
                MethodType mt = MethodType.methodType(void.class);
                Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                IMPL_LOOKUP.setAccessible(true);
                MethodHandles.Lookup lkp = (MethodHandles.Lookup)IMPL_LOOKUP.get(null);
                MethodHandle h1 = lkp.findSpecial(TestInvokeDynamic.GrandFather.class, "thinking", mt, TestInvokeDynamic.GrandFather.class);
                h1.invoke(this);

            } catch (Throwable e) {
                e.printStackTrace();
            }

        }
    }


}
