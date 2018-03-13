package com.werson;

import java.util.*;

import static java.util.Objects.hash;

/**
 * Created by werson on 2017/8/20 0020.
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, Integer> param = new HashMap<>();
        param.put("a", 923);
        param.put("a1", 456);
        param.put("a2", 789);
        /*Set<String> keySet = param.keySet();
        Iterator<String> a = keySet.iterator();
        while (a.hasNext()) {
            String key = a.next();
            System.out.println(hash(key) + "//" + key + "=" + param.get(key));
        }*/

        // 通过ArrayList构造函数把map.entrySet()转换成list
        Set pSet = param.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(pSet);
        // 通过比较器实现比较排序
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> mapping1, Map.Entry<String, Integer> mapping2) {
                //return mapping1.getKey().compareTo(mapping2.getKey());
                return mapping1.getValue().compareTo(mapping2.getValue());
            }
        });
        for(Map.Entry<String, Integer> map : list){
            System.out.println(map.getKey() +":"+ map.getValue());
        }


        Map<String, Integer> orderMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        orderMap.put("按", 456);
        orderMap.put("俺", 123);
        orderMap.put("安", 789);
        System.out.println("orderMap="+orderMap);
    }
}
