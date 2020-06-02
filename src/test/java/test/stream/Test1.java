package test.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * test.stream
 *
 * @author werson
 * @version 1.0.0
 * @since 2019/3/20
 */
public class Test1 {

    @Test
    public void testMap(){
        List<String> strList = new ArrayList<>();
        strList.add("werson11");
        strList.add("werson22");
        strList.add("werson33");
        strList.add("werson44");
        List<List<String>> up = new ArrayList<>();
        up.add(strList);


        List<String> strList2 = new ArrayList<>();
        strList2.add("werson11");
        strList2.add("werson22");
        strList2.add("werson33");
        strList2.add("werson44");
        up.add(strList2);

        //up.stream().flatMap(list -> list.add("gaga")).collect(Collectors.toList());
        List<String> bgbg = up.stream().flatMap(Collection::stream).collect(Collectors.toList());

        up.stream().map(list -> list.add("gg")).collect(Collectors.toList());




        String[] words = new String[]{"Hello","World"};
        List<String> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(b -> {
                    Stream<String> res = Arrays.stream(b);
                    return res;
                }).distinct()
                .collect(Collectors.toList());
        a.forEach(System.out::print);


    }


    @Test
    public void testMapFlat(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "name");
        map.put("2", "hahah");

        List<String> res = map.entrySet().stream().flatMap(a -> {
            return Collections.singletonList(a.getValue()).stream();
        }).collect(Collectors.toList());

        System.out.println(res.toString());



    }

}
