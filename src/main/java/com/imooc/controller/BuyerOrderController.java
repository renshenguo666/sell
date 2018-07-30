package com.imooc.controller;


import com.imooc.VO.ResultVO;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数错误，orderForm={}",orderForm);
//            throw new SellException();
        }
        return null;
    }

    //订单列表

    //查询订单详情

    //取消订单
}
