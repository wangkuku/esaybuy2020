package com.buy.service.user;

import com.buy.dao.user.EasybuyUserImpl;
import com.buy.dao.user.IUser;
import com.buy.entity.EasybuyUser;

import java.sql.SQLException;

public class IUserServiceImpl implements IUserService {
    IUser uDao=new EasybuyUserImpl();
    @Override
    public EasybuyUser getUserByName(String loginName) throws Exception {

        return uDao.getUserByloginName(loginName);
    }

    @Override
    public boolean save(EasybuyUser user) {
        return uDao.save(user)>0?true:false;
    }


}
