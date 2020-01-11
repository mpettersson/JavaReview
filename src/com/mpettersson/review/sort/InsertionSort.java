package com.mpettersson.review.sort;

/**
 *     INSERTION SORT
 *
 *     Average Runtime:    O(n**2)
 *     Worst Runtime:      O(n**2) (elements are sorted in reverse order)
 *     Best Runtime:       O(n)    (elements are already sorted)
 *     Space Complexity:   O(1)
 *     Alg Paradigm:       Incremental Approach
 *     Sorting In Place:   Yes
 *     Stable:             Yes     (does not change the relative order of elements with equal keys)
 *     Online:             Yes     (can sort a list as it receives it)
 *
 *     Like sorting a deck of cards, you have a sorted side (usually right) and an unsorted side (usually left).
 *     You compare one card at a time, starting with the second card, moving it to the correct place in the sorted side.
 *     Increasing the sorted side by one card at a time.
 */
public class InsertionSort {
    public static<T extends Comparable> void insertionSort(T[] arr){
        if(arr != null && arr.length > 1){
            for(int i = 1; i < arr.length; i++){

                // key_value temporarily holds the value being compared,
                T key_value = arr[i];
                int j = i - 1;

                // While the values on the left are larger than key_value, they get moved right by one.
                while(j >= 0 && arr[j].compareTo(key_value) == 1){
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }

                // Copy key_value to the proper index.
                arr[j + 1] = key_value;
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
        InsertionSort.insertionSort(array);
        printArray(array);
    }
}
