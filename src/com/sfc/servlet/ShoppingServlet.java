package com.sfc.servlet;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.ShoppingInfo;
import com.sfc.service.ShoppingCartService;
import com.sfc.serviceImpl.ShoppingCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
/**
 * @Description:购物车操作
 * @ClassName :ShoppingServlet
 * @Author: AiGuo
 * @DATE:2020/8/3 20:07
 * @Version:1.0
 */
public class ShoppingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

            ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();
            String action = request.getParameter("action");
            List<ShoppingInfo> shop = null;
            if("show".equals(action)) {
                int uid = Integer.parseInt(request.getParameter("userId"));
                try {
                    shop = shoppingCartService.getShoppingCartByUId(uid);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                String jsonStr = JSON.toJSONString(shop);
                out.print(jsonStr);
            } else if("del".equals(action)) {
                try {
                   if(shoppingCartService.delShoppingCartByShId(Integer.parseInt(request.getParameter("shid"))) > 0) {
                       out.print(1);
                   } else {
                       out.print(0);
                   }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

    }
}
