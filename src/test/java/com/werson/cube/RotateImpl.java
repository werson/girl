package com.werson.cube;


public class RotateImpl extends Rotate {

    private int count = 0;



    @Override
    public void action(String[][] magicCube) {
        count++;
        System.out.print(count+"th turn direction="+this.direction.getDirection());
        System.out.print("  side="+this.side.getSide());
        System.out.print("  rotateNum="+this.rotateNum);
        System.out.println("");
    }

    //第一排右转
    public static void row1TurnRight(String[][] magicCube){
        Integer[] jAry = {0, 1, 2};
        Integer[] a = {0,5,2,4};
        magicCubeTurn(magicCube, jAry, a);
        sideTurnRight(magicCube,1);
        sideTurnRight(magicCube,1);
        sideTurnRight(magicCube,1);
    }
    //第二排右转
    public static void row2TurnRight(String[][] magicCube){
        Integer[] jAry = {3, 4, 5};
        Integer[] a = {0,5,2,4};
        magicCubeTurn(magicCube, jAry, a);
    }
    //第三排右转
    public static void row3TurnRight(String[][] magicCube){
        Integer[] jAry = {6, 7, 8};
        Integer[] a = {0,5,2,4};
        magicCubeTurn(magicCube, jAry, a);
        sideTurnRight(magicCube,3);
        sideTurnRight(magicCube,3);
        sideTurnRight(magicCube,3);
    }
    //第一列下转
    public static void col1TurnDown(String[][] magicCube) {
        Integer[][] jAry = {{0, 3, 6},{2,1,0},{8,5,2},{0,1,2}};
        Integer[] a = {0,1,2,3};
        magicCubeTurn2(magicCube, jAry, a);
        sideTurnRight(magicCube,4);
    }
    //第二列下转
    public static void col2TurnDown(String[][] magicCube) {
        Integer[][] jAry = {{1, 4, 7},{5,4,3},{7,4,1},{3,4,5}};
        Integer[] a = {0,1,2,3};
        magicCubeTurn2(magicCube, jAry, a);
    }
    //第三列下转
    public static void col3TurnDown(String[][] magicCube) {
        Integer[][] jAry = {{2, 5, 8},{8,7,6},{6,3,0},{6,7,8}};
        Integer[] a = {0,1,2,3};
        magicCubeTurn2(magicCube, jAry, a);
        sideTurnRight(magicCube,5);
        sideTurnRight(magicCube,5);
        sideTurnRight(magicCube,5);
    }
    //第四列下转
    public static void col4TurnDown(String[][] magicCube){
        Integer[][] jAry = {{0, 3, 6},{0,3,6},{8,5,2},{6,3,0}};
        Integer[] a = {5,1,4,3};
        magicCubeTurn2(magicCube, jAry, a);
        sideTurnRight(magicCube,0);
    }
    //第五列下转
    public static void col5TurnDown(String[][] magicCube){
        Integer[][] jAry = {{1, 4, 7},{1,4,7},{7,4,1},{7,4,1}};
        Integer[] a = {5,1,4,3};
        magicCubeTurn2(magicCube, jAry, a);
    }
    //第六列下转
    public static void col6TurnDown(String[][] magicCube){
        Integer[][] jAry = {{2, 5, 8},{2,5,8},{6,3,0},{8,5,2}};
        Integer[] a = {5,1,4,3};
        magicCubeTurn2(magicCube, jAry, a);
        sideTurnRight(magicCube,2);
        sideTurnRight(magicCube,2);
        sideTurnRight(magicCube,2);
    }
    //旋转方法
    public static void magicCubeTurn(String[][] magicCube, Integer[] jAry, Integer[] a){
        Integer[] b = {3,0,1,2};
        String[][] num = new String[4][3];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                num[i][j] = magicCube[a[i]][jAry[j]];
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                magicCube[a[i]][jAry[j]] = num[b[i]][j];
            }
        }
    }
    //旋转方法2
    public static void magicCubeTurn2(String[][] magicCube, Integer[][] jAry, Integer[] a){
        Integer[] b = {1,2,3,0};
        String[][] num = new String[4][3];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                num[i][j] = magicCube[a[i]][jAry[i][j]];
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                magicCube[a[i]][jAry[i][j]] = num[b[i]][j];
            }
        }
    }
    //平面旋转
    public static void sideTurnRight(String[][] magiceCube, int sideNum){
        String[] side = magiceCube[sideNum];
        String[][] image = new String[3][3];
        for(int i = 0; i < 9; i++){
            int row = i/3;
            int col = i%3;
            image[row][col] = side[i];
        }

        String[][] image2 = imageRotate(image);
        for(int i = 0; i < 9; i++){
            int row = i/3;
            int col = i%3;
            side[i] = image2[row][col];
        }
        magiceCube[sideNum] = side;
    }

    public static String[][] imageRotate(String[][] image){
        int rowNum = image.length;
        int colNum = image[0].length;
        String[][] image2 = new String[colNum][rowNum];
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                image2[j][rowNum - i -1] = image[i][j];
            }
        }
        return image2;
    }

    @SuppressWarnings("unused")
    public void turnTo1(String[][] magicCube, int typeNum) {
        switch (typeNum) {
            case 1: {
                this.direction = Direction.turn_left;
                this.side = Side.row_one;
                this.rotateNum = 1;
            }
            case 2: {
                this.direction = Direction.turn_left;
                this.side = Side.row_one;
                this.rotateNum = 2;
            }
            case 3: {
                this.direction = Direction.turn_right;
                this.side = Side.row_one;
                this.rotateNum = 1;
            }
            case 4:{
                this.direction = Direction.turn_up;
                this.side = Side.col_one;
                this.rotateNum = 1;
            }
            case 5: {
                this.direction = Direction.turn_up;
                this.side = Side.col_one;
                this.rotateNum = 2;
            }
            case 6: {
                this.direction = Direction.turn_down;
                this.side = Side.col_one;
                this.rotateNum = 1;
            }
            case 7:{
                this.direction = Direction.turn_up;
                this.side = Side.col_two;
                this.rotateNum = 1;
            }
            case 8: {
                this.direction = Direction.turn_up;
                this.side = Side.col_two;
                this.rotateNum = 2;
            }
            case 9: {
                this.direction = Direction.turn_down;
                this.side = Side.col_two;
                this.rotateNum = 1;
            }
            case 10:{
                this.direction = Direction.turn_up;
                this.side = Side.col_three;
                this.rotateNum = 1;
            }
            case 11: {
                this.direction = Direction.turn_up;
                this.side = Side.col_three;
                this.rotateNum = 2;
            }
            case 12: {
                this.direction = Direction.turn_down;
                this.side = Side.col_three;
                this.rotateNum = 1;
            }
            case 13: {
                this.direction = Direction.turn_left;
                this.side = Side.row_two;
                this.rotateNum = 1;
            }
            case 14: {
                this.direction = Direction.turn_left;
                this.side = Side.row_two;
                this.rotateNum = 2;
            }
            case 15: {
                this.direction = Direction.turn_right;
                this.side = Side.row_two;
                this.rotateNum = 1;
            }
            case 16: {
                this.direction = Direction.turn_left;
                this.side = Side.row_three;
                this.rotateNum = 1;
            }
            case 17: {
                this.direction = Direction.turn_left;
                this.side = Side.row_three;
                this.rotateNum = 2;
            }
            case 18: {
                this.direction = Direction.turn_right;
                this.side = Side.row_three;
                this.rotateNum = 1;
            }
        }
        action(magicCube);
    }
}
