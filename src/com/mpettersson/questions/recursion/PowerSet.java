package com.mpettersson.questions.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *    POWER SET
 *
 *     Write a method to return all subsets of a set.
 */
public class PowerSet {

    static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set){
        return getSubsets(set, 0);
    }


    static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allsubsets;

        // Base Case - add empty set
        if(set.size() == index){
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>()); // empty set
        }else{
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset : allsubsets){
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    static ArrayList<ArrayList<Integer>> getSubsetsUsingBitArray(ArrayList<Integer> set){
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();

        // Compute 2^n
        int max = 1 << set.size();
        for(int k = 0; k < max; k++){
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allsubsets.add(subset);
        }
        return allsubsets;
    }

    static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set){
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for(int k = x; k > 0; k >>= 1){
            if((k & 1) == 1){
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

    static void printSets(ArrayList<ArrayList<Integer>> sets){
        System.out.print("{");
        for(ArrayList l : sets){
            System.out.print("{");
            for(Object o: l){
                System.out.print(" " + o);
            }
            System.out.print(" }");
        }
        System.out.print(" }");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>(Arrays.asList(1,3,4,9));
        ArrayList<ArrayList<Integer>> sets = getSubsets(set);
        printSets(sets);

        ArrayList<Integer> set1 = new ArrayList<>(Arrays.asList(1,3,4,9));
        ArrayList<ArrayList<Integer>> sets1 = getSubsetsUsingBitArray(set);
        printSets(sets1);


    }

}
