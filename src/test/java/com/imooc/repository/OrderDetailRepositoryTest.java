package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("100001");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("xxx/2.jpg");
        orderDetail.setProductId("111112");
        orderDetail.setProductName("可乐");
        orderDetail.setProductPrice(new BigDecimal(3.5));
        orderDetail.setProductQuantity(2);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByOrderId() {
        List<OrderDetail> orders = repository.findByOrderId("123456");
        Assert.assertNotEquals(0,orders.size());
    }
}