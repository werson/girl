package com.werson;

import java.util.*;

/**
 * Created by wersom on 2017/6/23 0023.
 */
public class SoKuSolution {
    public static void main(String[] a){
        /*String[][] board = {{"h", "3", "4", "h", "7", "h", "9", "1", "2"},
                            {"h", "7", "2", "h", "9", "5", "3", "4", "8"},
                            {"1", "9", "8", "3", "4", "2", "5", "6", "7"},
                            {"8", "5", "9", "h", "h", "1", "4", "2", "3"},
                            {"4", "2", "6", "8", "h", "h", "7", "h", "1"},
                            {"7", "1", "3", "h", "h", "h", "8", "5", "6"},
                            {"9", "6", "1", "5", "3", "h", "h", "h", "h"},
                            {"2", "8", "7", "4", "1", "9", "h", "h", "h"},
                            {"3", "4", "5", "2", "8", "6", "h", "h", "h"}};*/
    char[][] board = {{'h', '5', 'h', 'h', 'h', 'h', 'h', '7', 'h'},
                        {'9', 'h', 'h', 'h', 'h', 'h', 'h', '2', 'h'},
                        {'h', 'h', 'h', 'h', 'h', '8', 'h', 'h', 'h'},
                        {'2', 'h', 'h', 'h', '1', 'h', 'h', 'h', 'h'},
                        {'h', 'h', 'h', 'h', 'h', 'h', '5', 'h', 'h'},
                        {'h', 'h', '6', 'h', 'h', 'h', '8', 'h', '4'},
                        {'h', 'h', 'h', 'h', '3', 'h', 'h', 'h', 'h'},
                        {'h', '8', 'h', 'h', 'h', 'h', '4', 'h', 'h'},
                        {'h', 'h', '1', '9', '2', 'h', 'h', 'h', 'h'}};
        long time1 = System.currentTimeMillis();
        solve(board);
        for(int i = 0; i < 9; i++){
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println(System.currentTimeMillis()-time1);
    }

    public static boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == 'h'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            } else {
                                board[i][j] = 'h';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != 'h' && board[i][col] == c) return false; //check row
            if(board[row][i] != 'h' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != 'h' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }

    public static void getRowNums(char[][] board, int row, Set<Integer> exitNums){
        char[] rowNums = board[row];
        for(char num : rowNums){
            if('h'!= num){
                exitNums.add(Character.getNumericValue(num));
            }
        }
    }

    public static void getColNums(char[][] board, int col, Set<Integer> exitNums){
        for(int i = 0; i<9;i++){
            char num = board[i][col];
            if('h'!= num){
                exitNums.add(Character.getNumericValue(num));
            }
        }
    }

    public static void nearNums(char[][] board, int row, int col, Set<Integer> exitNums) {
        List<Integer> rowNums = getNums(row);
        List<Integer> colNums = getNums(col);
        for(int i : rowNums){
            for(int j : colNums){
                char str = board[i][j];
                if('h'!= str){
                    exitNums.add(Character.getNumericValue(str));
                }
            }
        }
    }

    public static List<Integer> getNums(int index){
        int x = index / 3 + 1;
        List<Integer> rowNums = new ArrayList<>();
        if (x == 1) {
            rowNums.add(0);
            rowNums.add(1);
            rowNums.add(2);
        } else if (x == 2) {
            rowNums.add(3);
            rowNums.add(4);
            rowNums.add(5);
        } else {
            rowNums.add(6);
            rowNums.add(7);
            rowNums.add(8);
        }
        return rowNums;
    }
}
