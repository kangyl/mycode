package com.kangyl.test.remoteproxy;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/5/19
 */
public class MyBeanFactoyBeanPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private static final String CONTEXT_PATH = "/Users/kyl/workspaces/mycode/code/target/classes/";



    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        ClassPathResource classPathResource = new ClassPathResource("com/kangyl/test/remoteproxy");
        try {
            File file = classPathResource.getFile();
            List<File> files = loadAllFile(file);
            List<Class> classes = filterFile(files);
            for (Class clazz : classes) {
                BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(CglibProxyFactoryBean.class);
                if(!clazz.isInterface()){
                    definitionBuilder.addConstructorArgValue(clazz.getInterfaces());
                }else{
                    definitionBuilder.addConstructorArgValue(new Class[]{clazz});
                }
                registry.registerBeanDefinition(humpName(clazz.getSimpleName()),definitionBuilder.getBeanDefinition());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String humpName(String className) {
        if (className.length() == 1) {
            return className.toLowerCase();
        }
        char[] chars = className.toCharArray();
        chars[0] = StringUtils.lowerCase(className.substring(0, 1)).charAt(0);
        return new String(chars);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {


    }



    private List<File> loadAllFile(File file) {
        List<File> files = new ArrayList<>();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File listFile : listFiles) {
                if (listFile.isFile()) {
                    files.add(listFile);
                }else{
                    files.addAll(loadAllFile(file));
                }
            }
        }else{
            files.add(file);
        }
        return files;
    }

    private List<Class> filterFile(List<File> files){
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.getName().contains("$") && pathname.getName().endsWith(".class");
            }
        };
        List<String> filePaths = new ArrayList<>();
        for (File file : files) {
            if (fileFilter.accept(file)) {
                filePaths.add(file.getPath());
            }
        }

        List<Class> matchClass = new ArrayList<>();
        for (String filePath : filePaths) {
            String className = resolveClass(filePath, CONTEXT_PATH);
            try{
                Class<?> clazz = Class.forName(className);
                RemoteService annotation = clazz.getAnnotation(RemoteService.class);
                if (annotation != null) {
                    matchClass.add(clazz);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return matchClass;
    }

    private String resolveClass(String filePath, String contextPah) {
        String className = filePath.replace(contextPah, "").replace(".class", "").replace("/", ".");
        return className;
    }
}
