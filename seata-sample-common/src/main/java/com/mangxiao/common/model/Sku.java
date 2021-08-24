package com.mangxiao.common.model;

import lombok.Data;

import java.util.Date;

/**
 * 商品类
 */
@Data
public class Sku {

    private Long id;
    /** 商品Id */
    private Long skuId;
    /** 商品名称 */
    private String skuName;
    /** 商品价格 */
    private Float skuPrice;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
    /** 创建人ID */
    private Long createUserId;
    /** 更新人ID */
    private Long updateUserId;
    /** 是否有效 */
    private int yn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Float getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Float skuPrice) {
        this.skuPrice = skuPrice;
    }
}
