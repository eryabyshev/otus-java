package ru.evgeny.list;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {


    private int size = 0;
    private T[] array;

    private static final int CAPACITY = 10;

    public MyArrayList() {
        array = (T[]) new Object[CAPACITY];
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(Object o) {
        for (T t : array)
            if (t.equals(o))
                return true;
        return false;
    }

    public Iterator<T> iterator() {
        return iterator();
    }

    public T[] toArray() {
        T[] temp = (T[]) new Object[size];
        for (int i = 0; i < size; i++)
            temp[i] = array[i];
        return temp;
    }

    public <T1> T1[] toArray(T1[] a) {
        throw new NotImplementedException();
    }

    public boolean add(T t) {
        if (array.length == size) {
            T[] temp = (T[]) new Object[size + CAPACITY];
            for (int i = 0; i < size; i++)
                temp[i] = array[i];
            array = temp;
        }
        array[size] = t;
        size++;
        return true;
    }

    public boolean remove(Object o) {
        throw new NotImplementedException();
    }

    public boolean containsAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T item : c)
            this.add(item);
        return true;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        throw new NotImplementedException();
    }

    public boolean removeAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    public boolean retainAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    public void clear() {
        array = (T[]) new Object[CAPACITY];
    }

    public T get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    public T set(int index, T element) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException();
        array[index] = element;
        return array[index];
    }

    public void add(int index, T element) {
        throw new NotImplementedException();
    }

    public T remove(int index) {
        throw new NotImplementedException();
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++)
            if (array[i].equals(o))
                return i;
        return -1;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<T> listIterator() {
        throw new NotImplementedException();
    }

    public ListIterator<T> listIterator(int index) {
        throw new NotImplementedException();
    }

    public List<T> subList(int fromIndex, int toIndex) {
        throw new NotImplementedException();
    }
}
