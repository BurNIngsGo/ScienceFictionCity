package com.sfc.servlet;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.BookInfo;
import com.sfc.service.BookInfoService;
import com.sfc.serviceImpl.BookInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookInfoServlet extends HttpServlet {
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

        String action = req.getParameter("action");

        BookInfoService bookInfoService = new BookInfoServiceImpl();
        List<BookInfo> bookInfoList = null;
        try {
            bookInfoList = bookInfoService.getBookAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if("getall".equals(action)) {
            String strJson = JSON.toJSONString(bookInfoList);
            out.print(strJson);
        } else if("del".equals(action)){ //action.equals("del")
            try {
                if(bookInfoService.delBookByBId(Integer.parseInt(req.getParameter("bId"))) > 0) {
                    out.print(1);
                } else {
                    out.print(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}