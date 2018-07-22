package com.imooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单详情表
 */
@Entity
@Data
public class OrderDetail {

    /**订单详情ID*/
    @Id
    private String detailId;
    /**订单ID*/
    private String orderId;
    /**商品ID*/
    private String productId;
    /**商品名称*/
    private String productName;
    /**商品价格 ：一定不能由前端传过来，应该自己从数据库中查出来*/
    private BigDecimal productPrice;
    /**商品数量*/
    private Integer productQuantity;
    /**商品小图*/
    private String productIcon;



}
