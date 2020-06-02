package com.werson.inter;

import java.util.ArrayList;
import java.util.List;

/**
 * com.werson.inter
 *
 * @author werson
 * @version 1.0.0
 * @since 2020/6/2
 */
public class SkuInfoTest {

    public static void main(String[] args) {

        SkuInfo skuInfo = new SkuInfo();
        SubSkuInfo subSkuInfo = new SubSkuInfo();
        subSkuInfo.setSku(222);
        List<SubSkuInfo> subSkuInfos = new ArrayList<>();
        subSkuInfos.add(subSkuInfo);

        System.out.println(subSkuInfos.get(0).getSku());
        skuInfo.setSubSkus(subSkuInfos);

        List<SubSkuInfo> subSkuInfos2 = skuInfo.getSubSkus();
        System.out.println(subSkuInfos2.get(0).getSku());


        List<Integer> aList = new ArrayList<>();
        aList.add(1);
        aList.add(2);

        int a = aList.remove(0);

    }

}
