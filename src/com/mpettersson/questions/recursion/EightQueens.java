package com.mpettersson.questions.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *    EIGHT QUEENS (CCI 8.12)
 *
 *    Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of them share
 *    the same row, column, or diagonal. In this case, "diagonal" means all diagonals, not just the two that bisect the
 *    board.
 */
public class EightQueens {

    public static final int GRID_SIZE = 8;

    public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
        if (row == GRID_SIZE){
            results.add(columns.clone());                   // Found valid placement
        }else{
            for (int col = 0; col < GRID_SIZE; col++){
                if(checkValid(columns, row, col)){
                    columns[row] = col;                     // Place Queen
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    // Check if (row, column) is a valid spot for a Queen.
    // NOTE: Don't need to check Row because we are using a one dimensional array to represent the board.
    public static boolean checkValid(Integer[] columns, int row1, int column1){
        for(int row2 = 0; row2 < row1; row2++){
            int column2 = columns[row2];
            if(column1 == column2){ return false; }             // Check Column: Are two Queens on same column?
            int columnDistance = Math.abs(column2 - column1);   // Check diagonal: If distance between columns is equal
            int rowDistance = row1 - row2;                      //   to the distance between the rows, then they are on
            if(columnDistance == rowDistance){ return false; }  //   the same diagonal.
        }
        return true;
    }

    public static void printBoard(Integer[] columns) {
        drawLine();
        for(int i = 0; i < GRID_SIZE; i++){
            System.out.print("|");
            for (int j = 0; j < GRID_SIZE; j++){
                if (columns[i] == j) {
                    System.out.print("Q|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.print("\n");
            drawLine();
        }
        System.out.println("");
    }

    private static void drawLine() {
        StringBuilder line = new StringBuilder();
        for (int i=0;i<GRID_SIZE*2+1;i++)
            line.append('-');
        System.out.println(line.toString());
    }

    public static void printBoards(ArrayList<Integer[]> boards) {
        for (int i = 0; i < boards.size(); i++) {
            Integer[] board = boards.get(i);
            printBoard(board);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        Integer[] columns = new Integer[GRID_SIZE];
        Arrays.fill(columns,  -1);              // Default values.
        placeQueens(0, columns, results);
        printBoards(results);
        System.out.println(results.size());
    }
}
