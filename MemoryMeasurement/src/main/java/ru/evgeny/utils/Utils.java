package ru.evgeny.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final int SIZE = 20_000_000;

    public static long getMemory() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static long multiplicityByEight(long value) {
        while (value % 8 != 0) {
            value++;
        }
        return value;
    }

    private static long calculateMemory(long before, long after){
        return multiplicityByEight((after - before) / SIZE);
    }

    public static long sizeOfEmptyString() throws InterruptedException {
        String[] ar = new String[SIZE];
        long memoryBefore = getMemory();
        for(int i = 0; i < SIZE; i++)
            ar[i] = new String(new char[0]);
        long memoryAfter = getMemory();
        return calculateMemory(memoryBefore, memoryAfter);
    }

    public static long sizeOfObject() throws InterruptedException {
        Object[] ob = new Object[SIZE];
        long before = getMemory();
        for(int i = 0; i < SIZE; i++)
            ob[i] = new Object();
        long after = getMemory();
        return calculateMemory(before, after);
    }

    public static long sizeOfContainer() throws InterruptedException {
        List[] l = new List[SIZE];
        long before = getMemory();
        for(int i = 0; i < SIZE; i++)
            l[i] = new ArrayList();
        long after = getMemory();
        return calculateMemory(before, after);
    }

    public static long sizeOfContainer(int size) throws InterruptedException {
        if(size == 0)
            return sizeOfContainer();
        List list = new ArrayList();
        long before = getMemory();
        for(int i = 0; i < size; i++)
            list.add(i);
        long after = getMemory();
        return calculateMemory(before, after);
    }
}
