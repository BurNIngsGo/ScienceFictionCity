package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.BookInfoDao;
import com.sfc.entity.BookInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookInfoDaoImpl extends BaseDao implements BookInfoDao {
    public BookInfoDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 获取所有图书信息
     * @return List<BookInfo>
     */
    public List<BookInfo> getBookAll() throws SQLException{
        String strSql="select * from bookInfo";
        try {
            return this.getEntity(new BookInfo(),null,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据类型编号获取图书
     * @param tId
     * @return
     */
    public List<BookInfo> getBookByType(int tId) throws SQLException{
        String strSql="select * from bookInfo where bType=?";
        Object[] param={tId};
        try {
            return this.getEntity(new BookInfo(),param,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据出版社获取图书信息
     * @param pId
     * @return
     */
    public List<BookInfo> getBookByPressId(int pId) throws SQLException{
        String strSql="select * from bookInfo where bPress=?";
        Object[] param={pId};
        try {
            return this.getEntity(new BookInfo(),param,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<BookInfo> getBookPage(int currentPage, int curtotalSize) {

        return null;
    }

    /**
     * 添加图书(图书上架)
     * @param bi
     * @return
     */
    public int insertBook(BookInfo bi) throws SQLException{
        String strSql="insert bookInfo(bName,bType,bPress,bAuthor,bPrice,bImg,bSales,bTime,bCount,bContent)" +
                "values(?,?,?,?,?,?,?,?,?,?)";
        Object[] param={bi.getbName(),bi.getbType(),bi.getbPress(),bi.getbAuthor(),bi.getbPrice(),bi.getbImg(),bi.getbSales(),bi.getbTime(),bi.getbCount(),bi.getbContent()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据图书id删除图书信息
     * @param bId
     * @return
     */
    public int delBookByBId(int bId) throws SQLException{
        String strSql="delete from bookInfo where bid=?";
        Object[] param={bId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据图书名称删除图书
     * @param bName
     * @return
     */
    public int delBookByBName(String bName) throws SQLException{
        String strSql="delete from bookInfo where bName=?";
        Object[] param={bName};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据图书名称获取图书信息
     * @param bName
     * @return
     */
    public List<BookInfo> getBookByBName(String bName) throws SQLException{
        String strSql="select * from bookInfo where bName=?";
        Object[] param={bName};
        try {
            return this.getEntity(new BookInfo(),param,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据图书id获取图书信息
     * @param bid
     * @return
     */
    public BookInfo getBookByBId(int bid) throws SQLException{
        String strSql="select * from bookInfo where bid=?";
        Object[] param={bid};
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

    /**
     * 更新图书销量和库存
     * @param bi
     * @return
     */
    public int updateBookSales(BookInfo bi) throws SQLException{
        String strSql="update bookInfo set bSales=? where bid = ?";
        Object[] param={bi.getbSales(),bi.getbId()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 更新图书信息
     * @param bi
     * @return
     */
    public int updateBookByBid(BookInfo bi) throws SQLException{
        String strSql="update  bookInfo set bName=?,bType=?,bPress=?,bAuthor=?,bPrice=?,bImg=?,bSales=?,bTime=?,bCount=?,bContent=?";
        Object[] param={bi.getbName(),bi.getbType(),bi.getbPress(),bi.getbAuthor(),bi.getbPrice(),bi.getbImg(),bi.getbSales(),bi.getbTime(),bi.getbCount(),bi.getbContent()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }
}
