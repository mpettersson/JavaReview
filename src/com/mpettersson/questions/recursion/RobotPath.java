package com.mpettersson.questions.recursion;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *     ROBOTS IN A GRID
 *
 *     Imagine a robot sitting on the upper left corner of a gird with R rows and C columns.
 *     The robot can only move in two directions, right and down, but certain cells are "off limits", such that the
 *     robot cannot step on them.
 *     Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class RobotPath {

    public static void main(String[] args) {
        boolean[][] maze = {{true, false, true, true, true, true, true, true, true, true},
                            {true, false, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true},
                            {false, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, false, true, true, true},
                            {true, true, true, true, false, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, false, true},
                            {true, true, true, true, true, false, true, true, true, false},
                            {true, true, true, true, true, true, true, false, true, true},
                            {true, true, true, true, true, true, true, true, false, true}};

        ArrayList<Point> path = getPath(maze);
        System.out.print("(");
        for(Point p : path){
            System.out.print("(" + p.x + "," + p.y + ")");
        }
        System.out.println(")");
    }

    public static ArrayList<Point> getPath(boolean[][] maze){
        if(maze == null || maze.length == 0){
            return null;
        }
        HashMap<Point, Boolean> cache = new HashMap<>();
        ArrayList<Point> path = new ArrayList<>();
        if(getPath(maze, maze.length - 1, maze[0].length - 1, path, cache)){
            return path;
        }
        return null;
    }

    public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashMap<Point, Boolean> cache){
        if(col < 0 || row < 0 || !maze[row][col]){
            return false;
        }
        Point p = new Point(col, row);
        if(cache.containsKey(p)){
            return cache.get(p);
        }
        boolean isAtOrigin = (col == 0) && (row == 0);
        boolean success = false;
        if(isAtOrigin || getPath(maze, col - 1, row, path, cache) || getPath(maze, col, row - 1, path, cache)){
            path.add(p);
            success = true;
        }
        cache.put(p, success);
        return success;
    }
}
