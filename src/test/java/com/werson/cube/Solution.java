package com.werson.cube;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wersom on 2017/9/21 0021.
 */
public class Solution {

    Solution(){
        this.actions = new ArrayList<>();
    }

    private Integer size;

    private List<Integer> actions;

    public Integer size() {
        return actions.size();
    }

    public List<Integer> getActions() {
        return actions;
    }

    public void setActions(List<Integer> actions) {
        this.actions = actions;
    }

    public void addAction(Integer action){
        this.actions.add(action);
    }

    public void delAction(){
        this.actions.remove(size()-1);
    }

    public void print(){
        System.out.print(actions.toString());
        System.out.println();
    }
}
