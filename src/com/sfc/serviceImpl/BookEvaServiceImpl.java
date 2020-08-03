package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.BookEvaDao;
import com.sfc.entity.BookEva;
import com.sfc.impl.BookEvaDaoImpl;
import com.sfc.service.BookEvaService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * @Description:用户评论业务逻辑实现
 * @ClassName :BookEvaServiceImpl
 * @Author: AiGuo
 * @DATE:2020/8/3 19:40
 * @Version:1.0
 */
public class BookEvaServiceImpl implements BookEvaService {
    /**
     * 根据用户id获取评论信息
     * @param uId
     * @return
     */
    public List<BookEva> getEvaByUId(int uId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        BookEvaDao bookEvDao = new BookEvaDaoImpl(conn);
        try {
            return bookEvDao.getEvaByUId(uId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 根据图书id获取评论信息
     * @param bId
     * @return
     */
    public List<BookEva> getEvaByBId(int bId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        BookEvaDao bookEvDao = new BookEvaDaoImpl(conn);
        try {
            return bookEvDao.getEvaByBId(bId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 用户评论了一条信息(添加一条评论)
     * @param be
     * @return
     */
    public int insertEva(BookEva be) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        BookEvaDao bookEvDao = new BookEvaDaoImpl(conn);
        try {
            return bookEvDao.insertEva(be);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 根据图书id删除评论(删除该数所有评论)
     * @param bId
     * @return
     */
    public int delEvaByBId(int bId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        BookEvaDao bookEvDao = new BookEvaDaoImpl(conn);
        try {
            return bookEvDao.delEvaByBId(bId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 删除用户评论过的信息
     * @param uId
     * @return
     */
    public int delEvaByUId(int uId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        BookEvaDao bookEvDao = new BookEvaDaoImpl(conn);
        try {
            return bookEvDao.delEvaByUId(uId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 对评论分页
     * @param currentPage
     * @param curtotalSize
     * @return
     */
    public List<BookEva> getEvaPage(int currentPage, int curtotalSize) throws SQLException {
        return null;
    }

    /**
     * 删除对应评论编号的信息
     * @param beId
     * @return
     */
    public int delEvaByBeId(int beId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        BookEvaDao bookEvDao = new BookEvaDaoImpl(conn);
        try {
            return bookEvDao.delEvaByBeId(beId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
