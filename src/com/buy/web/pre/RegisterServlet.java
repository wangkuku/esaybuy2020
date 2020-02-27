package com.buy.web.pre;

import com.buy.dao.user.IUser;
import com.buy.entity.EasybuyUser;
import com.buy.service.user.IUserService;
import com.buy.service.user.IUserServiceImpl;
import com.buy.utils.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/register"})
public class RegisterServlet extends AbsractServlet {
    IUserService userSerivice= null;

    @Override
    public void init() throws ServletException {
        userSerivice=new IUserServiceImpl();
    }

    public String toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/front/register";
    }

    public ReturnResult  doRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
       ReturnResult result=new ReturnResult();
       //接受前台传过来的用户信息
        String loginName=request.getParameter("loginName");

        //检验loginName的唯一性
        EasybuyUser oldUser = userSerivice.getUserByName(loginName);
        if (EmptyUtils.isEmpty(oldUser)) {
            result.returnFail("用户已存在！");
            return result;
        }

        String userName=request.getParameter("userName");
        String pwd=request.getParameter("pwd");
        String repwd=request.getParameter("repwd");
        Integer sex=Integer.valueOf(request.getParameter("sex"));
        String idCode=request.getParameter("idCode");
        String mobile=request.getParameter("phone");
        String email=request.getParameter("email");

        //封装用户信息
        EasybuyUser user=new EasybuyUser();
        user.setIdentitycode(idCode);
        user.setMobile(mobile);
        user.setSex(EmptyUtils.isEmpty(sex)?1:0);
        user.setLoginname(loginName);
        user.setUsername(userName);
        user.setPassword(SecurityUtils.md5Hex(pwd));
        user.setType(Constants.UserType.PRE);

        //信息校验
         result = checkUser(user);
        if (result.getStatus()== Constants.ReturnResult.SUCCESS) {
            //注册用户
            boolean flag = userSerivice.save(user);
            if (!flag){
                return result.returnFail("注册失败！");
            }else {
                return result.returnSuccess("注册成功！");
            }
        }else {
            return result;
        }
    }

    /***
     * 后期校验数据格式
     * @param user
     * @return
     */
    public ReturnResult checkUser(EasybuyUser user){
        ReturnResult result=new ReturnResult();
        //正则表达式校验
        if (EmptyUtils.isEmpty(user.getMobile())) {
            if (!RegUtils.checkMobile(user.getMobile())){
                result.returnFail("手机格式不正确！");
            }
        }
        if (EmptyUtils.isEmpty(user.getIdentitycode())) {
            if (!RegUtils.checkMobile(user.getIdentitycode())){
                result.returnFail("身份证格式不正确！");
            }
        }
        if (EmptyUtils.isEmpty(user.getEmail())) {
            if (!RegUtils.checkMobile(user.getEmail())){
                result.returnFail("邮箱格式不正确！");
            }
        }
        return result.returnSuccess();
    }

    @Override
    public Class getServletClass() {
        return RegisterServlet.class;
    }
}
