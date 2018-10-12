package com.kangyl.test.javassist;

import com.kangyl.test.hash.Person;
import javassist.*;

import java.lang.reflect.Method;

/**
 * <p> Description:动态编译测试类
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年09月30日
 */
public class TestJavassist {

    public static void main(String[] args) {
//        //测试新增父类
//        addSuperClass();
//        //测试创建类
//        testMakeClass();
        //测试之前之后删除
        testBeforeAfterInsert();
    }

    /**
     * 添加父类测试
     */
    private static void addSuperClass(){
        ClassPool classPool = ClassPool.getDefault();
        try {
            CtClass ctClass = classPool.get("com.kangyl.test.latch.LatchTest");
            ctClass.setSuperclass(classPool.get("com.kangyl.test.hash.Person"));
            ctClass.writeFile("target/classes");
            Class aClass = ctClass.toClass();
            Object o = aClass.newInstance();
            Method setName = getMethod("setName",aClass,String.class);
            setName.invoke(o, "ss");
            Method getName = getMethod("getName",aClass);
            System.out.println(getName.invoke(o));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建类
     */
    private static void testMakeClass() {
        ClassPool classPool = ClassPool.getDefault();
        try{
            CtClass makeClass = classPool.makeClass("TestMakeClass.class");
            CtMethod make = CtNewMethod.make(" public int getAge(){return 222;}", makeClass);
            makeClass.addMethod(make);
            CtField i = new CtField(CtClass.intType, "i", makeClass);
            makeClass.addField(i);

            Class aClass = makeClass.toClass();
            Object instance = aClass.newInstance();
            Method getAge = aClass.getDeclaredMethod("getAge");
            System.out.println("getAge:" + getAge.invoke(instance));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void testBeforeAfterInsert() {
        try{


            ClassPool classPool = ClassPool.getDefault();
            CtClass ct = classPool.get("com.kangyl.test.hash.Person");
            CtMethod getName = ct.getDeclaredMethod("getName");

            getName.insertBefore("{System.out.println(\"before get name\");}");
            getName.insertAfter("{System.out.println(\"after get name\");}");
            ct.toClass();


            Person person = new Person();
            person.getName();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据名称获取方法
     * @param methodName
     * @param clazz
     * @param parameterTypes
     * @return
     */
    private static Method getMethod(String methodName,Class clazz,Class<?>... parameterTypes){
        for (; clazz != null; clazz = clazz.getSuperclass()) {
            try{
                Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
                return method;
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return null;
    }
}
