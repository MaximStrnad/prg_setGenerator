package com.company;

import java.util.*;

public class Set
{
    private int[] array;

    public Set(int length)
    {
        this.array = new int[length];
        Random rand = new Random();

        for (int x = 0; x < length; x++) {
            int number = rand.nextInt(50) -30;
            boolean isSet = false;
            for (int a = 0; a < x; a++) {
                if (this.array[a] == number) {
                    isSet = true;
                }
            }
            if (!isSet) {
                this.array[x] = number;
            } else {
                x--;
            }
        }
    }

    public Set(int[] array)
    {
        this.array = array;
    }

    public int getLength ()
    {
        return this.array.length;
    }

    static String renderSet(Set set)
    {
        String res = Arrays.toString(set.array);
        System.out.println(res);
        res = res.replace("[","{");
        res = res.replace("]","}");
        return res;
    }
    static Set intersection (Set s1, Set s2) {
        int[] a = s1.array;
        int[] b = s2.array;
        int[] c = new int[a.length];
        int count = 0;
        for (int x = 0; x < a.length; x++ ) {
            boolean isSet = false;
            for (int y = 0; y < b.length; y++ ) {
                if (a[x] == b[y]) {
                    isSet = true;
                    break;
                }
            }
            c[count] = a[x];
            count++;
        }
        return new Set(c);
    }
}
