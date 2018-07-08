package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private  ProductServiceImpl productServiceImpl;

    @Test
    public void findOne() {
        ProductInfo  productInfo = productServiceImpl.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productServiceImpl.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest pg = new PageRequest(0,5);
        Page<ProductInfo> pages = productServiceImpl.findAll(pg);
        System.out.println(pages.getTotalElements());
        Assert.assertNotEquals(0,pages.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("小米粥");
        productInfo.setProductPrice(new BigDecimal(2.5));
        productInfo.setProductDescription("很不错的粥");
        productInfo.setProductIcon("http://xxxx/2.jpg");
        productInfo.setProductStock(50);
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = productServiceImpl.save(productInfo);
        Assert.assertNotNull(result);
    }
}