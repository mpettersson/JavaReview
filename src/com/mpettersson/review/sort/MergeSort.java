package com.mpettersson.review.sort;

import java.util.Arrays;

/**
 *     MERGE SORT
 *
 *     Average Runtime:    O(n log(n))
 *     Worst Runtime:      O(n log(n))
 *     Best Runtime:       O(n log(n))
 *     Space Complexity:   O(n)
 *     Alg Paradigm:       Divide and Conquer
 *     Sorting In Place:   No      (in a typical implementation)
 *     Stable:             Yes     (does not change the relative order of elements with equal keys)
 *     Online:             NO      (can sort a list as it receives it)
 *
 *     Find the middle index.
 *     Call Merge Sort on everything up to (and including) the middle.
 *     Call Merge Sort on everything after the middle.
 *     Merge the sorted halves.
 */
public class MergeSort {
    public static<T extends Comparable> void mergeSort(T[] arr){
        if(arr != null && arr.length >1){
            int mid = arr.length / 2;
            T[] left = Arrays.copyOfRange(arr, 0, mid);
            T[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            int i = 0, j = 0, k = 0;

            // Copy sorted data (from left and right) into original array
            while(i < left.length && j < right.length){
                if(left[i].compareTo(right[j]) == -1 ){
                    arr[k] = left[i];
                    i++;
                }else{
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }
            // Finish copying data from (ONLY left OR right) into original array (if there is still some left).
            while(i < left.length){
                arr[k] = left[i];
                i++;
                k++;
            }

            while(j < right.length){
                arr[k] = right[j];
                j++;
                k++;
            }
        }
    }

    public static<T> void printArray(T[] array){
        System.out.print("[");
        for(T t : array){
            System.out.print(" " + t);
        }
        System.out.println(" ]");
    }

    public static void main(String[] args){

        Integer[] array = new Integer[]{44, 77, 59, 39, 41, 69, 68, 10, 72, 99, 72, 11, 41, 37, 11, 72, 16, 22, 10, 100};
        printArray(array);
        MergeSort.mergeSort(array);
        printArray(array);



    }
}

