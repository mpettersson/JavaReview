package com.mpettersson.questions.binary;

/**
 *    PARITY OF A BINARY NUMBER (EPI 5.1)
 *
 *    The parity of a binary number is 1 if the number of 1s is odd; otherwise, it is 0.
 *    Write a method that accepts a positive number n and returns the parity of the binary representation of the number.
 *
 *    Example:
 *      Input = 0b1011
 *      Output = 1
 */
public class Parity {

    // Brute force approach: Runtime is O(n) where n is the size of the binary representation of the number.
    public static int bruteForceParity(int n){
        int res = 0;

        while(n > 0){
            if((n & 1) == 1){
                res ^= 1;
            }
            n >>= 1;
        }

        return res;
    }

    // Improved approach: Runtime is O(k) where k is the number of 1s in the binary representation of the number.
    public static int countOnlyOnesParity(int n){
        int res = 0;

        while(n > 0){
            n &= (n - 1);
            res ^= 1;
        }

        return res;
    }

    // An efficient O(log n) approach:
    public static int parity(int n){
        n ^= n >> 16;
        n ^= n >> 8;
        n ^= n >> 4;
        n ^= n >> 2;
        n ^= n >> 1;
        return n & 1;
    }


    public static void main(String[] args) {

        System.out.println("bruteForceParity(0b1011): " + bruteForceParity(0b1011));
        System.out.println("bruteForceParity(0b1001): " + bruteForceParity(0b1001));
        System.out.println();

        System.out.println("countOnlyOnesParity(0b1011): " + countOnlyOnesParity(0b1011));
        System.out.println("countOnlyOnesParity(0b1001): " + countOnlyOnesParity(0b1001));
        System.out.println();

        System.out.println("parity(0b1011): " + parity(0b1011));
        System.out.println("parity(0b1001): " + parity(0b1001));
        System.out.println();
    }
}
