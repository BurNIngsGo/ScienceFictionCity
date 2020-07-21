package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.OrderMainDao;
import com.sfc.dao.PressDao;
import com.sfc.entity.OrderMain;
import com.sfc.impl.OrderMainDaoImpl;
import com.sfc.impl.PressDaoImpl;
import com.sfc.service.OrderMainService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderMainServiceImpl implements OrderMainService {
    /**
     * 获取用户的订单信息
     * @return
     */
    public List<OrderMain> getOrderMainByUId(int uId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        OrderMainDao orderMainDao = new OrderMainDaoImpl(conn);
        try {
            return orderMainDao.getOrderMainByUId(uId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 下单时
     * @param om
     * @return
     */
    public int insertOrderMain(OrderMain om) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        OrderMainDao orderMainDao = new OrderMainDaoImpl(conn);
        try {
            return orderMainDao.insertOrderMain(om);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 根据订单编号删除订单
     * @param oId
     * @return
     */
    public int delOrderMainByOId(int oId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        OrderMainDao orderMainDao = new OrderMainDaoImpl(conn);
        try {
            return orderMainDao.delOrderMainByOId(oId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
