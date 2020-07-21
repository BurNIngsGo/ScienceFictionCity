package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.BookEvaDao;
import com.sfc.entity.BookEva;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookEvaDaoImpl extends BaseDao implements BookEvaDao {
    public BookEvaDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 根据用户id获取评论信息
     * @param uId
     * @return
     */
    public List<BookEva> getEvaByUId(int uId) throws SQLException{
        String strSql ="select * from bookEva where uid=?";
        Object[] param ={uId};
        try {
            return this.getEntity(new BookEva(),param,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据图书id获取评论信息
     * @param bId
     * @return
     */
    public List<BookEva> getEvaByBId(int bId) throws SQLException {
        String strSql ="select * from bookEva where bid=?";
        Object[] param ={bId};
        try {
            return this.getEntity(new BookEva(),param,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 用户评论了一条信息(添加一条评论)
     * @param be
     * @return
     */
    public int insertEva(BookEva be) throws SQLException{
        String strSql ="insert bookEva(bkStar,bkEva,uid,bkLaud,bid) values(?,?,?,?,?)";
        Object[] param={be.getBkStar(),be.getBkEva(),be.getuId(),be.getBkLuad(),be.getbId()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据图书id删除评论(删除该数所有评论)
     * @param bId
     * @return
     */
    public int delEvaByBId(int bId) throws SQLException{
        String strSql="delete from bookEva where bid=?";
        Object[] param={bId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 删除用户评论过的信息
     * @param uId
     * @return
     */
    public int delEvaByUId(int uId) throws SQLException{
        String strSql="delete from bookEva where uid=?";
        Object[] param={uId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<BookEva> getEvaPage(int currentPage, int curTotalSize) {
        return null;
    }

    /**
     * 删除对应评论编号的信息
     * @param beId
     * @return
     */
    public int delEvaByBeId(int beId) throws SQLException{
        String strSql="delete from bookEva where beId=?";
        Object[] param={beId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }
}
