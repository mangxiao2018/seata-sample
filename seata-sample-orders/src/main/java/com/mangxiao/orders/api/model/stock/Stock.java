package com.mangxiao.orders.api.model.stock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("库存")
public class Stock {
    @ApiModelProperty("主键id")
    private Long id;
    /** 商品编号 */
    @ApiModelProperty("商品编号")
    private Long skuId;
    /** 仓库编号 */
    @ApiModelProperty("仓库编号")
    private Long warehouseId;
    /** 商品数量 */
    @ApiModelProperty("商品数量")
    private Integer quantity;
    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /** 更新时间 */
    @ApiModelProperty("更新时间")
    private Date updateTime;
    /** 创建人ID */
    @ApiModelProperty("创建人ID")
    private Long createUserId;
    /** 更新人ID */
    @ApiModelProperty("更新人ID")
    private Long updateUserId;
    /** 是否有效 */
    @ApiModelProperty("是否有效")
    private int yn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
}
