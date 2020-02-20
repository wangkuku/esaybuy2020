package com.buy.service.product;

import com.buy.entity.EasybuyProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<EasybuyProductCategory> queryAllProductCategory(String parentId);
}
