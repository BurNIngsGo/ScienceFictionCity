package com.sfc.servlet;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.BookInfo;
import com.sfc.service.BookInfoService;
import com.sfc.serviceImpl.BookInfoServiceImpl;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class ReadSingleServlet extends HttpServlet {
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
        String book = req.getParameter("bookId");
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        BookInfoService bookInfoService = new BookInfoServiceImpl();
        if("saveBookid".equals(action)) {
            BookInfo listbook = null;
            try {
                listbook = bookInfoService.getBookByBId(Integer.parseInt(book));
                session.setAttribute("bookId", listbook);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String strJson = JSON.toJSONString(listbook);
            out.print(strJson);
        } else if("getInfo".equals(action)){
            BookInfo bookInfo = null;
            bookInfo = (BookInfo)session.getAttribute("bookId");
            String strJson = JSON.toJSONString(bookInfo);
            out.print(strJson);
        }
    }
}
