package com.guanxing.Chapter2;

import java.util.ArrayList;
import java.util.List;

//测试堆溢出
//VM Options: -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
/*
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid20524.hprof ...
Heap dump file created [9402726 bytes in 0.098 secs]
...
 */