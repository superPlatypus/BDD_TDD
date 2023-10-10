package org.example;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        System.out.println(list);
        ex(list);
        System.out.println(list);
    }

    private static void ex(List<Integer> list){
        list.add(10);
    }
}
