package com.sfc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.BookInfo;
import com.sfc.service.BookInfoService;
import com.sfc.serviceImpl.BookInfoServiceImpl;

import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class newBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookInfoService bookInfoService = new BookInfoServiceImpl();

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        List<BookInfo> bookList = null;
        try {
            bookList = bookInfoService.getBookAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<BookInfo> list = new ArrayList<>();
        for(BookInfo bookInfo : bookList) {
            if(bookInfo.getbTime().getYear() == new Date().getYear() && bookInfo.getbTime().getMonth() == new Date().getMonth()) {
                list.add(bookInfo);
            }
        }

        String strJson = JSON.toJSONString(list);
        out.print(strJson);
    }
}
