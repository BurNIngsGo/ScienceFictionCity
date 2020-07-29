package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.PressDao;
import com.sfc.dao.ShoppingCartDao;
import com.sfc.entity.Press;
import com.sfc.impl.PressDaoImpl;
import com.sfc.impl.ShoppingCartDaoImpl;
import com.sfc.service.PressService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PressServiceImpl implements PressService {
    /**
     * 获取所有出版社信息
     * @return
     */
    public List<Press> getPressAll() throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        PressDao pressDao = new PressDaoImpl(conn);
        try {
            return pressDao.getPressAll();
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 添加一条出版社信息
     * @param pr
     * @return
     */
    public int insertPress(Press pr) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        PressDao pressDao = new PressDaoImpl(conn);
        try {
            return pressDao.insertPress(pr);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     *  删除出版社信息
     * @param prId
     * @return
     */
    public int delPressByOId(int prId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        PressDao pressDao = new PressDaoImpl(conn);
        try {
            return pressDao.delPressByOId(prId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 更新出版社信息
     * @param pr
     * @return
     */
    public int updatePressByprId(Press pr) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        PressDao pressDao = new PressDaoImpl(conn);
        try {
            return pressDao.updatePressByprId(pr);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 根据出版社id获取出版社信息
     * @param id
     * @return
     */
    public Press getPressByPressById(int id) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        PressDao pressDao = new PressDaoImpl(conn);
        try {
            return pressDao.getPressByPressById(id);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    @Override
    public int getPressIdByPressName(String pName) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        PressDao pressDao = new PressDaoImpl(conn);
        try {
            return pressDao.getPressIdByPressName(pName);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    @Override
    public List<Press> getAllByPrName(String pName) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        PressDao pressDao = new PressDaoImpl(conn);
        try {
            return pressDao.getAllByPrName(pName);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
