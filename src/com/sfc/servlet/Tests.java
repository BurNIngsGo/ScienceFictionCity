package com.sfc.servlet;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.BookInfo;
import com.sfc.entity.BookType;
import com.sfc.entity.Press;
import com.sfc.entitypage.Page;
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

public class Tests extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        BookInfoService bookInfoService = new BookInfoServiceImpl();
        BookTypeService bookTypeService = new BookTypeServiceImpl();
        PressService pressService = new PressServiceImpl();
        String param = request.getParameter("name");
        String pageNo = request.getParameter("index") != null ? request.getParameter("index"):"1";
        List<BookInfo> list = null;
        List<BookType> list1 = null;
        List<Press> list2 = null;
        List<BookInfo> bookPageList = null;
        Page<BookInfo> page = new Page<>();
        page.setCurrPageNo(Integer.parseInt(pageNo));
        try {
            list = bookInfoService.getBookAll();
            list1 = bookTypeService.getBookTypeAll();
            list2 = pressService.getPressAll();
            bookInfoService.getBookPage(page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if("login".equals(param)) {

        } else if("register".equals(param)) {

        } else if("mainNav".equals(param)) {
            String strJson = "[";
            int i = 0;
            for(BookInfo bookInfo : list) {
                strJson += "{\"url\":\"image/"+bookInfo.getbImg()+"\"}";
                if(i != list.size()-1) {
                    strJson += ",";
                }
                i++;
            }
            strJson += "]";
            out.print(strJson);
        } else if("mainPai".equals(param)) {
//            String strJson = "[\n";
//            int i = 0;
//            for(BookInfo bookInfo : list){
//                strJson +=  "{\"url\":\""+bookInfo.getbImg()+"\"," +
//                        "\"name\":\""+bookInfo.getbName()+"\"," +
//                        "\"author\":\""+bookInfo.getbAuthor()+"\"," +
//                        "\"contxt\":\""+bookInfo.getbPresent()+"\"}";
//                if(i != list.size() - 1) {
//                    strJson += ",\n";
//                }
//                i++;
//            }
//            strJson += "]\n";
            out.print(JSON.toJSONString(list));
        } else if("shopType".equals(param)) {
            String strJson = "[";
            int i = 0;
            for(BookType bookType : list1) {
                strJson += "{\"tname\":\""+bookType.gettName()+"\"}";
                if(i != list1.size() - 1 ) {
                    strJson += ",";
                }
                i++;
            }
            strJson += "]";
            out.print(strJson);
        } else if("shopPree".equals(param)) {
            String strJson = "[";
            int i = 0;
            for(Press press : list2) {
                strJson += "{\"tpree\":\""+press.getPrName()+"\"}";
                if(i != list1.size() - 1 ) {
                    strJson += ",";
                }
                i++;
            }
            strJson += "]";
            out.print(strJson);
        } else if("bookShInfo".equals(param)) {
            String strJson = "[";
            int i = 0;
            for(BookInfo bookInfo : page.getAList()) {
                strJson += "{\"bimg\":\""+bookInfo.getbImg()+"\"," +
                        "\"bName\":\""+bookInfo.getbName()+"\"," +
                        "\"author\":\""+bookInfo.getbAuthor()+"\"," +
                        "\"press\":\""+bookInfo.getbPress()+"\"," +
                        "\"price\":\""+bookInfo.getbPrice()+"\"}";
                if(i != page.getAList().size() - 1) {
                    strJson += ",";
                }
                i++;
            }
            strJson += "]";
            out.print(strJson);
        } else if("pageNum".equals(param)){
            try {
                int count = bookInfoService.getCount();
                double pco = count/8.0;
                out.print(Math.ceil(pco));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if("selects".equals(param)) {
            String bookType = request.getParameter("type");
            String press = request.getParameter("press");
            int begin = Integer.parseInt(request.getParameter("btime"));
            int end = Integer.parseInt(request.getParameter("etime"));
            List<BookInfo> blist = null;
            try {
                blist = bookInfoService.getBookByTypeAndPressAndTime(bookType,press,begin,end);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String strJSON = JSON.toJSONString(blist);
            out.print(strJSON);
        }
    }
}
