package com.werson.inter;

import java.util.List;

/**
 * com.werson.inter
 *
 * @author werson
 * @version 1.0.0
 * @since 2020/6/2
 */
public class SkuInfo<T extends ISubSkuInfo> implements ISkuInfo {

    private List<T> subSkuInfos;

    @Override
    public void setSubSkus(List subSkus) {
        this.subSkuInfos =  subSkus;
    }

    @Override
    public List<T> getSubSkus() {
        return subSkuInfos;
    }


}
