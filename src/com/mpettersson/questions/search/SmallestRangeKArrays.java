package com.mpettersson.questions.search;

import java.util.PriorityQueue;

/**
 *      SMALLEST RANGE FROM K LISTS
 *
 *      Given k sorted (ascending) lists of integers (may contain duplicates), find the smallest range that includes an
 *      element from each of the k lists.
 *
 *      The range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
 *
 *      Example:
 *          Input = [[4, 10, 15, 24, 26], [0, 9, 12, 20], [5, 18, 22, 30]]
 *          Output = [20, 24]
 */
public class SmallestRangeKArrays {

    // This runtime is bad...  Don't ever do this.
    public static int[] bruteForceSmallestRange(int[][] nums) {
        int totalCount = 0;
        int minx = 0, miny = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                for (int k = i; k < nums.length; k++) {
                    for (int l = (k == i ? j : 0); l < nums[k].length; l++) {
                        int min = Math.min(nums[i][j], nums[k][l]);
                        int max = Math.max(nums[i][j], nums[k][l]);
                        int n, m;
                        for (m = 0; m < nums.length; m++) {
                            for (n = 0; n < nums[m].length; n++) {
                                totalCount++;
                                if (nums[m][n] >= min && nums[m][n] <= max)
                                    break;
                            }
                            if (n == nums[m].length)
                                break;
                        }
                        if (m == nums.length) {
                            if (miny - minx > max - min || (miny - minx == max - min && minx > min)) {
                                miny = max;
                                minx = min;
                            }
                        }
                    }
                }
            }
        }
        return new int[] {minx, miny, totalCount};
    }


    // The runtime is O(k * n^2), where k is the number of lists and n is the number of items in each list, the space
    // complexity is O(k).
    // NOTE: This algorithm is often INCORRECTLY claimed to have a O(k * n) runtime.
    public static int[] smallestRange(int[][] nums) {
        int totalCount = 0;
        int minx = 0, miny = Integer.MAX_VALUE;
        int[] next = new int[nums.length];
        boolean flag = true;
        for (int i = 0; i < nums.length && flag; i++) {
            for (int j = 0; j < nums[i].length && flag; j++) {
                int min_i = 0, max_i = 0;
                for (int k = 0; k < nums.length; k++) {
                    totalCount++;
                    if (nums[min_i][next[min_i]] > nums[k][next[k]])
                        min_i = k;
                    if (nums[max_i][next[max_i]] < nums[k][next[k]])
                        max_i = k;
                }
                if (miny - minx > nums[max_i][next[max_i]] - nums[min_i][next[min_i]]) {
                    miny = nums[max_i][next[max_i]];
                    minx = nums[min_i][next[min_i]];
                }
                next[min_i]++;
                if (next[min_i] == nums[min_i].length) {
                    flag = false;
                }
            }
        }
        return new int[] {minx, miny, totalCount};
    }



    public static int[] smallestRangeViaPriorityQueue(int[][] nums) {
        int totalCount = 0;
        int minx = 0, miny = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] next = new int[nums.length];
        boolean flag = true;

        PriorityQueue< Integer > min_queue = new PriorityQueue <>((i, j) -> nums[i][next[i]] - nums[j][next[j]]);

        for (int i = 0; i < nums.length; i++) {
            totalCount++;
            System.out.println("min_queue.offer( " + i + " );");
            min_queue.offer(i);
            max = Math.max(max, nums[i][0]);
        }

        for (int i = 0; i < nums.length && flag; i++) {
            for (int j = 0; j < nums[i].length && flag; j++) {
                totalCount++;
                int min_i = min_queue.poll();
                System.out.println("min_queue.poll( " + min_i + " )");
                if (miny - minx > max - nums[min_i][next[min_i]]) {
                    minx = nums[min_i][next[min_i]];
                    miny = max;
                }
                next[min_i]++;
                if (next[min_i] == nums[min_i].length) {
                    flag = false;
                    break;
                }
                System.out.println("min_queue.offer( " + min_i + " );");
                min_queue.offer(min_i);
                max = Math.max(max, nums[min_i][next[min_i]]);
            }
        }
        return new int[] { minx, miny, totalCount};
    }


    public static void main(String[] args) {
        int[][][] arrays =  {{{4, 10, 15, 24, 26}, {0,  9, 12, 20}, {5, 18, 22, 30}},
                             // Worst Case for 5 lists, each with 5 elements.
                             {{-600, -500, -450, 0, 20}, {-580, -490, -445, 2, 19}, {-560, -480, -440, 4, 18}, {-540, -470, -435, 6, 17}, {-520, -460, -430, 8, 16}},
                             // Worst case for 5 lists, each with 4 elements:
                             {{-600, -450, 0, 20}, {-580, -445, 2, 19},{-560, -440, 4, 18},{-540, -435, 6, 17},{-520, -430, 8, 16}}};

        // Brute Force
        for(int[][] a : arrays) {
            int[] result = bruteForceSmallestRange(a);
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // With Pointers
        for(int[][] a : arrays) {
            int[] result = smallestRange(a);
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // With Pointers and PriorityQueue
        for(int[][] a : arrays) {
            int[] result = smallestRangeViaPriorityQueue(a);
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
