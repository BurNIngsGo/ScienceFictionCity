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
import java.util.List;

public class ReadMainServlet extends HttpServlet {
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
        BookInfoService bookInfoService = new BookInfoServiceImpl();

        List<BookInfo> bookList = null;
        try {
            bookList = bookInfoService.getBookAll();
        }catch (SQLException e){
            e.printStackTrace();
        }
        String strJson = JSON.toJSONString(bookList);
        out.print(strJson);
    }
}
