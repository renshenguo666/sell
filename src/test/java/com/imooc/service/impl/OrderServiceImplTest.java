package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private  OrderServiceImpl orderServiceImpl;
    private final String BUYYER_OPENID = "110110";
    private final String ORDERID = "1532254172071965951";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerPhone("18868822111");
        orderDTO.setBuyer_address("慕课网总部");
        orderDTO.setBuyerOpenid(BUYYER_OPENID);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123459");
        orderDetail.setProductQuantity(222);
        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("123456");
        orderDetail2.setProductQuantity(2);

        orderDetailList.add(orderDetail);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderServiceImpl.create(orderDTO);
        log.info("【创建订单】：result={}",result);
    }

    @Test
    public void findOne() {
        OrderDTO result = orderServiceImpl.findOne(ORDERID);
        log.info("查询一个订单,result={}",result);
        Assert.assertEquals(ORDERID,result.getOrderId());
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}