package com.mpettersson.review.search;

import java.util.Arrays;

/**
 *     BINARY SEARCH
 *
 *     Average Runtime:    O(log (n))
 *     Worst Runtime:      O(log (n))
 *     Best Runtime:       O(1)
 *     Auxiliary Space:    O(1) Iterative, O(Logn) Recursive
 *
 *     Compare x with the middle element.
 *     If x matches with middle element, we return the mid index.
 *     If x is greater than the mid, then x can only lie in right half (after mid). So we recur for right half.
 *     Else (x is smaller) recur for the left half.
 */
public class BinarySearh {
    // Iterative Approach
    public static<T extends Comparable> int binarySearch(T[] arr, T x){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (high - low) / 2;
            if(arr[mid].compareTo(x) == 1){        // arr[mid] < x
                low = mid + 1;
            }else if(arr[mid].compareTo(x) == -1){   // arr[mid] > x
                high = mid - 1;
            }else{                                  // arr[mid] == x
                return mid;
            }
        }
        return -1;
    }

    // Recursive Approach
    public static <T extends Comparable> int binarySearchRecursive(T[] arr, T x){
        return binarySearchRecursive(arr, x, 0, arr.length - 1);
    }

    // Recursive Approach
    public static<T extends Comparable> int binarySearchRecursive(T[] arr, T x, int low, int high){
        if(low > high){
            return -1;
        }
        int mid = (high - low) / 2;
        if(arr[mid].compareTo(x) == 1){
            return binarySearchRecursive(arr, x, mid + 1, high);
        }else if(arr[mid].compareTo(x) == -1){
            return binarySearchRecursive(arr, x, low, mid - 1);
        }else{
            return mid;
        }
    }

    public static<T> void printArray(T[] array) {
        printArray(array);
    }

    public static<T> void printArray(String s, T[] array){
        System.out.print(s + "[");
        for(T t : array){
            System.out.print(" " + t);
        }
        System.out.println(" ]");
    }


    public static void main(String[] args) {

        Integer nonexistentInt = -1;
        Integer intInArray = 10;
        Double doubInArray = 7.682648719820321;

        Integer[] intArray = new Integer[]{75, 45, -29, 41, -28, 10, 27, 99, 49, -75,
                                          -28, 80, -28, -59, -95, -79, -62, 92, 52, 21};
        Double[] doubArray = new Double[]{7.682648719820321, 93.85895667845071, -62.10905854133679, 48.90184507673945,
                                        -67.86972048473552,  62.87769120151333, 35.97419305430432, -46.28939280516444,
                                         47.91073995583906, -53.42711804228693};

        System.out.println("Unsorted Arrays");
        printArray("intArray: ", intArray);
        printArray("doubArray: ", doubArray);
        System.out.println();

        Arrays.sort(intArray);
        Arrays.sort(doubArray);

        System.out.println("Sorted Arrays");
        printArray("intArray: ", intArray);
        printArray("doubArray: ", doubArray);
        System.out.println();

        System.out.println("Iterative Binary Search");
        System.out.println("binarySearch(intArray, " + intInArray + ")" + binarySearch(intArray, intInArray));
        System.out.println("binarySearch(doubArray, " + doubInArray + ")" + binarySearch(doubArray, doubInArray));
        System.out.println();

        System.out.println("Recursive Binary Search");
        System.out.println("binarySearchRecursive(intArray, " + intInArray + ")" + binarySearchRecursive(intArray, intInArray));
        System.out.println("binarySearchRecursive(doubArray, " + doubInArray + ")" + binarySearchRecursive(doubArray, doubInArray));
        System.out.println();

        System.out.println("Search for nonexistent values:");
        System.out.println("binarySearch(intArray, " + nonexistentInt + ")" + binarySearch(intArray, nonexistentInt));
        System.out.println("binarySearchRecursive(intArray, " + nonexistentInt + ")" + binarySearchRecursive(intArray, nonexistentInt));



    }
}
