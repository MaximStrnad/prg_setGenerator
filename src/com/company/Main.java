package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number for length of set A: ");
        int setLength = sc.nextInt();
        while(setLength < 10 || setLength > 20) {
            System.out.println("Enter a number for length of set A between 10 and 20: ");
            setLength = sc.nextInt();
        }
        Set a = new Set(setLength);
        System.out.println("Enter a number for length of set B: ");
        setLength = sc.nextInt();
        while(setLength < 10 || setLength > 20) {
            System.out.println("Enter a number for length of set B between 10 and 20: ");
            setLength = sc.nextInt();
        }
        Set b = new Set(setLength);
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
