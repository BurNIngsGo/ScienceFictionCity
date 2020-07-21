package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.OrderDetailedDao;
import com.sfc.entity.OrderDetailed;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrdereDetailedDaoImpl extends BaseDao implements OrderDetailedDao {
    public OrdereDetailedDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 根据订单编号获取订单信息
     * @param orderNo
     * @return
     */
    public OrderDetailed getOrderDetailedByOrderNo(String orderNo) throws SQLException{
        String strSql = "select * from OrderDetailed where oid = ?";
        Object[] param = {orderNo};
        List<OrderDetailed> list = null;
        try {
            list = this.getEntity(new OrderDetailed(), param, strSql);
            if(list.size() > 0) {
                return list.get(0);
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 添加一条订单
     * @param od
     * @return
     */
    public int insertOrderDetailed(OrderDetailed od) throws SQLException{
        String strSql = "insert into OrderDetailed(orderNo,oCount,bid,oPrice,oBookName) values(?,?,?,?,?)";
        Object[] param = {od.getoRderNo(),od.getoCount(),od.getbId(),od.getoPrice(),od.getoBookName()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 删除或取消订单
     * @param id
     * @return
     */
    public int delOrderDetailed(int id) throws SQLException{
        String strSql = "delete from OrderDetailed where oid = ?";
        Object[] param = {id};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }
}
