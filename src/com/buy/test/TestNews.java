package com.buy.test;

import com.buy.dao.news.NewsDaoImpl;

public class TestNews {
    public static void main(String[] args) {
        NewsDaoImpl newsDao=new NewsDaoImpl();
         System.out.println(newsDao.getAllNewList().size());
    }
}
