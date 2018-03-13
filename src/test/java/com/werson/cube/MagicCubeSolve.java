package com.werson.cube;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MagicCubeSolve {

    public static  String[][] magicCube2 = {{"A","A","A","A","A","A","A","A","A"},
            {"B","B","B","B","B","B","B","B","B"},
            {"C","C","C","C","C","C","C","C","C"},
            {"D","D","D","D","D","D","D","D","D"},
            {"E","E","E","E","E","E","E","E","E"},
            {"F","F","F","F","F","F","F","F","F"},};
    public static String[][] restoredMagicCube = {{"A1","A2","A3","A4","A5","A6","A7","A8","A9"},
            {"B1","B2","B3","B4","B5","B6","B7","B8","B9"},
            {"C1","C2","C3","C4","C5","C6","C7","C8","C9"},
            {"D1","D2","D3","D4","D5","D6","D7","D8","D9"},
            {"E1","E2","E3","E4","E5","E6","E7","E8","E9"},
            {"F1","F2","F3","F4","F5","F6","F7","F8","F9"}};

    private static String[][] magicCubeRondom = {{"白","绿","红","白","蓝","黄","蓝","白","橙"},
            {"橙","黄","橙","红","黄","白","白","绿","绿"},
            {"白","绿","黄","黄","绿","黄","橙","蓝","红"},
            {"黄","橙","绿","蓝","白","红","白","白","黄"},
            {"绿","红","绿","绿","橙","红","黄","蓝","红"},
            {"蓝","橙","红","蓝","红","橙","蓝","橙","蓝"},};

    private static String[][] magicCube = {{"蓝","蓝","蓝","蓝","绿","蓝","蓝","蓝","蓝"},
            {"橙","橙","橙","橙","红","橙","橙","橙","橙"},
            {"绿","绿","绿","绿","蓝","绿","绿","绿","绿"},
            {"红","红","红","红","橙","红","红","红","红"},
            {"白","白","白","白","白","白","白","白","白"},
            {"黄","黄","黄","黄","黄","黄","黄","黄","黄"},};

    @Test
    public void testFiveStep(){

    }

    @Test
    public void getRandomMagic(){
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            rotateMagicCube(magicCubeRondom, random.nextInt(27));
        }
        for(String[] v : magicCubeRondom){
            System.out.println(Arrays.toString(v));
        }
    }

    @Test
    public void doneMagicTest1(){

    }

    public static void main(String[] args) {
        //int t = 0;
        rotateMagicCube(magicCube, 0);
        //rotateMagicCube(restoredMagicCube, 8);
        rotateMagicCube(magicCube, 0);
        for(int i = 0; i < 27; i++){

        }
        //rotateMagicCube(restoredMagicCube, t);
        //rotateMagicCube(restoredMagicCube, t);
        for(String[] v : restoredMagicCube){
            System.out.println(Arrays.toString(v));
        }
        //Integer[] actions = new Integer[3];
        //createSolutionList(actions, 0);

    }

    public static boolean createSolutionList(Integer[] actions, int times){
        if(times == 0){
            for(int j = 0; j < 27; j++){
                Integer[] newActions = actions;
                newActions[times] = j;
                int newNimes = times + 1;
                if(createSolutionList(newActions, newNimes)){
                    return true;
                }
            }
        }else{
            int num = actions[times-1];
            int num1 = num + 9;
            int num2 = num + 18;
            for(int j = 0; j < 27; j++){
                if(j != num && j != num1 && j != num2){
                    if (times == 21) {
                        String[][] magicCube1 = new String[6][9];
                        for(int t = 0; t < 6; t++){
                            for(int y = 0; y < 9; y++){
                                String cl = magicCube[t][y];
                                magicCube1[t][y] = cl;
                            }
                        }
                        for(Integer a : actions){
                            if (a != null){
                                rotateMagicCube(magicCube1, a);
                                if(checkMagicCube(magicCube1)){
                                    return true;
                                }
                            }
                        }
                        rotateMagicCube(magicCube1, j);
                        if(checkMagicCube(magicCube1)){
                            System.out.println(Arrays.toString(actions) + j);
                            return true;
                        }
                    } else {
                        Integer[] newActions = actions;
                        newActions[times] = j;
                        int newNimes = times + 1;
                        if(createSolutionList(newActions, newNimes)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    //27种旋转方式
    public static void rotateMagicCube(String[][] magicCube, int actionNum){
        int time = (actionNum/9) + 1;

        int type = (actionNum)%9;
        for(int i = 0; i < time; i++){
            switch (type) {
                case 0: {
                    System.out.println("第一行右转");
                    RotateImpl.row1TurnRight(magicCube);break;
                }
                case 1: {
                    System.out.println("第二行右转");
                    RotateImpl.row2TurnRight(magicCube);break;
                }
                case 2: {
                    System.out.println("第三行右转");
                    RotateImpl.row3TurnRight(magicCube);break;
                }
                case 3: {
                    System.out.println("第一列下转");
                    RotateImpl.col1TurnDown(magicCube);break;
                }
                case 4: {
                    System.out.println("第二列下转");
                    RotateImpl.col2TurnDown(magicCube);break;
                }
                case 5: {
                    System.out.println("第三列下转");
                    RotateImpl.col3TurnDown(magicCube);break;
                }
                case 6: {
                    System.out.println("第四列下转");
                    RotateImpl.col4TurnDown(magicCube);break;
                }
                case 7: {
                    System.out.println("第五列下转");
                    RotateImpl.col5TurnDown(magicCube);break;
                }
                case 8: {
                    System.out.println("第六列下转");
                    RotateImpl.col6TurnDown(magicCube);break;
                }
            }
        }

    }

    /**
     * 检测魔方是否还原
     */
    public static boolean checkMagicCube(String[][] magicCube){
        for(String[] a : magicCube){
            String str = a[0];
            for(String num : a){
                if(!str.equals(num)){
                    return false;
                }
            }
        }
        return true;
    }
}
