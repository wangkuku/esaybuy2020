package com.buy.service.product;

import com.buy.dao.prduct.IProductCategory;
import com.buy.dao.prduct.impl.ProductCategoryImpl;
import com.buy.entity.EasybuyProductCategory;

import java.util.List;

public class ProductCategoryServiceImpl implements ProductCategoryService {
    private IProductCategory productCategory=new ProductCategoryImpl();
    @Override
    public List<EasybuyProductCategory> queryAllProductCategory(String parentId) {
        parentId="0";
        return productCategory.queryAllProductCategory(parentId);
    }
}
