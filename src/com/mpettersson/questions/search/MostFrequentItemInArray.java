package com.mpettersson.questions.search;


import java.util.Arrays;
import java.util.HashMap;

/**
 *     MOST FREQUENTLY OCCURRING ITEM IN AN ARRAY
 *
 *     Write a method to find the most frequently occurring item/element in a array.
 *
 *     Example:
 *          Input = [1, 3, 1, 3, 2, 1]
 *          Output = 1
 */
public class MostFrequentItemInArray {
    public static int mostFrequentItemInArray(int[] arr){
        if(arr == null || arr.length ==0){
            throw new IllegalArgumentException("int array must have at least one item.");
        }

        int mfi = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i : arr){
            if(hashMap.containsKey(i)){
                hashMap.put(i, hashMap.get(i) + 1);
            }else{
                if(hashMap.size() == 0){
                    mfi = i;
                }
                hashMap.put(i, 1);
            }
            if(hashMap.get(i) > hashMap.get(mfi)){
                mfi = i;
            }
        }

        return mfi;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 1, 3, 2, 1};
        int[] arr2 = {1, 3, 1, 3, 2, 1, 3, 3, 2, 1, 3, 3, 3};
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println();

        System.out.println("mostFrequentItemInArray(arr1):" + mostFrequentItemInArray(arr1));
        System.out.println("mostFrequentItemInArray(arr2):" + mostFrequentItemInArray(arr2));

        System.exit(0);
    }
}
