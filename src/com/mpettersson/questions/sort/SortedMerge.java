package com.mpettersson.questions.sort;

/**
 *     SORTED MERGE
 *
 *     You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
 *     Write a method to merge B into A in sorted order.
 */
public class SortedMerge {
    public static void sortedMerge(int[] a, int[] b){
        if(a != null && b != null && a.length > 0 && b.length > 0){
            int end = a.length - 1;
            int x = end - b.length;
            int y = b.length -1;


            while(y >= 0) {
                if(a[x] > b[y]) {
                    a[end] = a[x];
                    x -= 1;
                }else {
                    a[end] = b[y];
                    y -= 1;
                }
                end -= 1;
            }
        }
    }

    public static void printArray(int[] array){
        System.out.print("[");
        for(int t : array){
            System.out.print(" " + t);
        }
        System.out.println(" ]");
    }


    public static void main(String[] args) {
        int[] a = new int[7];
        a[0] = 0;
        a[1] = 1;
        a[2] = 3;
        a[3] = 11;
        int[] b = new int[]{0, 10, 12};

        sortedMerge(a, b);
        printArray(a);

    }
}
