package com.sfc.servlet;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.BookType;
import com.sfc.entity.UserInfo;
import com.sfc.impl.ManageEvaDaoImpl;
import com.sfc.service.UserInfoService;
import com.sfc.serviceImpl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        String action = req.getParameter("action");

        UserInfoService userInfoService = new UserInfoServiceImpl();

        List<UserInfo> userList = null;
        UserInfo userInfo = new UserInfo();
        if ("select".equals(action)){
            try {
                userList = userInfoService.selectGetUserByName(req.getParameter("tName"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String strJson = JSON.toJSONString(userList);
            out.print(strJson);
        }else if("update".equals(action)){
            try{
                int id = Integer.parseInt(req.getParameter("uid"));
                String name = req.getParameter("uname");
                String phone = req.getParameter("uphone");
                String email = req.getParameter("uemail");
                int sex = Integer.parseInt(req.getParameter("usex"));
                UserInfo tempUser = userInfoService.getUserById(id).get(0);
                tempUser.setuName(name);
                tempUser.setuPhone(phone);
                tempUser.setuEmail(email);
                tempUser.setuSex(sex);
                if(userInfoService.updateUserByuId(tempUser) > 0){
                    out.print(1);
                }else {
                    out.print(0);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else if("delete".equals(action)){
            try {
                if(userInfoService.deleteUserById(userInfo.getuId()) > 0){
                    out.print(1);
                } else {
                    out.print(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if("show".equals(action)) {
            try {
                userList = userInfoService.getUserAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String strJson = JSON.toJSONString(userList);
            out.print(strJson);
        }
    }
}
