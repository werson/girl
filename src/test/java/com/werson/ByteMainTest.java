package com.werson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wersom on 2017/6/28 0028.
 */
public class ByteMainTest {
    public static void main(String[] agrs){
        //System.out.println(Arrays.asList(getStr("a", 2)));
        System.out.println(isMatch("aaba", "ab*a*c*a"));
    }

    public static boolean isMatch(String s, String p) {
        int sSize = s.length();
        int pSize = p.length();
        if(sSize == 0 && pSize == 0){
            return true;
        }
        if(sSize > 0 && pSize > 0){
            String pStr = p.substring(0, 1);
            String sIndex = s.substring(0, 1);
            if(pStr.equals(".")){
                s = s.substring(1, s.length());
                p = p.substring(1, p.length());
                return isMatch(s, p);
            }else if(pStr.equals("*")){
                int n = 0;
                String sIndexN = s.substring(0, 1);
                while(sIndex.equals(sIndexN)){
                    n++;
                    if(n == s.length()){
                        break;
                    }
                    sIndexN = s.substring(n, 1+n);
                }
                String[] mayStr = getStr(sIndex, n);
                for(String mstr : mayStr){
                    String news = s;
                    String newp = p.substring(1, p.length());
                    if(mstr !=null && mstr.length() > 0){
                        int mstrL = mstr.length();
                        news = s.substring(mstrL, s.length());
                    }
                    if(isMatch(news, newp)){
                        return true;
                    }
                }
                return false;
            } else {
                if(!pStr.equals(sIndex)){
                    if(pSize>=2){
                        String pStr2 = p.substring(1, 2);
                        if("*".equals(pStr2)){
                            p = p.substring(2, p.length());
                            return isMatch(s, p);
                        }
                    }
                    return false;
                }else{
                    s = s.substring(1, s.length());
                    p = p.substring(1, p.length());
                    return isMatch(s, p);
                }
            }
        }
        return false;
    }

    public static String[] getStr(String sIndex, int n){
        List<String> list = new ArrayList<>();
        list.add("");
        for(int i=0; i < n; i++){
            String aStr = "";
            for(int j=1; j<=i+1; j++){
                aStr = aStr + sIndex;
            }
            list.add(aStr);
        }
        int size = list.size();
        return list.toArray(new String[size]);
    }

}

