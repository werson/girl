package com.werson;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

/**
 * Created by wersom on 2017/6/20 0020.
 */
public class SuDoKuMainTest {
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
        String[][] board = {{"h", "5", "h", "h", "h", "h", "h", "7", "h"},
                            {"9", "h", "h", "h", "h", "h", "h", "2", "h"},
                            {"h", "h", "h", "h", "h", "8", "h", "h", "h"},
                            {"2", "h", "h", "h", "1", "h", "h", "h", "h"},
                            {"h", "h", "h", "h", "h", "h", "5", "h", "h"},
                            {"h", "h", "6", "h", "h", "h", "8", "h", "4"},
                            {"h", "h", "h", "h", "3", "h", "h", "h", "h"},
                            {"h", "8", "h", "h", "h", "h", "4", "h", "h"},
                            {"h", "h", "1", "9", "2", "h", "h", "h", "h"}};
        /*for(int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }*/
        int times = 1;
        suDo(board, times);
        for(int i = 0; i < 9; i++){
            System.out.println(Arrays.toString(board[i]));
        }
        //System.out.println((9-1)/3 +1);

    }

    public static void suDo(String[][] board, int times){
        boolean isOver = true;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                String str =  board[i][j];
                if("h".equals(str)){
                    String result = checkSuDo(board, i, j);
                    if("h".equals(result)){
                        isOver = false;
                    }else{
                        board[i][j] = result;
                    }
                }
            }
        }
        if(!isOver){
            times++;
            if(times < 70){
                suDo(board, times);
            }
        }
    }

    public static String checkSuDo(String[][] board, int row, int col){
        Set<Integer> exitNums = new HashSet<>();
        List<Integer> baseNum = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            baseNum.add(i);
        }
        for(int j = 0; j < 9; j++){
            String str = String.valueOf(board[row][j]);
            if(!"h".equals(str)){
                exitNums.add(Integer.parseInt(str));
            }
            String str2 = String.valueOf(board[j][col]);
            if(!"h".equals(str2)){
                exitNums.add(Integer.parseInt(str2));
            }
        }
        nearNums(board, row, col, exitNums);
        baseNum.removeAll(exitNums);
        if(baseNum.size() == 1){
            return baseNum.get(0)+"";
        } else {
            List<Integer> rowNums = getNums(row);
            List<Integer> colNums = getNums(col);
            for(int thisNum : baseNum){
                boolean isThisNum = true;
                for(int i : rowNums){
                    for(int j : colNums){
                        if(i != row || j!=col){
                            String num = board[i][j];
                            if("h".equals(num)){
                                Set<Integer> rel = getRowNums(board, i);
                                rel.addAll(getColNums(board, j));
                                if(!rel.contains(thisNum)){
                                    isThisNum = false;
                                }
                            }
                        }
                    }
                }
                if(isThisNum){
                    return thisNum+"";
                }
            }
        }
        return "h";
    }

    public static Set<Integer> getRowNums(String[][] board, int row){
        String[] rowNums = board[row];
        Set<Integer> rel = new HashSet<>();
        for(String num : rowNums){
            if(!"h".equals(num)){
                rel.add(Integer.parseInt(num));
            }
        }
        return rel;
    }

    public static Set<Integer> getColNums(String[][] board, int col){
        Set<Integer> rel = new HashSet<>();
        for(int i = 0; i<9;i++){
            String num = board[i][col];
            if(!"h".equals(num)){
                rel.add(Integer.parseInt(num));
            }
        }
        return rel;
    }

    public static void nearNums(String[][] board, int row, int col, Set<Integer> exitNums) {
        List<Integer> rowNums = getNums(row);
        List<Integer> colNums = getNums(col);
        for(int i : rowNums){
            for(int j : colNums){
                String str = board[i][j];
                if(!"h".equals(str)){
                    exitNums.add(Integer.parseInt(str));
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
