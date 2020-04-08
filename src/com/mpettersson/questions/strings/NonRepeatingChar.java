package com.mpettersson.questions.strings;


import java.util.HashMap;

/**
 *     NON-REPEATING CHARACTER
 *
 *     Write a function, which when given a string, will return the first non-repeating character or None if all
 *     characters repeat.
 *
 *     Example:
 *         Input = "aabcb"
 *         Output = "c"
 */
public class NonRepeatingChar {

    // This approach has O(n) time and space.
    public static Character nonRepeatingChar(String s){
        HashMap<Character, Integer> dict = new HashMap<>();
        for(char c : s.toCharArray()){
            dict.put(c, dict.containsKey(c) ? dict.get(c) + 1 : 1);
        }
        for(char k : dict.keySet()){
            if(dict.get(k) == 1){
                return k;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] strings = {"abcab", "aabcb", "aabbbc", "xxyz", "aabbdbc", "abab", "aabb"};

        for(String s : strings){
            System.out.println("nonRepeatingChar(\"" + s + "\" ): " + nonRepeatingChar(s));
        }
    }
}
