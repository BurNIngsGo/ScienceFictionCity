package com.sfc.servlet;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.Friend;
import com.sfc.service.FriendRelationService;
import com.sfc.serviceImpl.FriendRelationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * 好友
 */
public class FriendsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        FriendRelationService friend = new FriendRelationServiceImpl();
        String action = request.getParameter("action");
        List<Friend> fir = null;
        if("show".equals(action)) {
            int uid = Integer.parseInt(request.getParameter("userId"));
            try {
                fir = friend.showFriend(uid);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String jsonStr = JSON.toJSONString(fir);
            out.print(jsonStr);
        } else if("del".equals(action)) {
//            try {
//                if(shoppingCartService.delShoppingCartByShId(Integer.parseInt(request.getParameter("shid"))) > 0) {
//                    out.print(1);
//                } else {
//                    out.print(0);
//                }
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }



}
    }
}
