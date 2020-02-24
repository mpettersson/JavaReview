package com.mpettersson.questions.strings;

/**
 *     ONE AWAY (CCI 1.5)
 *
 *     Write a method, which given two strings, will return True if the two strings are one edit away from each other.
 *     An edit can be adding, deleting, or changing a character.
 *
 *     Example:
 *         Input = "abcde", "abfde"
 *         Output = True
 */
public class OneAway {

    // Runtime is O(n), where n is the length of the shorter string, and space complexity is O(1).
    public static boolean isOneAway(String s1, String s2){
        if(s1.length() == s2.length()){
            return isOneAwaySameLen(s1, s2);
        }else{
            return isOneAwayDiffLen(s1, s2);
        }
    }

    public static boolean isOneAwaySameLen(String s1, String s2){
        int num_diff = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                num_diff++;
                if(num_diff > 1){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isOneAwayDiffLen(String s1, String s2){
        if(s1.length() + 1 == s2.length() || s1.length() == s2.length() + 1) {
            if (s1.length() < s2.length()) {
                String temp = s1;
                s1 = s2;
                s2 = temp;
            }
            int i = 0;
            int num_diff = 0;
            while(i < s2.length()){
                if(s1.charAt(i + num_diff) == s2.charAt(i)) {
                    i++;
                }else{
                    num_diff++;
                    if(num_diff > 1){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("True test cases:");
        System.out.println("isOneAway(\"abcde\", \"abcd\"): " + isOneAway("abcde", "abcd"));
        System.out.println("isOneAway(\"abde\", \"abcde\"): " + isOneAway("abde", "abcde"));
        System.out.println("isOneAway(\"a\", \"a\"): " + isOneAway("a", "a"));
        System.out.println("isOneAway(\"abcdef\", \"abqdef\"): " + isOneAway("abcdef", "abqdef"));
        System.out.println("isOneAway(\"abcdef\", \"abccef\"): " + isOneAway("abcdef", "abccef"));
        System.out.println("isOneAway(\"abcdef\", \"abcde\"): " + isOneAway("abcdef", "abcde"));
        System.out.println();

        System.out.println("False test cases:");
        System.out.println("isOneAway(\"aaa\", \"abc\"): " + isOneAway("aaa", "abc"));
        System.out.println("isOneAway(\"abcde\", \"abc\"): " + isOneAway("abcde", "abc"));
        System.out.println("isOneAway(\"abc\", \"abcde\"): " + isOneAway("abc", "abcde"));
        System.out.println("isOneAway(\"abc\", \"bcc\"): " + isOneAway("abc", "bcc"));
    }
}
