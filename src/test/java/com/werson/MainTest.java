package com.werson;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wersom on 2017/6/15 0015.
 */
public class MainTest {

    public static void main(String[] a){
        int[] s = {-1,0,1,1,55};
        //threeSum2(s);
        System.out.println(threeSumClosest(s, 3));
    }

    public static List<List<Integer>> threeSum (int[] nums) {
        List<List<Integer>> resultVec = new LinkedList<List<Integer>>();
        int size = nums.length;
        int maxIndex = size - 2;
        int midIndex = size - 1;
        int min,mid,max;
        int num1, num2, num3;
        for(int j =0; j < maxIndex; j++){
            for(int i = j+1; i < midIndex; i++){
                for(int m = i+1; m < size; m++){
                    num1 = nums[j];
                    num2 = nums[i];
                    num3 = nums[m];
                    if(num1 + num2 + num3 == 0){
                        if (num1 < num2) {
                            min = num1;
                            mid = num2;
                        } else {
                            mid = num1;
                            min = num2;
                        }
                        if (num3 >= mid) {
                            max = num3;
                        } else {
                            max = mid;
                            if(num3 >= min){
                                mid = num3;
                            }else{
                                mid = min;
                                min = num3;
                            }
                        }
                        resultVec.add(Arrays.asList(min, mid, max));
                        /*List<Integer> threeVec = Arrays.asList(min, mid, max);
                        if(!resultVec.contains(threeVec)){
                            resultVec.add(threeVec);
                        }*/
                    }
                }
            }
        }
        return resultVec;
    }

    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int rel = 0;
        int closestNum = 0;
        int size = num.length;
        int maxIndex = size - 2;
        for(int j = 0; j < maxIndex; j++){
            if(j == 0 || (j > 0 && num[j] != num[j-1])){
                int min = j + 1,max = size - 1;
                while (min < max){
                    int closeNum = target - num[j] - num[min] - num[max];
                    if(closestNum == 0){
                        closestNum = Math.abs(closeNum);
                        rel = num[j] + num[min] + num[max];
                    }
                    if(closeNum == 0){
                        return num[j] + num[min] + num[max];
                    }
                    if(Math.abs(closeNum) < closestNum){
                        closestNum = Math.abs(closeNum);
                        rel = num[j] + num[min] + num[max];
                    }
                    if(closeNum > 0){
                        min++;
                        while (min < max && num[min]==num[min-1]) min++;
                    }else if(closeNum < 0){
                        max--;
                        while (min < max && num[max]==num[max+1]) max--;
                    }
                }
            }
        }
        return rel;
    }











    public static List<List<Integer>> threeSum3(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

}
