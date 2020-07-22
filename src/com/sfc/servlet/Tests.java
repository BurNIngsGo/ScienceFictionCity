package com.sfc.servlet;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.BookInfo;
import com.sfc.service.BookInfoService;
import com.sfc.serviceImpl.BookInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class Tests extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        BookInfoService bookInfoService = new BookInfoServiceImpl();
        List<BookInfo> list = null;
        try {
            list = bookInfoService.getBookAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String str = "[";
        int i = 0;
        for(BookInfo bookInfo : list) {
            str += "{\"url\":\"image/"+bookInfo.getbImg()+"\"}";
            if(i != list.size()-1) {
                str += ",";
            }
            i++;
        }
        str += "]";
        out.print(str);
    }
}
