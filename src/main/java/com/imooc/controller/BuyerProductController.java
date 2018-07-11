package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 */

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
    public ResultVO list(){

        //1.查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目（一次性查询）
        //传统写法（java8之前）
       /* List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        //java8的写法
        List<Integer> categoryTypeList = productInfoList.stream()
                                                        .map(e -> e.getCategoryType())
                                                        .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据包装



        ResultVO<List<ProductVO>> objectResultVO = new ResultVO<>();
        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();

        productInfoVO.setProductId("123456");
        productInfoVO.setProductName("皮蛋粥");
        productInfoVO.setProductPrice(new BigDecimal(2.1));
        productInfoVO.setProductDescription("超好吃");
        productInfoVO.setProductIcon("http://xxx.jpg");

        productVO.setCategoryName("热榜");
        productVO.setCategoryType(1);
        productVO.setProductInfoVOList(Arrays.asList(productInfoVO,new ProductInfoVO()));

        objectResultVO.setCode(0);
        objectResultVO.setMsg("成功");
        objectResultVO.setData(Arrays.asList(productVO,new ProductVO()));

        return objectResultVO;
    }




}
