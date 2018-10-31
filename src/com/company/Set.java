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

    public String toString()
    {
        String res = Arrays.toString(this.array);
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
            for (int y = 0; y < b.length; y++ ) {
                if (a[x] == b[y]) {
                    c[count] = a[x];
                    count++;
                }
            }

        }
        int[] res = new int[count];
        for (int x = 0; x < count; x ++){
            res[x] = c[x];
        }
        Set ret = new Set(res);
        Set.sort(ret);
        return ret;
    }

    static Set difference (Set s1, Set s2) {
        int[] a = s1.array;
        int[] b = s2.array;
        int[] c = new int[a.length];
        int count = 0;

        for (int x = 0; x < a.length; x++ ) {
            boolean isSet = false;
            for(int z = 0; z < b.length; z++ ) {
                if(a[x] == b[z]) {
                    isSet = true;
                }
            }
            if(!isSet) {
                c[count] = a[x]; count++;

            }
        }
        int[] res = new int[count];
        for (int x = 0; x < count; x ++){
            res[x] = c[x];
        }
        Set ret = new Set(res);
        Set.sort(ret);
        return ret;
    }
    static Set supplement (Set s1, Set s2) {
        if(Set.intersection(s1,s2).getLength() == s2.getLength()) {
            return Set.difference(s1, s2);
        }
        else return new Set(0);
        }

    static void sort (Set s1) {
        int[] nums = s1.array;
        for(int currentPlace = 0;currentPlace<nums.length-1;currentPlace++){
            int smallest =  Integer.MAX_VALUE;
            int smallestAt =  currentPlace+1;
            for(int check =  currentPlace; check<nums.length;check++){
                if(nums[check]<smallest){
                    smallestAt  = check;
                    smallest  = nums[check];
                }
            }
            int temp =  nums[currentPlace];
            nums[currentPlace]  = nums[smallestAt];
            nums[smallestAt]  = temp;


         }
        s1.array = nums;
    }
    static Set union (Set s1, Set s2) {
        int[] a = s1.array;
        int[] b = s2.array;
        int[] c = new int[a.length + b.length];
        int count = 0;
        boolean isSet = false;

        for (int x = 0; x < a.length; x ++){
            c[count] = a[x];
            count++;
        }
        for (int x = 0; x < b.length; x ++){
            c[count] = b[x];
            count++;
        }
        count = 0;
        int[] tmp = new int[c.length];
        isSet = false;
        for(int x = 0; x < c.length;x++) {
            for(int y = x; y < c.length; y++){
                if(c[x] == c[y] && x != y) {
                    isSet = true;
                    break;
                } else {
                    isSet = false;
                }
            }
            if(!isSet) {
                tmp[count] = c[x];
                isSet = false;
                count ++;
            }
        }
        int[] res = new int[count];
        for(int x = 0; x < count; x++) {
            res[x] = tmp[x];
        }
        Set ret = new Set(res);
        Set.sort(ret);
        return ret;
    }


}
