package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @RequestMapping("/list")
    public ResultVO list(){
        ResultVO<List<ProductVO>> objectResultVO = new ResultVO<>();
        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();

        productInfoVO.setId("123456");
        productInfoVO.setProductInfoName("皮蛋粥");
        productInfoVO.setPrice(new BigDecimal(2.1));
        productInfoVO.setDescription("超好吃");
        productInfoVO.setIcon("http://xxx.jpg");

        productVO.setCategoryName("热榜");
        productVO.setCategoryType(1);
        productVO.setFoods(Arrays.asList(productInfoVO,new ProductInfoVO()));

        objectResultVO.setCode(0);
        objectResultVO.setMsg("成功");
        objectResultVO.setData(Arrays.asList(productVO,new ProductVO()));

        return objectResultVO;
    }




}
