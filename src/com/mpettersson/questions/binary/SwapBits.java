package com.mpettersson.questions.binary;

/**
 *    SWAP BITS (EPI 5.2)
 *
 *    Write a method that when given a number (num) and two indexes (i & j), swaps the ith and jth bit in the number num
 *    (where the LSB is at index 0).
 *
 *    Example:
 *      Input =  0b010001001, 1, 7
 *      Output = 0b000001011
 *
 *    NOTE: Java will truncate the output to 1011.
 */
public class SwapBits {

    public static int swapBits(int num, int i, int j){
        if((num >> i & 1) != (num >> j & 1)){
            num ^= (1 << i) | (1 << j);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println("swapBits(0b010001001, 1, 7): " + Integer.toBinaryString(swapBits(0b010001001, 1, 7)));
        System.out.println("swapBits(0b010001001, 6, 0): " + Integer.toBinaryString(swapBits(0b010001001, 6, 0)));
    }
}

