package com.guanxing.Chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * 运行时常量池导致的内存溢出异常
 * -XX:PermSize=6m -XX:MaxPermSize=6m
 * jdk7之后不会出现异常，永久代被取消
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用set保持常量池的引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());  //基本数据型态转换成 String; intern是本地方法
        }
    }
}
