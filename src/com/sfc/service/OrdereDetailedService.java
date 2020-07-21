package com.sfc.service;

import com.sfc.entity.OrderDetailed;

import java.sql.SQLException;

public interface OrdereDetailedService {
    /**
     * 根据订单编号获取订单信息
     * @param orderNo
     * @return
     */
    public OrderDetailed getOrderDetailedByOrderNo(String orderNo) throws SQLException;

    /**
     * 添加一条订单
     * @param od
     * @return
     */
    public int insertOrderDetailed(OrderDetailed od) throws SQLException;

    /**
     * 删除或取消订单
     * @param id
     * @return
     */
    public int delOrderDetailed(int id) throws SQLException;
}
