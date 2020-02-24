package com.mpettersson.review.recursion;

import java.util.Arrays;

/**
 *    DYNAMIC PROGRAMMING
 *
 *     Is an optimization over plain recursion.  Where recursion is just a (recursive) function that directly or
 *     indirectly calls its self.
 *
 *     Dynamic Programming may or may not be recursive.  Each of the sub-problems are indexed some way in memory.
 *
 *     There are two different ways Dynamic Programming is done (or referred to):
 *         (1) Memoization - Top Down
 *         (2) Tabulation - Bottom up
 */
public class DynamicProgramming {


    // PLAIN RECURSIVE FIBONACCI
    // Gets really slow around recursiveFib(40)
    // O(2 ** n) time!!!
    public static long recursiveFib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }


    // TOP DOWN DYNAMIC PROGRAMMING or MEMOIZATION FIBONACCI WITH A LIST
    // Extremely fast. memoizationFib(400) takes a fraction of a second.
    // O(n) runtime, O(n) space!!!
    public static double memoizationFib(int n) {
        double[] arr = new double[n + 1];
        Arrays.fill(arr, -1);
        return memoizationFibonacci(n, arr);
    }

    public static double memoizationFibonacci(int n, double[] arr) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (arr[n] == -1) {
            arr[n] = memoizationFibonacci(n - 1, arr) + memoizationFibonacci(n - 2, arr);
        }
        return arr[n];
    }


    // BOTTOM UP DYNAMIC PROGRAMMING or TABULATION FIBONACCI WITH AN ARRAY
    // Extremely fast. memoizationFib(400) takes a fraction of a second.
    // O(n) runtime, O(n) space!!!
    public static double tabulationListFib(int n){
        if(n == 0 || n == 1) {
            return n;
        }
        double[] arr = new double[n];
        arr[0] = 0;
        arr[1] = 1;
        int i = 2;
        while(i < n) {
            arr[i] = arr[i - 1] + arr[i - 2];
            i += 1;
        }
        return arr[n - 1] + arr[n - 2];
    }


    // BOTTOM UP DYNAMIC PROGRAMMING or TABULATION FIBONACCI WITHOUT AN ARRAY
    // Extremely fast. memoizationFib(400) takes a fraction of a second.
    // O(n) runtime, O(1) space!!!
    public static double tabulationFib(int n) {
        if (n == 0) {
            return 0;
        }
        double a = 0;
        double b = 1;
        int i = 2;
        while (i < n) {
            double c = a + b;
            a = b;
            b = c;
            i++;
        }
        return a + b;
    }


    public static void main(String[] args) {
        int[] little_values = {0, 1, 2, 3, 4, 5, 10, 20, 40};
        int[] larger_values = {50, 100, 150};

        // Plain Recursive Fibonacci
        for(int i : little_values) {
            System.out.println("recursiveFib(" + i + "): " + recursiveFib(i));
        }
        System.out.println();

        // Top Down/Memoization Fibonacci
        for(int i : larger_values) {
            System.out.println("memoizationFib(" + i + "): " + memoizationFib(i));
        }
        System.out.println();


        // Bottom Up/Tabulation (using a array) Fibonacci
        for(int i : larger_values) {
            System.out.println("tabulationListFib(" + i + "): " + tabulationListFib(i));
        }
        System.out.println();


        // Bottom Up/Tabulation (without an array) Fibonacci
        for(int i : larger_values) {
            System.out.println("tabulationFib(" + i + "): " + tabulationFib(i));
        }

    }
}
