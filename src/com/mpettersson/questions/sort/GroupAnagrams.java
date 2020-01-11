package com.mpettersson.questions.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 *     GROUP ANAGRAMS
 *
 *     Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class GroupAnagrams  {

    public static<T> void printArray(T[] array){
        System.out.print("[");
        for(T t : array){
            System.out.print(" " + t);
        }
        System.out.println(" ]");
    }


    public static void main(String[] args) {
        String[] stringArray = new String[]{"they", "they see", "real", "fun", "real fun", "race", "dirty room",
                "the eyes", "fights", "care", "listens", "silent", "dormitory", "acre", "funeral"};

        printArray(stringArray);

        Arrays.sort(stringArray, new AnagramComparator());
    }
}

/**
 * Comparator interface is used to order the objects of user-defined classes.
 * A comparator object is capable of comparing two objects of two different classes.
 */
class AnagramComparator implements Comparator<String>{
    public String sortChars(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public int compare(String s1, String s2){
        return sortChars(s1).compareTo(sortChars(s2));
    }
}
