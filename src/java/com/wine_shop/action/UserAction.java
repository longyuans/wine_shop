package com.wine_shop.action;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.wine_shop.bean.User;
import com.wine_shop.wineService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Map;

/**
 * 用户操作
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
    private  User user;
    @Autowired
    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 注册
     * @return
     */
    public String regist(){
        try {
            userService.insertUser(model);
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError("注册失败,请重新注册！");
            return "error";
        }
        System.out.println(user.toString());
        return "login";
    }

    /**
     * 登陆
     * @return
     */
    public String login(){
        User user = null;
        Map session = ActionContext.getContext().getSession();
        try {
            user = userService.getUserByName( model);
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError("登陆失败！");
            return "error";
        }
        if(user!=null){
            if (user.getPassword().equals(model.getPassword())) {
                //登录成功，先将用户存储到session中
                application.put("user", user);
                return "success";
            }
        }
        this.addActionError("用户名或密码错误！");
        return "error";
    }

    /**d
     * 登出
     * @return
     */
    public String loginOut() {
        try{
            application.remove("user");
        }catch (Exception e){
            e.printStackTrace();
            this.addActionError("似乎出了点小问题~");
            return "";
        }
        return "success";
    }

    /**
     * 用户信息修改
     * @return
     * @throws Exception
     */
    public String infoChange(){
        try {
            userService.updateUser(model);
        } catch (Exception e) {
            this.addActionError("修改信息异常，请重试！");
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 判断是否登陆
     * @return
     */
    public String isLogin() throws Exception {
        JSONObject result = new JSONObject();
        if("".equals(request.getSession().getAttribute("user"))){
            result.put("code",1);
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain; charset=utf-8");
        if(!result.isEmpty()){
            response.getWriter().println(result.toString());
        }
        response.getWriter().flush();
        response.getWriter().close();
        return "null";
    }
}
