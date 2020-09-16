package com.mangxiao.seata.sample.model;

import java.util.Date;

public class Sku {

    private Long id;

    private String skuName;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;

    private Long updateUserId;

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
