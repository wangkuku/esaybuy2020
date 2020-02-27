package com.buy.test;

import com.buy.dao.prduct.impl.ProductCategoryImpl;
import com.buy.utils.ProductCategoryVo;
import org.junit.Test;

import java.util.List;

public class TestProductCategoryVo {
    @Test
    public void testProductCategoryVo(){
        ProductCategoryImpl productCategory=new ProductCategoryImpl();
        List<ProductCategoryVo> productCategoryVos = productCategory.queryAllProductCategory();
        for (ProductCategoryVo categoryVos: productCategoryVos) {
            System.out.println(categoryVos.getProductCategory());
        }

    }
}
