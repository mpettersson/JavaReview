package com.mpettersson.questions.arrays;


/**
 *     ROTATE MATRIX (CCI 1.7)
 *
 *     Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate
 *     the image by 90 degrees.  Can you do this in place?
 *
 *     Example:
 *         Input =  {{'00', '01'},
 *                   {'10', '11'}}
 *         Output = {{'10', '00'},
 *                   {'11', '01'}}
 *
 *     NOTE: Given that the matrix is square (NxN), it is unnecessary to use additional space.
 *
 *     Variations of this question can include:
 *         - Rotate a non-square (NxM) matrix.
 *         - Rotate counter clockwise.
 */
public class RotateMatrix {


    // Out-Of-Place Approach: Runtime and Space is O(NM)
    // NOTE: Works on non-square (NxM) lists.
    public static String[][] rotateMatrixOutOfPlace(String[][] matrix){
      int mRows = matrix.length;
      int mCols = matrix[0].length;
      String[][] rotatedMatrix = new String[mCols][mRows];
      for(int row = 0; row < mRows; row++){
        for(int col = 0; col < mCols; col++){
          int rRow = col;
          int rCol = mRows - 1 - row;
          rotatedMatrix[rRow][rCol] = matrix[row][col];
        }
      }
      return rotatedMatrix;
    }


    // In-Place Approach: The (best possible) runtime is O(n^2).
    // NOTE: Does NOT work on non-square (NxM) lists.
    public static String[][] rotateMatrixInPlace(String[][] m){
      int n = m.length;
      for(int layer = 0; layer < n / 2; layer++) {
        int first = layer;
        int last = n - 1 - layer;
        for (int i = first; i < last; i++) {
          int offset = i - first;
          String top = m[first][i];                            // Save Top
          m[first][i] = m[last - offset][first];               // Left   --> Top
          m[last - offset][first] = m[last][last - offset];    // Bottom --> Left
          m[last][last - offset] = m[i][last];                 // Right  --> Bottom
          m[i][last] = top;                                    // Top    --> Right
        }
      }
      return m;
    }


    public static String formatMatrix(String[][] matrix){
      StringBuilder sb = new StringBuilder();
      for(String[] rows : matrix){
        sb.append("\n");
        for(String s: rows){
          sb.append(String.format("%4s", s));
        }
      }
      return sb.toString();
    }


    public static void main(String[] args) {

      String[][] m0 = {{"00", "01"},
                       {"10", "11"}};
      System.out.println("m0: " + formatMatrix(m0));
      System.out.println("rotateMatrixOutOfPlace(m0):" + formatMatrix(rotateMatrixOutOfPlace(m0)) + "\n");

      String[][] m1 = {{"00", "01", "02", "03", "04"},
                       {"10", "11", "12", "13", "14"},
                       {"20", "21", "22", "23", "24"},
                       {"30", "31", "32", "33", "34"},
                       {"40", "41", "42", "43", "44"},
                       {"50", "51", "52", "53", "54"},
                       {"60", "61", "62", "63", "64"},
                       {"70", "71", "72", "73", "74"},
                       {"80", "81", "82", "83", "84"},
                       {"90", "91", "92", "93", "94"}};
      System.out.println("m1: " + formatMatrix(m1));
      System.out.println("rotateMatrixOutOfPlace(m1):" + formatMatrix(rotateMatrixOutOfPlace(m1)) + "\n");


      String[][] m2 = {{"00", "01"},
                       {"10", "11"}};
      System.out.println("m2: " + formatMatrix(m2));
      System.out.println("rotateMatrixInPlace(m2):" + formatMatrix(rotateMatrixInPlace(m2)) + "\n");


      String[][] m3 = {{"00", "01", "02"},
                       {"10", "11", "12"},
                       {"20", "21", "22"}};
      System.out.println("m3: " + formatMatrix(m3));
      System.out.println("rotateMatrixInPlace(m3):" + formatMatrix(rotateMatrixInPlace(m3)) + "\n");


      String[][] m4 = {{"00", "01", "02", "03"},
                       {"10", "11", "12", "13"},
                       {"20", "21", "22", "23"},
                       {"30", "31", "32", "33"}};
      System.out.println("m4: " + formatMatrix(m4));
      System.out.println("rotateMatrixInPlace(m4):" + formatMatrix(rotateMatrixInPlace(m4)) + "\n");


      String[][] m5 = {{"00", "01", "02", "03", "04"},
                       {"10", "11", "12", "13", "14"},
                       {"20", "21", "22", "23", "24"},
                       {"30", "31", "32", "33", "34"},
                       {"40", "41", "42", "43", "44"}};
      System.out.println("m5: " + formatMatrix(m5));
      System.out.println("rotateMatrixInPlace(m5):" + formatMatrix(rotateMatrixInPlace(m5)) + "\n");



    }
}
