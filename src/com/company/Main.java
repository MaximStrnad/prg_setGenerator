package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int setLength = 0;
        int[] arr_a = {-1,0,1,2,3,4,5,6,7,8,9,10,12,34};
        int[] arr_b = {2,4,6,5,8,10,33};
        Set a = new Set(arr_a);
        Set b = new Set(arr_b);
        System.out.println(a.toString());
        System.out.println(b.toString());
        Set.sort(b);
        System.out.println(b.toString());
        System.out.println(Set.intersection(a,b));
        System.out.println("intersection " + Set.intersection(a,b).toString());
        System.out.println("diff " + Set.difference(a,b).toString());
        System.out.println("supp " + Set.supplement(a,b).toString());
        System.out.println("union " + Set.union(a,b).toString());
    }
}
