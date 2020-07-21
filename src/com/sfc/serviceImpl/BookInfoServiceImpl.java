package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.BookInfoDao;
import com.sfc.entity.BookInfo;
import com.sfc.impl.BookInfoDaoImpl;
import com.sfc.service.BookInfoService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookInfoServiceImpl implements BookInfoService {
    @Override
    public List<BookInfo> getBookAll() throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookInfoDao bookInfoDao = new BookInfoDaoImpl(conn);
        try{
            return bookInfoDao.getBookAll();
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    @Override
    public List<BookInfo> getBookByType(int tId) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookInfoDao bookInfoDao = new BookInfoDaoImpl(conn);
        try{
            return bookInfoDao.getBookByType(tId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    @Override
    public List<BookInfo> getBookByPressId(int pId) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookInfoDao bookInfoDao = new BookInfoDaoImpl(conn);
        try{
            return bookInfoDao.getBookByPressId(pId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    @Override
    public List<BookInfo> getBookPage(int currentPage, int curtotalSize) throws SQLException {
        return null;
    }

    @Override
    public int insertBook(BookInfo bi) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookInfoDao bookInfoDao = new BookInfoDaoImpl(conn);
        try{
            return bookInfoDao.insertBook(bi);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    @Override
    public int delBookByBId(int bId) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookInfoDao bookInfoDao = new BookInfoDaoImpl(conn);
        try{
            return bookInfoDao.delBookByBId(bId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    @Override
    public int delBookByBName(String bName) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookInfoDao bookInfoDao = new BookInfoDaoImpl(conn);
        try{
            return bookInfoDao.delBookByBName(bName);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    @Override
    public List<BookInfo> getBookByBName(String bName) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookInfoDao bookInfoDao = new BookInfoDaoImpl(conn);
        try{
            return bookInfoDao.getBookByBName(bName);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    @Override
    public BookInfo getBookByBId(int bid) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookInfoDao bookInfoDao = new BookInfoDaoImpl(conn);
        try{
            return bookInfoDao.getBookByBId(bid);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    @Override
    public int updateBookSales(BookInfo bi) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookInfoDao bookInfoDao = new BookInfoDaoImpl(conn);
        try{
            return bookInfoDao.updateBookSales(bi);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    @Override
    public int updateBookByBid(BookInfo bi) throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookInfoDao bookInfoDao = new BookInfoDaoImpl(conn);
        try{
            return bookInfoDao.updateBookByBid(bi);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
