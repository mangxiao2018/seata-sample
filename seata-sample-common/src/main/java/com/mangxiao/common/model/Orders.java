package com.mangxiao.common.model;

import java.util.Date;

/**
 * 订单类
 */
public class Orders {
    private Long id;
    /** 订单号*/
    private Long orderId;
    /** 商品id */
    private Long skuId;
    /** 商品价格*/
    private Float skuPrice;
    /** 仓库id */
    private Long warehouseId;
    /** 订单中各商品数量 */
    private Integer quantity;
    /** 订单总金额 */
    private Float totalAmount;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Float getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Float skuPrice) {
        this.skuPrice = skuPrice;
    }
}
