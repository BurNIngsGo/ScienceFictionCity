package com.sfc.servlet;

import com.alibaba.fastjson.JSON;
import com.sfc.entity.BookType;
import com.sfc.entity.UserInfo;
import com.sfc.impl.ManageEvaDaoImpl;
import com.sfc.service.UserInfoService;
import com.sfc.serviceImpl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
/**
 * @Description:会员操作
 * @ClassName :MemberServlet
 * @Author: AiGuo
 * @DATE:2020/8/3 19:56
 * @Version:1.0
 */
public class MemberServlet extends HttpServlet {
    /**|
     * 如果get方式请求则调用post方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    /**
     * 会员信息查询修改删除具体操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//设置字符编码
        resp.setContentType("text/html;charset=utf-8");//设置响应字符编码
        PrintWriter out = resp.getWriter();//创建out对象
        String action = req.getParameter("action");//利用请求对象获取前端action的值

        UserInfoService userInfoService = new UserInfoServiceImpl();//实例化用户业务逻辑层

        List<UserInfo> userList = null;//定义存储类型为userInfo的集合并初始化为空
        if ("select".equals(action)){//（查询）判断请求的action的值是否为select
            try {
                userList = userInfoService.selectGetUserByName(req.getParameter("tName"));//根据名字（模糊查询）获取管理员信息
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String strJson = JSON.toJSONString(userList);//转化成json格式
            out.print(strJson);
        }else if("update".equals(action)){//（修改）判断请求的action值是否为update
            try{
                int id = Integer.parseInt(req.getParameter("uid"));//将利用请求对象获取到的用户id强制转换为整型
                String name = req.getParameter("uname");//利用请求对象获取姓名
                String phone = req.getParameter("uphone");//利用请求对象获取电话
                String email = req.getParameter("uemail");//利用请求对象获取邮箱
                int sex = Integer.parseInt(req.getParameter("usex"));//利用请求对象获取用户的性别强制转换为整型
                UserInfo tempUser = userInfoService.getUserById(id).get(0);//根据用户id获取用户信息，由于返回是集合并且根据id查询只能返回一个对象所以用get（0）
                tempUser.setuName(name);//设置名字
                tempUser.setuPhone(phone);//设置电话
                tempUser.setuEmail(email);//设置邮箱
                tempUser.setuSex(sex);//设置性别
                if(userInfoService.updateUserByuId(tempUser) > 0){//判断是否更改成功根据用户id更新用户>0则更新成功
                    out.print(1);
                }else {
                    out.print(0);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else if("delete".equals(action)){//（删除）判断请求的action值是否为delete
            try {
                if(userInfoService.deleteUserById(Integer.parseInt(req.getParameter("uId"))) > 0){//判断根据id删除用户（强制转换）请求id >0则删除成功
                    out.print(1);
                } else {
                    out.print(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if("show".equals(action)) {//（显示）判断请求的action值是否为show
            try {
                userList = userInfoService.getUserAll();//调用显示所有信息方法
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String strJson = JSON.toJSONString(userList);//转换为json格式
            out.print(strJson);
        } else if("deletes".equals(action)) {//（批量删除）判断请求的action值是否为deletes
            String ids = req.getParameter("ids");//获取字符串ids
            String[] uIdArr = ids.split(",");//利用split根据逗号分隔id
            boolean bFlag = false;//初始化为bFlag为false
            for(String str : uIdArr) {//增强版for循环 将uIdArr数组中的字符串一一赋值到str中
                try {
                    if(userInfoService.deleteUserById(Integer.parseInt(str)) > 0){//判断根据id删除是否成功（强转）>0 则为true
                        bFlag = true;
                    } else {
                        bFlag = false;
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            out.print(bFlag);//返回结果
        }
    }
}
