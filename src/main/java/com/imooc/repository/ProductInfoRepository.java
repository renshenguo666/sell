package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    /**
     * 查询上架的商品
     * @param productStatus
     * @return
     */
     List<ProductInfo> findByProductStatus(Integer productStatus);
}
