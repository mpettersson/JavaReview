package com.mpettersson.questions.arrays;

import java.util.Arrays;

/**
 *    MINESWEEPER NUMBERS
 *
 *     Given an array of two digit lists, which represent the row and column where mines are located, the total number of
 *     rows, and the total number of columns, write a method that will produce a list of list with the number of mines next
 *     to each index (mines will be represented as -1).
 *
 *     Example:
 *         Input = [[0, 0], [0, 1]], 3, 4)
 *         Output = [[-1, -1, 1, 0],
 *                   [ 2,  2, 1, 0],
 *                   [ 0,  0, 0, 0]]
 */
public class MinesweeperNumbers {
    public static int[][] minesweeperNumbers(int[][] bombs, int numRows, int numCols){
        int[][] matrix = new int[numRows][numCols];
        for(int[] b : bombs){
            int ri = b[0];
            int ci = b[1];
            matrix[ri][ci] = -1;
            for(int r = ri - 1; r < ri + 2; r++){
                for(int c = ci - 1; c < ci + 2; c++){
                    if(r >= 0 && r < numRows && c >= 0 && c < numCols && matrix[r][c] != -1){
                        matrix[r][c]++;
                    }
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] bombs1 = {{0, 0}, {0, 1}};
        System.out.println("minesweeperNumbers(bombs1, 3, 4): " + Arrays.deepToString(minesweeperNumbers(bombs1, 3, 4)));

        int[][] bombs2 = {{0, 2}, {2, 0}};
        System.out.println("minesweeperNumbers(bombs2, 3, 3): " + Arrays.deepToString(minesweeperNumbers(bombs2, 3, 3)));

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        System.out.println("minesweeperNumbers(bombs3, 5, 5): " + Arrays.deepToString(minesweeperNumbers(bombs3, 5, 5)));

    }
}
