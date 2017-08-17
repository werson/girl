package com.werson;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by wersom on 2017/8/3 0003.
 */
class RotateImageMain {

    @SuppressWarnings("unchecked")
    public static void main(String[]args){
        Vector image = new Vector();
        Vector row1 = new Vector();
        Vector row2 = new Vector();
        Vector row3 = new Vector();
        Vector row4 = new Vector();
        Vector row5 = new Vector();
        row1.add(1);row1.add(2);row1.add(3);row1.add(3);
        row2.add(1);row2.add(2);row2.add(3);row2.add(3);
        row3.add(1);row3.add(2);row3.add(3);row3.add(3);
        row4.add(1);row4.add(2);row4.add(2);row4.add(2);
        row5.add(1);row5.add(2);row5.add(2);row5.add(2);
        image.add(row1);
        image.add(row2);
        image.add(row3);
        image.add(row4);
        image.add(row5);
        printImage(image);
        printImage(rotate(image));

    }

    public static Vector rotate(Vector image){
        System.out.println("------------------");
        int rowNum = image.size();//3
        Vector row1 = (Vector) image.get(0);
        int colNum = row1.size();//2
        Integer[][] rotateAfter = new Integer[colNum][rowNum];//2 3
        Integer[][] rel = VectorToArray(image);
        for(int i = 0; i < rowNum; i++){
            for(int j =0; j < colNum; j++){
                rotateAfter[j][rowNum-i-1] = rel[i][j];
            }
        }
        return ArrayToVector(rotateAfter);
    }

    public static void printImage(Vector image) {
        for(Object obj : image){
            Vector row = (Vector) obj;
            for(Object num : row){
                System.out.print(num+" ");
            }
            System.out.println("");
        }
    }

    public static Integer[][] VectorToArray(Vector image){
        int rowNum = image.size();
        Vector row1 = (Vector) image.get(0);
        int colNum = row1.size();
        Integer[][] rel = new Integer[rowNum][colNum];
        int i = 0;
        for(Object obj : image){
            Vector row = (Vector) obj;
            int j = 0;
            for(Object num : row){
                rel[i][j] = (Integer) num;
                j++;
            }
            i++;
        }
        return rel;
    }

    public static Vector ArrayToVector(Integer[][] rel){
        int rowNum = rel.length;
        Integer[] col1 = rel[0];
        int colNum = col1.length;
        Vector result = new Vector();
        for(int i = 0; i < rowNum; i++){
            Vector row = new Vector();
            for(int j =0; j < colNum; j++){
                row.add(rel[i][j]);
            }
            result.add(row);
        }
        return result;
    }

}
