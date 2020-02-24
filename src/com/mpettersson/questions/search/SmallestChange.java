package com.mpettersson.questions.search;


import java.util.Arrays;

/**
 *     SMALLEST CHANGE
 *
 *     Given a array of ints representing a set of coins, what is the smallest amount that can't be made?
 *     That is, write a program which takes an array of positive ints and returns the smallest number greater than zero,
 *     which is not a sum of a subset of elements of the array.
 *
 *     Example:
 *          input = [1, 10, 1, 5, 1, 1, 1, 25]
 *          output = 21
 *          input = [12, 2, 1, 15, 2, 4]
 *          output = 10
 *
 *     This question is from Elements of Programming Interviews; SEE https://elementsofprogramminginterviews.com/.
 */
public class SmallestChange {

    // Time complexity is O(n log n), space complexity is O(1).
    public static int smallestChange(int[] arr){
        int currSmallest = 0;
        Arrays.sort(arr);
        for(int i : arr){
            if(i > currSmallest + 1){
                break;
            }
            currSmallest += i;
        }
        return currSmallest + 1;
    }


    public static void main(String[] args) {
        int[] arr1 = {12, 2, 1, 15, 2, 4};
        int[] arr2 = {1, 10, 1, 5, 1, 1, 1, 25};

        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println();

        System.out.println("smallestChange(arr1): " + smallestChange(arr1));
        System.out.println("smallestChange(arr2): " + smallestChange(arr2));
    }
}
