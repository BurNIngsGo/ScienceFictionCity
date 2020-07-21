package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.OrderDetailedDao;
import com.sfc.dao.OrderMainDao;
import com.sfc.entity.OrderDetailed;
import com.sfc.impl.OrderMainDaoImpl;
import com.sfc.impl.OrdereDetailedDaoImpl;
import com.sfc.service.OrdereDetailedService;

import java.sql.Connection;
import java.sql.SQLException;

public class OrdereDetailedServiceImpl implements OrdereDetailedService {
    /**
     * 根据订单编号获取订单信息
     * @param orderNo
     * @return
     */
    public OrderDetailed getOrderDetailedByOrderNo(String orderNo) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        OrderDetailedDao orderDetailedDao = new OrdereDetailedDaoImpl(conn);
        try {
            return orderDetailedDao.getOrderDetailedByOrderNo(orderNo);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 添加一条订单
     * @param od
     * @return
     */
    public int insertOrderDetailed(OrderDetailed od) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        OrderDetailedDao orderDetailedDao = new OrdereDetailedDaoImpl(conn);
        try {
            return orderDetailedDao.insertOrderDetailed(od);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 删除或取消订单
     * @param id
     * @return
     */
    public int delOrderDetailed(int id) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        OrderDetailedDao orderDetailedDao = new OrdereDetailedDaoImpl(conn);
        try {
            return orderDetailedDao.delOrderDetailed(id);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
