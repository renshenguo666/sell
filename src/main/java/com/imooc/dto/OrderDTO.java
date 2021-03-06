package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.util.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)      //过期的方式，使用JsonInclude代替
//@JsonInclude(JsonInclude.Include.NON_NULL)      // 此为局部配置，仅对当前类生效
public class OrderDTO {

    /**订单ID*/
    private String orderId;
    /**买家名字*/
    private String buyerName;
    /**买家电话*/
    private String buyerPhone;
    /**买家地址*/
    private String buyer_address;
    /**买家微信openid*/
    private String buyerOpenid;
    /**订单总金额*/
    private BigDecimal orderAmount;
    /**订单状态, 默认0为新下单*/
    private Integer orderStatus;
    /**支付状态, 默认0未支付*/
    private Integer payStatus;
    /**创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /**修改时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    /**订单明细列表*/
    private List<OrderDetail> orderDetailList;

}
