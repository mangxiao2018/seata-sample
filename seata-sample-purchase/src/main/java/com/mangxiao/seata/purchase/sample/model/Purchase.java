package com.mangxiao.seata.purchase.sample.model;

public class Purchase {
    /** 购买的商品编码 */
    private long skuId;
    /** 购买商品的个数*/
    private long quantity;

    public long getSkuId() {
        return skuId;
    }

    public void setSkuId(long skuId) {
        this.skuId = skuId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
