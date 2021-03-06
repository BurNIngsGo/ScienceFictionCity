package com.sfc.servlet;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.Press;
import com.sfc.service.PressService;
import com.sfc.serviceImpl.PressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
/**
 * @Description:出版社信息操作
 * @ClassName :PaiHangServlet
 * @Author: AiGuo
 * @DATE:2020/8/3 19:58
 * @Version:1.0
 */
public class PressServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        String action = req.getParameter("action");

        PressService pressService = new PressServiceImpl();


        if("add".equals(action)) {
            Press press = new Press();
            press.setPrName(req.getParameter("prName"));
            try {
                if (pressService.insertPress(press) > 0) {
                    out.print(1);
                } else {
                    out.print(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if("del".equals(action)) {
            try {
                if(pressService.delPressByOId(Integer.parseInt(req.getParameter("prId"))) > 0){
                    out.print(1);
                } else {
                    out.print(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if("show".equals(action)) {
            List<Press> pressList = null;
            try {
                pressList = pressService.getPressAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String strJson = JSON.toJSONString(pressList);
            out.print(strJson);
        } else if("seach".equals(action)) {
            List<Press> pressList = null;
            try {
                pressList = pressService.getAllByPrName(req.getParameter("prName"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String strJson = JSON.toJSONString(pressList);
            out.print(strJson);
        }
    }
}
