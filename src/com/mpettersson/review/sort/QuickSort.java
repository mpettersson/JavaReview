package com.mpettersson.review.sort;

/**
 *     QUICK SORT
 *
 *     Average Runtime:    O(n log(n))
 *     Worst Runtime:      O(n**2)
 *     Best Runtime:       O(n log(n))
 *     Space Complexity:   O(log(n))
 *     Alg Paradigm:       Divide and Conquer
 *     Sorting In Place:   Yes
 *     Stable:             No      (the default alg changes the relative order of elements with equal keys)
 *     Online:             No      (can sort a list as it receives it)
 *
 *     Pick a random element (convention uses last), then swap the elements such that all of the elements smaller than
 *     it comes before, and everything larger comes after. Recursively do this on the "smaller" and "larger" elements.
 */
public class QuickSort {
    public static<T extends Comparable> void quickSort(T[] arr){
        if(arr != null){
            quickSort(arr, 0, arr.length - 1);
        }
    }

    public static<T extends Comparable> void quickSort(T[] arr, int left, int right){
        if(left < right){
            int index = partition(arr, left, right);

            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    public static<T extends Comparable> int partition(T[] arr, int left, int right){
        int i = left - 1;
        T pivot_value = arr[right];

        for(int j = left; j < right; j++){
            // If current element is smaller than or equal to pivot:
            if(arr[j].compareTo(pivot_value) != 1){
                // Increment index of smaller element:
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        T temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
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
        QuickSort.quickSort(array);
        printArray(array);
    }
}
