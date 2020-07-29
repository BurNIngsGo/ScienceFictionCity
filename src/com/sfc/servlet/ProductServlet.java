package com.sfc.servlet;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.BookType;
import com.sfc.service.BookTypeService;
import com.sfc.serviceImpl.BookTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class ProductServlet extends HttpServlet {
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

        BookTypeService bookTypeService = new BookTypeServiceImpl();

        BookType bookType = new BookType();

        bookType.settName(req.getParameter("tName"));

        if("add".equals(action)) {
            try {
                if (bookTypeService.insertBookType(bookType) > 0) {
                    out.print(1);
                } else {
                    out.print(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if("del".equals(action)) {
            try {
                if(bookTypeService.delBookTypeByTName(req.getParameter("tName")) > 0){
                    out.print(1);
                } else {
                    out.print(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if("show".equals(action)) {
            List<BookType> typeList = null;
            try {
                typeList = bookTypeService.getBookTypeAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String strJson = JSON.toJSONString(typeList);
            out.print(strJson);
        } else if("seach".equals(action)) {
            List<BookType> typeList = null;
            try {
                typeList = bookTypeService.getAllByTypeName(req.getParameter("tName"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String strJson = JSON.toJSONString(typeList);
            out.print(strJson);
        }
    }
}
