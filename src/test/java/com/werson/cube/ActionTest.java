package com.werson.cube;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wersom on 2017/9/21 0021.
 */
public class ActionTest {
    public static void main(String[] args) {
        //0-26 一共27种解法
        Integer[] actionAry = new Integer[27];
        for(int i = 0; i < 27; i++){
            actionAry[0] = i;
        }

        //20个步骤集合
        //List<Solution> solutionList = new ArrayList<>();

        //20步
        /*Solution sl = new Solution();
        for(int i = 0; i < 20; i++){
            sl.addAction(0);
        }*/

        List<Solution> solutionList = new ArrayList<>();
        /** 1步
        for(int i = 0; i < 27; i++){
            Solution sl = new Solution();
            sl.addAction(i);
            solutionList.add(sl);
        }*/

        /** 2步
        for(int i = 0; i < 27; i++){
            for(int j = 0; j < 27; j++){
                Solution sl = new Solution();
                sl.addAction(i);
                sl.addAction(j);
                solutionList.add(sl);
            }
        }*/
        /** 3步
        for(int i = 0; i < 27; i++){
            for(int j = 0; j < 27; j++){
                for(int n = 0; n < 27; n++){
                    Solution sl = new Solution();
                    sl.addAction(i);
                    sl.addAction(j);
                    sl.addAction(n);
                    solutionList.add(sl);
                }
            }
        }*/
        Integer[] actions = new Integer[20];
        /*for(int i = 0; i < actions.length; i++){
            System.out.println(actions[i]);
        }*/


        createSolutionList(solutionList, actions, 0);
        //System.out.println("一共"+solutionList.size()+"总解法。");
        /*for(Solution sl : solutionList){
            sl.print();
        }*/



    }

    public static void createSolutionList(List<Solution> solutionList,Integer[] actions, int times){
        if(times == 0){
            for(int j = 0; j < 27; j++){
                Integer[] newActions = actions;
                newActions[times] = j;
                int newNimes = times + 1;
                createSolutionList(solutionList, newActions, newNimes);
            }
        }else{
            int num = actions[times-1];
            int num1 = num + 9;
            int num2 = num + 18;
            for(int j = 0; j < 27; j++){
                if(j != num && j != num1 && j != num2){
                    if (times == 4) {
                        Solution sl = new Solution();
                        for(Integer a : actions){
                            if (a != null) sl.addAction(a);
                        }
                        sl.addAction(j);
                        sl.print();
                        solutionList.add(sl);
                    } else {
                        Integer[] newActions = actions;
                        newActions[times] = j;
                        int newNimes = times + 1;
                        createSolutionList(solutionList, newActions, newNimes);
                    }
                }
            }
        }
    }




}
