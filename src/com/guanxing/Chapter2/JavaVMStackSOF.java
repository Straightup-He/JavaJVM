package com.guanxing.Chapter2;
/**
 * @author guanxing
 * VM Options: -Xss128k
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();  //调用自身
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
/*
stack length:1001
Exception in thread "main" java.lang.StackOverflowError
	at com.guanxing.JVM.Chapter2.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:11)
	...
 */