/**
 * Copyright
 */
package com.kangyl.test.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/10/4
 */
public abstract class ClassSearchTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassSearchTemplate.class);

    protected final String pkgName;

    protected ClassSearchTemplate(String pkgName) {
        this.pkgName = pkgName;
    }

    public List<Class<?>> getClassList() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        List<Class<?>> classList = new ArrayList<>();
        try {
            Enumeration<URL> resources = classLoader.getResources(pkgName.replace(".", "/"));
            while (resources.hasMoreElements()) {

                URL url = resources.nextElement();
                String protocol = url.getProtocol();
                if (protocol.equals("file")) {
                    String path = url.getPath().replace("%20", " ");
                    addClass(classList,path,pkgName);

                } else if (protocol.equals("jar")) {
                    JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
                    JarFile jarFile = jarURLConnection.getJarFile();
                    Enumeration<JarEntry> entries = jarFile.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry jarEntry = entries.nextElement();
                        String jarClassName = jarEntry.getName();

                        if(jarClassName.endsWith(".class")){
                            String className = jarClassName.substring(0, jarClassName.lastIndexOf(".")).replaceAll("/", ".");
                            doAddClass(classList, className);
                        }
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("加载类失败", e);
        }
        return classList;
    }

    private void addClass(List<Class<?>> classList, String pkgPath, String pkgName) {
        File[] files = new File(pkgPath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });

        for (File file : files) {
            String fileName = file.getName();
                if (file.isFile()) {
                    String className = fileName.substring(0, fileName.lastIndexOf("."));
                String classPath = pkgName + "." + className;
                doAddClass(classList, classPath);
            }else{
                String subPkgPath = pkgPath +"/"+ fileName;
                String subPkgName = pkgName + "." + fileName;
                addClass(classList, subPkgPath, subPkgName);
            }
        }
    }

    private void doAddClass(List<Class<?>> classList, String className) {
        Class clazz = loadClass(className);
        if(checkAccess(clazz)){
            classList.add(clazz);
        }
    }

    /**
     * 加载类到JVM
     * @param classPath
     * @return
     */
    private Class loadClass(String classPath) {
        try {
            return Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    /**
     * 由子类自行实现该策略
     * @param clazz
     * @return
     */
    protected abstract boolean checkAccess(Class<?> clazz);
}
