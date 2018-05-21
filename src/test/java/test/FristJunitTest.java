package test;

import org.junit.*;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by wersom on 2017/10/13 0013.
 */
public class FristJunitTest {
    @Test
    public void test1(){
        System.out.println("hello junit!");
    }

    @Test
    public void test2(){
        System.out.println("hello junit!");
        Assert.assertEquals(1,1);
    }

    @Test
    public void testLambda(){
        String heguGids = "aa,bb,cc,dd,";
        //List<Integer> gidList = Arrays.stream(heguGids.split(",")).map(gid -> Integer.parseInt(gid.trim())).collect(Collectors.toList());
        Arrays.stream(heguGids.split(",")).forEach(System.out::println);
        List<String> strList = new ArrayList<>();
        strList.add("12");
        strList.add("23");
        strList.add("43");
        int sum = strList.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
        Map<String, String> strMap = new HashMap<>();
        strMap.put("a", "a");
        strMap.put("b", "b");
        strMap.put("c", "c");
        strMap.keySet().forEach(System.out::println);
        strMap.forEach((key, value) -> System.out.println(key +"="+ value));

    }

    @Test
    public void testReflect(){
        try {
            Class a = Class.forName("test.MagicCubeTest");
            //Field magicCube = a.getField("magicCube");
            Constructor[] constructors = a.getConstructors();
            System.out.println(constructors.length);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEqual(){
        final Map<String, String> a = new HashMap<>();
        a.put("aa", "aa");
        Map<String, String> b = a;
        b.put("bb", "bb");
        System.out.println(a);
    }

    @Test
    public void testStatic(){
        
    }

}