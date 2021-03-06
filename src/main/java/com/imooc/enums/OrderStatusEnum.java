package com.imooc.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;
    private Integer code;
    private String msg;

    private OrderStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
