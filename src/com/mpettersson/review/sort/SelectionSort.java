package com.mpettersson.review.sort;

/**
 *     SELECTION SORT
 *
 *     Average Runtime:    O(n**2)
 *     Worst Runtime:      O(n**2)
 *     Best Runtime:       O(n**2)
 *     Space Complexity:   O(1)
 *     Alg Paradigm:       Incremental Approach
 *     Sorting In Place:   Yes
 *     Stable:             No      (default does change the relative order of elements with equal keys)
 *     Online:             No      (can't sort a list as it receives it)
 *
 *     Think of a childs algorithm...
 *     Put the smallest in first index...
 *
 *     Given a list, take the current element (starting at 0) and exchange it with the smallest element on the right hand
 *     side of the current element. Continue doing this, incrementing the index of current element by 1 until it's sorted.
 */
public class SelectionSort {
    public static<T extends Comparable> void selectionSort(T[] arr){
        if(arr != null && arr.length > 1){
            for(int i = 0; i < arr.length - 1; i++){
                int min_index = i;
                for(int j = i + 1; j < arr.length; j++){
                    if(arr[j].compareTo(arr[min_index]) == -1){
                        min_index = j;
                    }
                }
                T temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
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
        SelectionSort.selectionSort(array);
        printArray(array);
    }

}
