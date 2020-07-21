package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.BookTypeDao;
import com.sfc.entity.BookInfo;
import com.sfc.entity.BookType;
import com.sfc.impl.BookTypeDaoImpl;
import com.sfc.service.BookTypeService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookTypeServiceImpl implements BookTypeService {

    /**
     * 获取所有图书类型
     * @return
     */
    public List<BookType> getBookTypeAll() throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookTypeDao bookInfoDao = new BookTypeDaoImpl(conn);
        try{
            return bookInfoDao.getBookTypeAll();
        } catch(SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 根据类型id获取类型
     * @param tId
     * @return
     */
    public BookInfo getBookTypeByTId(int tId) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookTypeDao bookInfoDao = new BookTypeDaoImpl(conn);
        try{
            return bookInfoDao.getBookTypeByTId(tId);
        } catch(SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 根据类型id删除类型
     * @param tId
     * @return
     */
    public int delBookTypeByTId(int tId) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookTypeDao bookInfoDao = new BookTypeDaoImpl(conn);
        try{
            return bookInfoDao.delBookTypeByTId(tId);
        } catch(SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 根据类型名称删除类型
     * @param tId
     * @return
     */
    public int delBookTypeByTName(String tId) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookTypeDao bookInfoDao = new BookTypeDaoImpl(conn);
        try{
            return bookInfoDao.delBookTypeByTName(tId);
        } catch(SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 添加类型信息
     * @param bk
     * @return
     */
    public int insertBookType(BookType bk) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookTypeDao bookInfoDao = new BookTypeDaoImpl(conn);
        try{
            return bookInfoDao.insertBookType(bk);
        } catch(SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 更新图书类型信息
     * @param bk
     * @return
     */
    public int updateBookTypeByTid(BookType bk) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookTypeDao bookInfoDao = new BookTypeDaoImpl(conn);
        try{
            return bookInfoDao.updateBookTypeByTid(bk);
        } catch(SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
