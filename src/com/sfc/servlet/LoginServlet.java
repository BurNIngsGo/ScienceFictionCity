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

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        UserInfoService userInfoService =new UserInfoServiceImpl();
        String action = req.getParameter("action");
        HttpSession session = req.getSession();

        UserInfo userInfo = null;

        if ("login".equals(action)) {
            try {
                userInfo = userInfoService.userLogin(req.getParameter("name"),req.getParameter("pwd"));
                session.setAttribute("name",userInfo);
                session.setMaxInactiveInterval(60*10);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (userInfo!=null) {
                String strJson = JSON.toJSONString(userInfo);
                out.print(strJson);
            }   else {
                out.print("{uId:0}");
            }
        } else if ("regist".equals(action)) {
            UserInfo userInfo1 = new UserInfo();
            userInfo1.setuName(req.getParameter("name"));
            userInfo1.setuPwd(req.getParameter("pwd"));
            System.out.println(userInfo1.getuName()+","+userInfo1.getuPwd());
            try {
                if(userInfoService.userRegister(userInfo1) > 0) {
                    out.print(1);
                } else {
                    out.print(0);
                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        } else if("check".equals(action)){
            try {
                if(userInfoService.checkUserName(req.getParameter("name")) > 0){
                    out.print("该用户已存在");
                }else{
                    out.print("用户名可以注册");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if("initUser".equals(action)) {
            UserInfo user = (UserInfo)session.getAttribute("name");
            String strJson = JSON.toJSONString(user);
            System.out.println(strJson);
            out.print(strJson);
        }

    }
}
