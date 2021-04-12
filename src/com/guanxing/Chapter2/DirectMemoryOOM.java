package com.guanxing.Chapter2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 测试本机直接内存溢出
 * -Xmx20m -XX:MaxDirectMemorySize=10m
 * 直接内存（Direct Memory）的容量大小可通过-XX：MaxDirectMemorySize参数来指定，如果不去指定，则默认与Java堆最大值（由-Xmx指定）一致
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
/*
Exception in thread "main" java.lang.OutOfMemoryError
	at sun.misc.Unsafe.allocateMemory(Native Method)
	at com.guanxing.JVM.Chapter2.DirectMemoryOOM.main(DirectMemoryOOM.java:20)
 */