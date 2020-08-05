package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.BookTypeDao;
import com.sfc.entity.BookInfo;
import com.sfc.entity.BookType;
import com.sfc.entity.Press;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * @Description:图书类型实现
 * @ClassName :BookTypeDaoImpl
 * @Author: AiGuo
 * @DATE:2020/8/3 19:28
 * @Version:1.0
 */
public class BookTypeDaoImpl extends BaseDao implements BookTypeDao{
    public BookTypeDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 获取所有图书类型
     * @return
     */
    public List<BookType> getBookTypeAll() throws SQLException{
        String strSql="select * from bookType";//查询所有图书类型
        try {
            return this.getEntity(new BookType(),null,strSql);//返回执行更新方法的返回值
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据类型id获取类型
     * @param tId
     * @return
     */
    public BookInfo getBookTypeByTId(int tId) throws SQLException{
        String strSql="select * from bookType where  tid=?";//根据图书类型id查询图书类型
        Object[] param ={tId};//创建存储参数的数组
        List<BookInfo> list = null;//定义一个存储bookInfo的list集合
        try {
            list = this.getEntity(new BookInfo(),param,strSql);//返回执行更新方法的返回值
            if (list.size()>0){//如果返回的集合不为空则返回集合第一个对象
                return list.get(0);//返回第一个对象
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据类型id删除类型
     * @param tId
     * @return
     */
    public int delBookTypeByTId(int tId) throws SQLException{
        String strSql="delete  from bookType where tid=?";//根据图书类型id删除图书类型
        Object[] param ={tId};//创建存储参数的数组
        try {
            return this.executeUpdate(strSql,param);//返回执行更新方法的返回值
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据类型名称删除类型
     * @param tId
     * @return
     */
    public int delBookTypeByTName(String tId) throws  SQLException{
        String strSql="delete from bookType where tName=?";//根据图书类型名称删除图书类型
        Object[] param ={tId};//创建存储参数的数组
        try {
            return this.executeUpdate(strSql,param);//返回执行更新方法的返回值
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 添加类型信息
     * @param bk
     * @return
     */
    public int insertBookType(BookType bk) throws  SQLException{
        String strSql="insert  bookType(tName) values(?)";//插入图书类型
        Object[] param ={bk.gettName()};//创建存储参数的数组
        try {
            return this.executeUpdate(strSql,param);//返回执行更新方法的返回值
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 更新图书类型信息
     * @param bk
     * @return
     */
    public int updateBookTypeByTid(BookType bk) throws  SQLException{
        String strSql="update  from bookType set tName=? where tid=?";//根据图书类型id更改图书类型名字
        Object[] param ={bk.gettName(),bk.gettId()};//创建存储参数的数组
        try {
            return this.executeUpdate(strSql,param);//返回执行更新方法的返回值
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据图书类型名称获取类型id
     * @param tName
     * @return
     * @throws SQLException
     */
    public int getBookTypeIdByTypeName(String tName) throws SQLException {
        String strSql = "select * from booktype where tName = ?";//根据类型名字查询图书类型id
        Object[] param = {tName};//创建存储参数的数组
        try {
            return this.getEntity(new BookType(), param, strSql).get(0).gettId();//根据获取到的集合取出第一个对象并且获取第一个对象的id属性值利用get方法
        } catch(SQLException e) {
            throw e;
        }
    }

    /**
     * 根据类型名称获取类型信息
     * @param tName
     * @return
     * @throws SQLException
     */
    public List<BookType> getAllByTypeName(String tName) throws SQLException {
        String strSql = "select * from booktype where tName like \"%\"?\"%\"";//根据名字模糊查询
        Object[] param = {tName};//创建存储参数的数组
        try {
            return this.getEntity(new BookType(),param,strSql);//返回查询到的集合
        } catch (SQLException e) {
            throw e;
        }
    }
}
