package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.OrderMainDao;
import com.sfc.entity.OrderMain;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * @Description:订单实现
 * @ClassName :OrderMainDaoImpl
 * @Author: AiGuo
 * @DATE:2020/8/3 19:33
 * @Version:1.0
 */
public class OrderMainDaoImpl extends BaseDao implements OrderMainDao {
    public OrderMainDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 获取用户的订单信息
     * @return
     */
    public List<OrderMain> getOrderMainByUId(int uId) throws SQLException{
        String strSql = "select * from OrderMain where uid = ?";
        Object[] param = {uId};
        try {
            return this.getEntity(new OrderMain(), param, strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 下单时
     * @param om
     * @return
     */
    public int insertOrderMain(OrderMain om) throws SQLException{
        String strSql = "insert into OrderMain(uid,oMoney,aid,oTime,oDone) values(?,?,?,?,?)";
        Object[] param = {om.getUid(),om.getoMoney(),om.getAid(),om.getoTime(),om.getoDone()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据订单编号删除订单
     * @param oId
     * @return
     */
    public int delOrderMainByOId(int oId) throws SQLException{
        String strSql = "delete from orderMain where oid = ?";
        Object[] param = {oId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }
}
