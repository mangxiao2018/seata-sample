package com.mangxiao.storage.model;

import lombok.Data;

import java.util.Date;

/***
 * 库存表类
 */
@Data
public class Stock {
    private Long id;
    /** 商品编号 */
    private Long skuId;
    /** 仓库编号 */
    private Long warehouseId;
    /** 商品数量 */
    private Double quantity;
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
}
