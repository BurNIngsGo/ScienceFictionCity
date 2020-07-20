package com.sfc.dao;

import com.sfc.entity.OrderMain;

import java.util.List;

public interface OrderMainDao {
    /**
     * 获取用户的订单信息
     * @return
     */
    public List<OrderMain> getOrderMainByUId();

    /**
     * 下单时
     * @param om
     * @return
     */
    public int insertOrderMain(OrderMain om);

    /**
     * 根据订单编号删除订单
     * @param oId
     * @return
     */
    public int delOrderMainByOId(int oId);



}
