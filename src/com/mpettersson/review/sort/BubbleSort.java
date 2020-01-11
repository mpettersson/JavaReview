package com.mpettersson.review.sort;

/**
 *     BUBBLE SORT
 *
 *     Average Runtime:    O(n**2)
 *     Worst Runtime:      O(n**2)
 *     Best Runtime:       O(n)
 *     Space Complexity:   O(1)
 *     Alg Paradigm:       Incremental Approach
 *     Sorting In Place:   Yes
 *     Stable:             Yes    (does not change the relative order of elements with equal keys)
 *     Online:             No     (can not sort a list as it receives it)
 *
 *
 *     Start at the beginning of the array and swap the first two elements if the first is greater than the seconds.
 *     Then, continue on with the next pair, and next, until it is sorted.
 */
public class BubbleSort {
    public static<T extends Comparable> void bubbleSort(T[] arr){
        if(arr != null && arr.length > 1){
            boolean sorted = false;
            while(!sorted){
                sorted = true;
                for(int i = 0; i < arr.length - 1; i++) {
                    if (arr[i + 1].compareTo(arr[i]) == -1) {
                        T temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        sorted = false;
                    }
                }
            }
        }
    }

    public static<T> void printArray(T[] arr){
        System.out.print("[ ");
        for(T t : arr){
            System.out.print(" " + t);
        }
        System.out.println(" ]");
    }

    public static void main(String[] args){

        Integer[] array = new Integer[]{44, 77, 59, 39, 41, 69, 68, 10, 72, 99, 72, 11, 41, 37, 11, 72, 16, 22, 10, 100};
        printArray(array);
        BubbleSort.bubbleSort(array);
        printArray(array);

    }

}

