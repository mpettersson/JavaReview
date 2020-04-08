package com.mpettersson.questions.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RecursionQuestions {




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
//        System.out.println(RecursionQuestions.generateParens2(3));


    }
}
