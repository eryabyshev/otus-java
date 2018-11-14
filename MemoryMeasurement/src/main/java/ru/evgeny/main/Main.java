package ru.evgeny.main;

import ru.evgeny.utils.Utils;

public class Main {
    public static final int SIZE = 20_000_000;

    public static void main(String[] args) {

        try{
            System.out.println("Size of empty strings :\t" + Utils.sizeOfEmptyString());
            System.out.println("Size of empty object :\t" + Utils.sizeOfObject());
            System.out.println("Size of empty container :\t" + Utils.sizeOfContainer());
            System.out.println("Size of fill(" + SIZE +")container : \t" + Utils.sizeOfContainer(SIZE));
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }


    }

}
