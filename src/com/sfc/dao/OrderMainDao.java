package com.sfc.dao;

import com.sfc.entity.OrderMain;

import java.sql.SQLException;
import java.util.List;

public interface OrderMainDao {
    /**
     * 获取用户的订单信息
     * @return
     */
    public List<OrderMain> getOrderMainByUId(int uId) throws SQLException;

    /**
     * 下单时
     * @param om
     * @return
     */
    public int insertOrderMain(OrderMain om) throws SQLException;

    /**
     * 根据订单编号删除订单
     * @param oId
     * @return
     */
    public int delOrderMainByOId(int oId) throws SQLException;



}
