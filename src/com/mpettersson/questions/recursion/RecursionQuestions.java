package com.mpettersson.questions.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RecursionQuestions {

    /**
     * PARENS
     * <p>
     * Implement an alg to print all valid (e.g., properly opened & closed) combinations of N pairs of parenthesis.
     * <p>
     * Example:
     * Input: N = 3
     * Output: ((())), (()()), (())(), ()(()), ()()()
     */
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



    /**
     *  PERMUTATIONS WITHOUT DUPS
     *
     *     Write a method to compute all permutations of a string of unique characters.
     */

    // NOTE: This takes O(n!) time (this is the best we can do since every permutation of a string of size n is n!).

    // Approach 1: Building from permutations of first n-1 CHARACTERS.
    static ArrayList<String> getPermsWithoutDups1(String str){
        if(str == null){
            return null;
        }
        ArrayList<String> permutations = new ArrayList<>();
        if(str.length() == 0){
            permutations.add("");
            return permutations;
        }
        char head = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> words = getPermsWithoutDups1(remainder);
        for(String word : words){
            for(int j = 0; j <= word.length(); j++){
                String s = word.substring(0, j) + head + word.substring(j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    // Approach 2a: Building from permutations of all n-1 CHARACTER SUBSTRINGS, passing permutations back up the stack.
    static ArrayList<String> getPermsWithoutDups2a(String remainder){
        int len = remainder.length();
        ArrayList<String> result = new ArrayList<>();
        if(len == 0){
            result.add("");
            return result;
        }
        for(int i = 0; i < len; i++){
            String head = remainder.substring(0, i);
            String tail = remainder.substring(i + 1, len);
            ArrayList<String> partials = getPermsWithoutDups2a(head + tail);
            for(String s : partials){
                result.add(remainder.charAt(i) + s);
            }
        }
        return result;
    }

    // Approach 2b: Building from permutations of all n-1 CHARACTER SUBSTRINGS, pushing the prefix down the stack.
    static ArrayList<String> getPermsWithoutDups2b(String str) {
        ArrayList<String> result = new ArrayList<>();
        getPermsWithoutDups2b("", str, result);
        return result;
    }
    static void getPermsWithoutDups2b(String prefix, String remainder, ArrayList<String> result) {
        if(remainder.length() == 0){
            result.add(prefix);
        }
        int len = remainder.length();
        for(int i = 0; i < len; i++){
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            char c = remainder.charAt(i);
            getPermsWithoutDups2b(prefix + c, before + after, result);
        }
    }

    /**
     *  PERMUTATIONS WITH DUPS
     *
     *     Write a method to compute all permutations of a string of non-unique characters.
     */
    static ArrayList<String> getPermsWithDups(String s){
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        getPermsWithDups(map, "", s.length(), result);
        return result;
    }

    static void getPermsWithDups(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result){
        if(remaining == 0){
            result.add(prefix);
            return;
        }
        for(Character c : map.keySet()){
            int count = map.get(c);
            if(count > 0){
                map.put(c, count - 1);
                getPermsWithDups(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }
    }



}

class RecursionQuestionsDriver{

    public static void main(String[] args) {

        // PERMUTATIONS WITHOUT DUPS
        System.out.println(RecursionQuestions.getPermsWithoutDups1("ABC"));
        System.out.println(RecursionQuestions.getPermsWithoutDups2a("ABC"));
        System.out.println(RecursionQuestions.getPermsWithoutDups2b("ABC"));
        System.out.println();


        // PERMUTATIONS WITHOUT DUPS
        System.out.println("getPermsWithDups(\"AAAAAAAAAAABC\").size(): " + RecursionQuestions.getPermsWithDups("AAAAAAAAAAABC").size());
        System.out.println();


        // PARENTHESES
        System.out.println(RecursionQuestions.generateParens2(3));


    }
}
