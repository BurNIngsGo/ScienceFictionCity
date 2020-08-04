package com.sfc.servlet;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.UserInfo;
import com.sfc.service.UserInfoService;
import com.sfc.serviceImpl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
/**
 * @Description:用户登录注册操作
 * @ClassName :LoginServlet
 * @Author: AiGuo
 * @DATE:2020/8/3 19:55
 * @Version:1.0
 */
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//设置字符编码
        resp.setContentType("text/html;charset=utf-8");//设置响应字符编码
        PrintWriter out = resp.getWriter();//创建out对象
        UserInfoService userInfoService =new UserInfoServiceImpl();//实例化用户业务逻辑层
        String action = req.getParameter("action");//利用请求对象获取前端action的值
        HttpSession session = req.getSession();//利用请求对象创建session对象

        UserInfo userInfo = null;//定义一个userInfo对象初始化为空
        //登录
        if ("login".equals(action)) {//判断请求的action的值是否为login
            try {
                userInfo = userInfoService.userLogin(req.getParameter("name"),req.getParameter("pwd"));//调用登录方法获取用户姓名和密码
                session.setAttribute("name",userInfo);//获取session中根据键：name存的值userInfo对象
                session.setMaxInactiveInterval(60*10);//设置存储的有效期为十分钟
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (userInfo!=null) {//判断获取的userInfo值不为空的话直接转json
                String strJson = JSON.toJSONString(userInfo);//转化为json格式
                out.print(strJson);
            }   else {
                out.print("{uId:0}");//返回值为空的json格式
            }
            //注册
        } else if ("regist".equals(action)) {//判断请求的action的值是否为regist
            UserInfo userInfo1 = new UserInfo();//创建一个用户对象（用户信息实体类）
            userInfo1.setuName(req.getParameter("name"));//获取用户姓名
            userInfo1.setuPwd(req.getParameter("pwd"));//获取用户密码
            try {
                if(userInfoService.userRegister(userInfo1) > 0) {//判断调用注册方法是否>0（是否添加到数据库）成功则为1
                    out.print(1);
                } else {
                    out.print(0);
                }

            }catch(SQLException e){
                e.printStackTrace();
            }
            //注册验证
        } else if("check".equals(action)){//判断请求的action的值是否为check
            try {
                if(userInfoService.checkUserName(req.getParameter("name")) > 0){//判断获取的用户名是否>0 大于则已存在
                    out.print("该用户已存在");
                }else{
                    out.print("用户名可以注册");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //判断用户是否登录
        } else if("initUser".equals(action)) {//判断请求的action的值是否为initUser
            UserInfo user = (UserInfo)session.getAttribute("name");//（强转UserInfo）将获取登录的用户信息从session中提取出来
            String strJson = JSON.toJSONString(user);//转json格式
            out.print(strJson);
        }

    }
}
