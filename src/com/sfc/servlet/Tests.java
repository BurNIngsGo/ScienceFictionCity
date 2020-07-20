package com.sfc.servlet;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.AddressInfoDao;
import com.sfc.entity.AddressInfo;
import com.sfc.impl.AddressInfoDaoImpl;

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
        AddressInfoDao addressInfoDao = new AddressInfoDaoImpl(BaseDaoUtil.getConnection());
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        List<AddressInfo> list = null;
        try {
            list = addressInfoDao.getAllAdddress();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }
        out.print(list.get(0).getaAddress()+list.get(0).getaCode()+list.get(0).getaPhone());
        System.out.println(list.get(0).getaAddress());
    }
}
