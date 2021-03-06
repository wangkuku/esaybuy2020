package com.buy.dao.prduct.impl;

import com.buy.dao.prduct.IProductCategory;
import com.buy.entity.EasybuyProductCategory;
import com.buy.utils.DataSourceUtil;
import com.buy.utils.ProductCategoryVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryImpl implements IProductCategory {
    @Override
    public List<EasybuyProductCategory> queryAllProductCategory(String parentId) {
        List<EasybuyProductCategory> productCategories=new ArrayList<EasybuyProductCategory>();
        EasybuyProductCategory productCategory=null;
        try {
            StringBuffer sql=new StringBuffer();
            sql.append("SELECT * FROM `easybuy_product_category` WHERE 1=1 ");

            //判断parentId的值，如果为0，是一级分类
            if((!"".equals(parentId)||null!=parentId)){
                sql.append("and parentId=0");
            }

            //获取连接
            Connection conn= DataSourceUtil.getConn();
            PreparedStatement pstmt=conn.prepareStatement(sql.toString());

            ResultSet rs=pstmt.executeQuery();
            //处理结果集
            while (rs.next()){
                //实例化对象
                productCategory =new EasybuyProductCategory();
                productCategory.setId(rs.getInt(1));
                productCategory.setName(rs.getString(2));
                productCategory.setParentid(rs.getInt(3));
                productCategory.setType(rs.getInt(4));
                productCategory.setIconclass(rs.getString(5));
                //将对象填充到集合中
                productCategories.add(productCategory);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productCategories;
    }

    @Override
    public List<ProductCategoryVo> queryAllProductCategory() {
        //查询一级分类的列表
        List<ProductCategoryVo> pc1VoList = new ArrayList<ProductCategoryVo>();
        //查询一级分类
        List<EasybuyProductCategory> pcList = queryAllProductCategory(null);
        //查询二级分类
        for (EasybuyProductCategory productCategory1 : pcList) {
            ProductCategoryVo pc1Vo = new ProductCategoryVo();
            pc1Vo.setProductCategory(productCategory1);
            //查询二级分类的VO
            List<ProductCategoryVo> pc2VoList = new ArrayList<ProductCategoryVo>();
            //查询二级分类
            List<EasybuyProductCategory> pc2List
                    = queryAllProductCategory(productCategory1.getId().toString());
            for (EasybuyProductCategory productCategory2 : pc2List) {
                ProductCategoryVo pc2Vo = new ProductCategoryVo();
                pc2Vo.setProductCategory(productCategory2);
                //查询三级分类的VO
                List<ProductCategoryVo> pc3VoList = new ArrayList<ProductCategoryVo>();
                //查询三级分类
                List<EasybuyProductCategory> pc3List
                        = queryAllProductCategory(productCategory2.getId().toString());
                for (EasybuyProductCategory productCategory3 : pc3List) {
                    ProductCategoryVo pc3Vo = new ProductCategoryVo();
                    pc3Vo.setProductCategory(productCategory3);
                    //
                    pc3VoList.add(pc3Vo);
                }
                pc2Vo.setProductCategoryVoList(pc3VoList);
                pc2VoList.add(pc2Vo);
            }
            pc1Vo.setProductCategoryVoList(pc1VoList);
            pc1VoList.add(pc1Vo);
        }
        return pc1VoList;
    }
}

