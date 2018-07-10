package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品详情
 */
@Data
public class ProductInfoVO {

    private String id;
    @JsonProperty(value = "name")
    private String productInfoName;

    private BigDecimal price;

    private String description;

    private String icon;


}
