package com.mangxiao.orders.model;

import java.util.Date;

public class Sku {

    private Long id;
    /** 商品名 */
    private String skuName;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;
    /**创建人*/
    private Long createUserId;
    /**更新人*/
    private Long updateUserId;
    /**是否有效*/
    private int yn;

    public Long getId() {
        return id;
    }

    public String getSkuName() {
        return skuName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public int getYn() {
        return yn;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
