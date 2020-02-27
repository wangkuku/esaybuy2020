package com.buy.test;

import com.buy.dao.user.EasybuyUserImpl;
import com.buy.dao.user.IUser;
import com.buy.entity.EasybuyUser;

public class TestSaveUser {
    public static void main(String[] args) {
        IUser easybuyUser=new EasybuyUserImpl();
        EasybuyUser user=new EasybuyUser();
        user.setUsername("普通用户");
        user.setType(0);
        user.setPassword("123456");
        user.setLoginname("guess111");
        user.setMobile("15324176464");
        user.setIdentitycode("1307984561231234562");
        user.setEmail("guess@qq.com");
        user.setSex(1);
        int id = easybuyUser.save(user);
        System.out.println(id);
    }

}
