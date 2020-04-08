package com.mpettersson.questions.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *     COMMON ELEMENTS IN TWO ARRAYS
 *
 *     Write a method that returns the common elements of two (given) arrays.
 *
 *     Example:
 *         Input = [1, 3, 4, 6, 7, 9], [1, 2, 4, 5, 9, 10]
 *         Output = [1, 4, 9]
 */
public class CommonElementsInTwoArrays {

    public static int[] commonElementsInTwoArrays(int[] arr1, int[] arr2){
        ArrayList<Integer> result = new ArrayList<>();

        if(arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0){
            return new int[0];
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i1 = 0, i2 = 0;

        while(i1 < arr1.length && i2 < arr2.length){
            if(arr1[i1] == arr2[i2]){
                result.add(arr1[i1]);
                i1++;
                i2++;
            }else if(arr1[i1] < arr2[i2]){
                i1++;
            }else if(arr1[i1] > arr2[i2]){
                i2++;
            }
        }

        int[] resultIntArray = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            resultIntArray[i] = result.get(i);
        }
        return resultIntArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 6, 7, 9};
        int[] arr2 = {1, 2, 4, 5, 9, 10};
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println();

        System.out.println("commonElementsInTwoArrays(arr1, arr2): " + Arrays.toString(commonElementsInTwoArrays(arr1, arr2)));
    }
}
