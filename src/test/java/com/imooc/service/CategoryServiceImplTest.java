package com.imooc.service;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Test
    public void findOne() {
        ProductCategory pc = categoryServiceImpl.findOne(1);
        Assert.assertEquals(new Integer(1),pc.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> pcArry = categoryServiceImpl.findAll();
        Assert.assertNotEquals(0,pcArry.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> pcArry = categoryServiceImpl.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,pcArry.size());
    }

    @Test
    public void save() {
        ProductCategory pc = new ProductCategory();
        pc.setCategoryName("男生专享");
        pc.setCategoryType(10);
        ProductCategory result = categoryServiceImpl.save(pc);
        Assert.assertNotNull(result);
    }
}