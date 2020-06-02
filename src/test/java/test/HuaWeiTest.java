package test;

import org.junit.Test;
import sun.misc.Unsafe;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * test
 *
 * @author werson
 * @version 1.0.0
 * @since 2018/9/8
 */
public class HuaWeiTest {

    @Test
    public void test23() throws NoSuchFieldException, IllegalAccessException {

        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        /*Unsafe unsafe = Unsafe.getUnsafe();*/

        int h = 1, i =1,j = 2;
        if(unsafe.compareAndSwapInt(this,h,i,j)){
            System.out.println(11);
        }
        System.out.println(i);
        System.out.println(j);
    }


    public static void main(String[] args) {
        List<List<String>> paramsList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean isNew = false;
        List<String> param = new ArrayList<>();
        while (true){
            if(isNew){
                param = new ArrayList<>();
                isNew = false;
            }

            String input = in.next();
            if("0".equals(input)){
                break;
            }
            if("0,0".equals(input)){
                paramsList.add(param);
                isNew = true;
            }else{
                param.add(input);
            }
        }


        for(List<String> params : paramsList){
            int size = params.size();
            for(int i = 0; i < size; i++){
                for(int j = i+1; j < size; j++){
                    String p1 = params.get(i);
                    String p2 = params.get(j);
                    if(!"".equals(p1) && !"".equals(p2)){
                        if(hasCommon(p1, p2)){//有公共部分
                            //1. 比较时长
                            int p1L = getDistance(p1);
                            int p2L = getDistance(p2);
                            if(p1L > p2L){
                                params.set(j,"");
                            }
                            if(p1L < p2L){
                                params.set(i,"");
                            }
                            if(p1L == p2L){
                                if(Integer.valueOf(p1.split(",")[0]) < Integer.valueOf(p2.split(",")[0])){
                                    params.set(j,"");
                                }else{
                                    params.set(i,"");
                                }
                            }
                        }else{//没有公共部分
                            if(Integer.valueOf(p1.split(",")[0]) < Integer.valueOf(p2.split(",")[0])){
                            }else{
                                params.set(i, p2);
                                params.set(j, p1);
                            }
                        }
                    }
                }
            }
            List<String> result = new ArrayList<>();
            for(int i = 0; i < size; i++){
                if(!"".equals(params.get(i))){
                    result.add(params.get(i));
                }
            }
            for(String str : result){
                System.out.println(str);
            }
        }
    }


    public static int getDistance(String p){
        return Integer.valueOf(p.split(",")[1]) - Integer.valueOf(p.split(",")[0]);
    }


    public static boolean hasCommon(String p1, String p2){
        if(Integer.valueOf(p1.split(",")[1]) < Integer.valueOf(p2.split(",")[0])){
            return false;
        }
        if(Integer.valueOf(p1.split(",")[0]) > Integer.valueOf(p2.split(",")[1])){
            return false;
        }
        return true;
    }


}
