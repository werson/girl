package com.werson.inter;

import java.util.List;

/**
 * com.werson.inter
 *
 * @author werson
 * @version 1.0.0
 * @since 2020/6/2
 */
public interface ISkuInfo<T extends ISubSkuInfo> {

    void setSubSkus(List<T> subSkus);

    List<T> getSubSkus();

}
