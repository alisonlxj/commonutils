package com.alison.commonutils.utils;

/**
 * @author lixianjun02
 * @ClassName ClassLoaderUtils
 * @Description ...
 * @Date 2020/11/22 11:09 上午
 **/
public class ClassLoaderUtils {


    private ClassLoaderUtils() {
    }


    public static ClassLoader getSystemClassLoader() {
        return ClassLoader.getSystemClassLoader();
    }


    public static ClassLoader getClassLoaderFromClazz(Class<?> clazz) {
        return clazz.getClassLoader();
    }


    public static ClassLoader getClassLoaderFromObject(Object object) {
        return getClassLoaderFromClazz(object.getClass());
    }


}
