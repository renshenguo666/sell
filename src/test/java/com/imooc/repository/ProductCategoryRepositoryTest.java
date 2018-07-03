package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory =  repository.findOne(1);
        log.info(productCategory.toString());
    }
    @Test
    @Transactional
    public void saveTest(){
        ProductCategory pc = new ProductCategory();
        pc.setCategoryName("男生最爱");
        pc.setCategoryType(10);
        ProductCategory tmp_pc = repository.save(pc);
        Assert.assertNotNull(tmp_pc);
    }
    @Test
    public void updateTest(){
        ProductCategory pc = repository.findOne(2);
//        pc.setCategoryName("女生最爱");
        pc.setCategoryType(3);
        repository.save(pc);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> ctgyType = Arrays.asList(2,3);
        List<ProductCategory> pcArry = repository.findByCategoryTypeIn(ctgyType);
        Assert.assertNotEquals(0,pcArry.size());
    }



}

