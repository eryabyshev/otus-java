package ru.evgeny.main;

import com.google.common.collect.HashMultiset;
import ru.evgeny.datanow.DateNow;


public class Main {

    public static void main(String[] args) {
        HashMultiset<String> set = HashMultiset.create();
        set.add("Data now: ");
        set.add(DateNow.getDate());
        set.add(String.join(" ", args));

        for(String s : set)
            System.out.println(s);
    }

}
