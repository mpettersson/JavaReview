package com.mpettersson.questions.arrays;

import java.util.Arrays;

/**
 *  MAGIC INDEX
 *
 *  A magic index in an array A[0 ... n-1] is defined to be an index such that A[i] = i.
 *  Given an array of sorted distinct integers, write a method to find a magic index, if one exists, in array A.
 */

public class MagicIndex {
    public static void main(String[] args) {

    }

    public static int magicFast(int[] array){
        return magicFast(array, 0, array.length - 1);
    }

    public static int magicFast(int[] array, int start, int end){
        if(end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if(array[mid] == mid){
            return mid;
        }else if (array[mid] > mid){
            return magicFast(array, start, mid - 1);
        }else{
            return magicFast(array, mid + 1, end);
        }
    }


    public int findMagicIndex(int[] a){
        for(int i = 0; i < a.length; i++) {
            if(a[i] == i){
                return i;
            }
        }
        return -1;
    }
}
