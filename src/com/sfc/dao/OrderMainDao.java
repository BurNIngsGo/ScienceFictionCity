package com.sfc.dao;

import com.sfc.entity.OrderMain;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:订单主要信息
 * @InterfaceName :OrderMainDao
 * @Author: AiGuo
 * @DATE:2020/8/3 18:08
 * @Version:1.0
 */
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
