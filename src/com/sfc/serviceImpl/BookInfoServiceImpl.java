package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.BookInfoDao;
import com.sfc.entity.BookInfo;
import com.sfc.entitypage.Page;
import com.sfc.impl.BookInfoDaoImpl;
import com.sfc.service.BookInfoService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookInfoServiceImpl implements BookInfoService {
    /**
     * 获取所有图书信息
     * @return List<BookInfo>
     */
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

    /**
     * 根据类型编号获取图书
     * @param tId
     * @return
     */
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

    /**
     * 根据出版社获取图书信息
     * @param pId
     * @return
     */
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

    /**
     * 对图书信息进行分页
     * @param page
     * @throws SQLException
     */
    public void getBookPage(Page<BookInfo> page) throws SQLException {
        Connection conn = null;
        try {
            conn = BaseDaoUtil.getConnection();
            BookInfoDao bookInfoDao = new BookInfoDaoImpl(conn);

            int totalCount = bookInfoDao.getCount();
            page.setTotalCount(totalCount);

            if (totalCount > 0) {
                if (page.getCurrPageNo() > page.getTotalPageCount())
                    page.setCurrPageNo(page.getTotalPageCount());

                List<BookInfo> bookList = bookInfoDao.getBookPage(page.getCurrPageNo(), page.getPageSize());
                page.setAList(bookList);

            } else {
                page.setCurrPageNo(0);
                page.setAList(new ArrayList<BookInfo>());
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 添加图书(图书上架)
     * @param bi
     * @return
     */
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

    /**
     * 根据图书id删除图书信息
     * @param bId
     * @return
     */
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

    /**
     * 根据图书名称删除图书
     * @param bName
     * @return
     */
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

    /**
     * 根据图书名称获取图书信息
     * @param bName
     * @return
     */
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

    /**
     * 根据图书id获取图书信息
     * @param bid
     * @return
     */
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

    /**
     * 更新图书销量和库存
     * @param bi
     * @return
     */
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

    /**
     * 更新图书信息
     * @param bi
     * @return
     */
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

    /**
     * 获取总数据量
     * @return
     * @throws SQLException
     */
    public int getCount() throws SQLException {
        Connection conn = BaseDaoUtil.getConnection();
        BookInfoDao bookInfoDao = new BookInfoDaoImpl(conn);
        try {
            return bookInfoDao.getCount();
        } catch(SQLException e) {
            throw e;
        }
    }
}
