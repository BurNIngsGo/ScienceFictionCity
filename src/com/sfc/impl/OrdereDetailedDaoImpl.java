package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.OrderDetailedDao;
import com.sfc.entity.OrderDetailed;

import java.sql.Connection;

public class OrdereDetailedDaoImpl extends BaseDao implements OrderDetailedDao {
    public OrdereDetailedDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public OrderDetailed getOrderDetailedByOrderNo(String orderNo) {
        return null;
    }

    @Override
    public int insertOrderDetailed(OrderDetailed od) {
        return 0;
    }

    @Override
    public int delOrderDetailed(int id) {
        return 0;
    }
}
