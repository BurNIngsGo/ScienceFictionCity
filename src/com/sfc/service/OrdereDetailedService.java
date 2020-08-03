package com.sfc.service;

import com.sfc.entity.OrderDetailed;

import java.sql.SQLException;
/**
 * @Description:订单详情业务逻辑接口
 * @InterfaceName :OrdereDetailedService
 * @Author: AiGuo
 * @DATE:2020/8/3 19:25
 * @Version:1.0
 */
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
