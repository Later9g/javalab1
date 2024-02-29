package org.example;


import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5,null};

        MyList<Integer> list = new MyList<>(a);
        System.out.println(list.size());
    }
}
