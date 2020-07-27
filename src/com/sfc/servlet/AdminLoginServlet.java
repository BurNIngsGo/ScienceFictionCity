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

public class AdminLoginServlet extends HttpServlet {

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
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (userInfo!=null && userInfo.getuPost() != 0) {
                String strJson = JSON.toJSONString(userInfo);
                session.setAttribute("name",userInfo);
                session.setMaxInactiveInterval(60*10);
                out.print(strJson);
            }   else {
                out.print("{uId:0}");
            }
        } else if("userInit".equals(action)){
            UserInfo user = (UserInfo)session.getAttribute("name");
            String strJson = JSON.toJSONString(user);
            out.print(strJson);
        }

    }
}
