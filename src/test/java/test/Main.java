package test;

import sun.misc.Unsafe;
import java.util.List;

/**
 * test
 *
 * @author werson
 * @version 1.0.0
 * @since 2018/9/8
 */
public class Main {

    static List<String> getMeeting(List<String> list) {
        if (list.size() == 0) return list;
        list.sort((o1, o2) -> {
            int aLeft = Integer.parseInt(o1.split(",")[0]);
            int bLeft = Integer.parseInt(o2.split(",")[0]);
            return aLeft - bLeft;
        });
        String cur = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            String next = list.get(i);
            int curStart = Integer.parseInt(cur.split(",")[0]);
            int curEnd = Integer.parseInt(cur.split(",")[1]);
            int nextEnd = Integer.parseInt(next.split(",")[1]);
            int nextStart = Integer.parseInt(next.split(",")[0]);
            if (curEnd <= nextStart) {
                cur = next;
            } else {
                if (curEnd - curStart >= nextEnd - nextStart) {
                    list.remove(i);
                    i--;
                } else {
                    list.remove(i - 1);
                    i--;
                    cur = next;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        List<String> param = new ArrayList<>();
        while (true) {
            String input = in.next();
            if ("end".equals(input)) {
                break;
            }
            param.add(input);
        }
        int size = param.size();
        for (int i = 0; i < size; i++) {
            if (i == 1) {
                System.out.println("0," + param.get(i));
            }
            if (i > 1) {
                System.out.println(param.get(i));
            }
        }*/

        String a = "hahah";

        String b = "hahah";

        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));


    }

}
