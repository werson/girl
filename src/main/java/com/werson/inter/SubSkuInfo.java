package com.werson.inter;

/**
 * com.werson.inter
 *
 * @author werson
 * @version 1.0.0
 * @since 2020/6/2
 */
public class SubSkuInfo implements ISubSkuInfo {

    int sku;

    @Override
    public void setSku(int sku) {
        this.sku = sku;
    }

    @Override
    public int getSku() {
        return sku;
    }
}
