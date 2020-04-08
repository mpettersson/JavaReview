package com.mpettersson.questions.recursion;

import java.util.ArrayList;

/**
 *    NUM WAYS TO DECODE (HARD)
 *
 *    Given a string of digits that represents an encoded message (data), write a method to count the number of ways to
 *    decode the message.  You can assume that the message (data) only contains the characters zero through nine [0-9].
 *
 *    The encoding function is:
 *        'a' --> 1
 *        'b' --> 2
 *             .
 *             .
 *             .
 *        'y' --> 25
 *        'z' --> 26
 *
 *    Example:
 *        Input = "12"
 *        Output = 2 ("12" can represent "ab" OR "l")
 */
public class NumWaysToDecode {

    // Recursive Approach: O(2**n) time, O(1) space.
    public static int numWaysToDecodeRecursive(String data){
        return numWaysToDecodeRec(data, data.length());
    }

    public static int numWaysToDecodeRec(String data, int k){
        if(k == 0){
            return 1;
        }

        int start = data.length() - k;

        if(data.charAt(start) == '0'){
            return 0;
        }

        int result = numWaysToDecodeRec(data, k - 1);

        if(k >= 2 && Integer.parseInt(data.substring(start,start+2)) <= 26){
            result += numWaysToDecodeRec(data, k - 2);
        }

        return result;
    }

    // Top Down Dynamic Programming Approach: O(n) time, O(n) space.
    public static int numWaysToDecodeTDDP(String data){
        ArrayList<Integer> memo = new ArrayList<>();
        for(int i = 0; i <= data.length(); i++){memo.add(null);}
        return numWaysToDecodeTD(data, data.length(), memo);
    }

    public static int numWaysToDecodeTD(String data, int k, ArrayList<Integer> memo){
        if(k == 0){
            return 1;
        }

        int start = data.length() - k;

        if(data.charAt(start) == '0'){
            return 0;
        }

        if(memo.get(k) != null){
            return memo.get(k);
        }

        int result = numWaysToDecodeTD(data, k - 1, memo);

        if(k >= 2 && Integer.parseInt(data.substring(start,start+2)) <= 26){
            result += numWaysToDecodeTD(data, k - 2, memo);
        }

        memo.set(k, result);

        return result;
    }


    public static void main(String[] args) {
        String[] inputs = {"3", "", "12345", "111111", "27345", "101", "011"};  // NOTE: "101" is valid, "011" is NOT.

        for(String s : inputs) {
            System.out.println("numWaysToDecodeRecursive(" + s + "): " + numWaysToDecodeRecursive(s));
        }
        System.out.println();


        for(String s : inputs) {
            System.out.println("numWaysToDecodeTDDP(" + s + "): " + numWaysToDecodeTDDP(s));
        }

    }
}
