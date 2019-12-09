/**
 * Copyright
 */
package com.kangyl.test.spi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/11
 */
public final class MyServiceLoader {


    private static final String PREFIX = "META-INF/services/";

    public static <T> T load(Class<T> service,ClassLoader classLoader) {
        String fullName = PREFIX + service.getName();
        try {
            Enumeration<URL> configs = classLoader.getResources(fullName);
            while (configs.hasMoreElements()) {
                try{
                    Class<T> objectClass = parseResource(configs.nextElement(), classLoader);
                    if (objectClass != null) {
                        T cast = service.cast(objectClass.newInstance());
                        return cast;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            System.out.println("加载service:["+service.getName()+"]失败");
        }
        throw new RuntimeException("获取类失");

    }


    private static <T> Class<T> parseResource(URL url, ClassLoader classLoader) {
        try (InputStream is = url.openStream();
              BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"))){
            String clazzPath ;
            Class clazz;
            while ((clazzPath = br.readLine()) != null) {
                clazz = getClass(clazzPath, classLoader);
                if (clazz != null) {
                    return clazz;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Class getClass(String clazz, ClassLoader classLoader) {
        try {
            Class<?> aClass = Class.forName(clazz, false, classLoader);
            return aClass;
        } catch (ClassNotFoundException e) {
            System.out.println("加载类:" + clazz + "失败");
        }
        return null;
    }


}
