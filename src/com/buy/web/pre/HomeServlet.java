package com.buy.web.pre;

import com.buy.dao.news.INewDao;
import com.buy.dao.news.NewsDaoImpl;
import com.buy.entity.EasybuyNews;
import com.buy.entity.EasybuyProductCategory;
import com.buy.service.news.INewService;
import com.buy.service.news.NewsServiceImpl;
import com.buy.service.product.ProductCategoryService;
import com.buy.service.product.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = {"/home"})
public class HomeServlet extends AbsractServlet {
   /* protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从service层获取数据
        ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
        List<EasybuyProductCategory> categoryList = productCategoryService.queryAllProductCategory("0");

        //存储数据
        request.setAttribute("categoryList",categoryList);

        //携带数据跳转到home.jsp
        request.getRequestDispatcher("/front/home.jsp").forward(request,response);
    }*/

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request,response);
//    }

    ProductCategoryService productCategoryService;
    INewService newService;
    @Override
    public void init() throws ServletException {
        //从service层获取数据
         productCategoryService = new ProductCategoryServiceImpl();
         newService=new NewsServiceImpl();
    }

    public String  index(HttpServletRequest request, HttpServletResponse response)throws Exception{
        //从service层获取数据
        ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
        List<EasybuyProductCategory> categoryList = productCategoryService.queryAllProductCategory("0");

        List<EasybuyNews> newsList = newService.getAllNewList();
        //存储数据
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("newsList",newsList);

        //页面内跳转
        return "/front/home";
    }

    @Override
    public Class getServletClass() {
        return HomeServlet.class;
    }


}