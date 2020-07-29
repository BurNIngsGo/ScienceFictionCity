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

public class BookTypeDaoImpl extends BaseDao implements BookTypeDao{
    public BookTypeDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<BookType> getBookTypeAll() throws SQLException{
        String strSql="select * from bookType";
        try {
            return this.getEntity(new BookType(),null,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public BookInfo getBookTypeByTId(int tId) throws SQLException{
        String strSql="select * from bookType where  tid=?";
        Object[] param ={tId};
        List<BookInfo> list = null;
        try {
            list = this.getEntity(new BookInfo(),param,strSql);
            if (list.size()>0){
                return list.get(0);
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int delBookTypeByTId(int tId) throws SQLException{
        String strSql="delete  from bookType where tid=?";
        Object[] param ={tId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int delBookTypeByTName(String tId) throws  SQLException{
        String strSql="delete from bookType where tName=?";
        Object[] param ={tId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int insertBookType(BookType bk) throws  SQLException{
        String strSql="insert  bookType(tName) values(?)";
        Object[] param ={bk.gettName()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int updateBookTypeByTid(BookType bk) throws  SQLException{
        String strSql="update  from bookType set tName=? where tid=?";
        Object[] param ={bk.gettName(),bk.gettId()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int getBookTypeIdByTypeName(String tName) throws SQLException {
        String strSql = "select * from booktype where tName = ?";
        Object[] param = {tName};
        try {
            return this.getEntity(new BookType(), param, strSql).get(0).gettId();
        } catch(SQLException e) {
            throw e;
        }
    }

    @Override
    public List<BookType> getAllByTypeName(String tName) throws SQLException {
        String strSql = "select * from booktype where tName = \"%\"?\"%\"";
        Object[] param = {tName};
        try {
            return this.getEntity(new BookType(),param,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }
}
