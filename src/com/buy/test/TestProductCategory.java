package com.buy.test;

import com.buy.dao.prduct.IProductCategory;
import com.buy.dao.prduct.impl.ProductCategoryImpl;
import com.buy.entity.EasybuyProductCategory;
import org.junit.Test;

import java.util.List;

public class TestProductCategory {
    @Test
    public void testProductCategory(){
        IProductCategory pr=new ProductCategoryImpl();
        List<EasybuyProductCategory> productCategories = pr.queryAllProductCategory("0");
        for (EasybuyProductCategory category:productCategories) {

            System.out.println(category.getName());
        }
    }
}
