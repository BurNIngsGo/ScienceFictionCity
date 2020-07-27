package com.sfc.servlet;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.BookInfo;
import com.sfc.entity.BookType;
import com.sfc.entity.Press;
import com.sfc.service.BookInfoService;
import com.sfc.service.BookTypeService;
import com.sfc.service.PressService;
import com.sfc.serviceImpl.BookInfoServiceImpl;
import com.sfc.serviceImpl.BookTypeServiceImpl;
import com.sfc.serviceImpl.PressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class BookAddServlet extends HttpServlet {
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
        PressService pressService = new PressServiceImpl();
        BookInfoService bookInfoService = new BookInfoServiceImpl();

        List<BookType> bookTypeList = null;
        List<Press> pressList = null;
        try {
            pressList = pressService.getPressAll();
            bookTypeList = bookTypeService.getBookTypeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if("type".equals(action)) {
            String strJson = JSON.toJSONString(bookTypeList);
            out.print(strJson);
        }else if("press".equals(action)){
            String strJson = JSON.toJSONString(pressList);
            out.print(strJson);
        }else if("add".equals("action")){
            BookInfo bookInfo = new BookInfo();
            bookInfo.setbName(req.getParameter("bname"));
            try {
                bookInfo.setbType(bookTypeService.getBookTypeIdByTypeName(req.getParameter("bType")));
                bookInfo.setbPress(pressService.getPressIdByPressName(req.getParameter("bPress")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            bookInfo.setbAuthor(req.getParameter("bauthor"));
            bookInfo.setbPresent(req.getParameter("bpresent"));
            bookInfo.setbImg(req.getParameter("bImg"));
            bookInfo.setbPrice(Integer.parseInt(req.getParameter("bPrice")));
            bookInfo.setbCount(Integer.parseInt(req.getParameter("bCount")));
            try {
                if(bookInfoService.insertBook(bookInfo) > 0){
                    out.print(1);
                }else {
                    out.print(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
