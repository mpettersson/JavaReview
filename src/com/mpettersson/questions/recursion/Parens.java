package com.mpettersson.questions.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *  PARENS
 *
 *  Implement an alg to print all valid (e.g., properly opened & closed) combinations of N pairs of parenthesis.
 *
 *  Example:
 *      Input: N = 3
 *      Output: ((())), (()()), (())(), ()(()), ()()()
 */
public class Parens {

    // Approach 1: Recursive approach; build the sol for f(n) by adding pairs of paren to f(n-1).
    // This can be done by inserting a pair of paren inside every pair, as well as at the beginning.
    // Any other places that we could insert paren, such as the END, would reduce to the base case.
    // NOTE: This IS NOT EFFECTIVE because it waste time creating DUPLICATE combinations.
    static Set<String> generateParens1(int n) {
        Set<String> set = new HashSet<>();
        if (n == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParens1(n - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = str.substring(0, i + 1) + "()" + str.substring(i + 1, str.length());
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    // Approach 2: Build a string from scratch; on each recursive call we have the index for one char in in the string.
    // The rules for left/right parenthesis are:
    //    Left Paren: As long as we haven't used up all the left paren, we can insert a left paren.
    //    Right Paren: We insert a right paren IFF it won't create a syntax error (aka more right than left parens).
    // NOTE: Because a left and right paren is inserted at each index in the string, and indexes are never repeated,
    // each string is guaranteed to be unique.
    static ArrayList<String> generateParens2(int n){
        char[] str = new char[n*2];
        ArrayList<String> list = new ArrayList<>();
        generateParens2(list, n, n, str, 0);
        return list;
    }

    static void generateParens2(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count){
        System.out.println("list:      " + list + "\n" +
                "leftRem:  " + leftRem + "\n" +
                "rightRem: " + rightRem + "\n" +
                "str:      " + String.copyValueOf(str) + "\n" +
                "count:    " + count + "\n" );
        if(leftRem < 0 || rightRem < leftRem){
            return;
        }
        // No more parens left:
        if(leftRem == 0 && rightRem == 0){
            String s = String.copyValueOf(str);
            list.add(s);
        }else{
            // Add the left paren if any are remaining
            if(leftRem > 0){
                str[count] = '(';
                generateParens2(list, leftRem - 1, rightRem, str, count + 1);
            }
            // Add right paren, if expression is valid
            if(rightRem > leftRem){
                str[count] = ')';
                generateParens2(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }



}
