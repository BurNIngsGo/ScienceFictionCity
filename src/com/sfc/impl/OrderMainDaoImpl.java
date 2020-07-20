package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.OrderMainDao;
import com.sfc.entity.OrderMain;

import java.sql.Connection;
import java.util.List;

public class OrderMainDaoImpl extends BaseDao implements OrderMainDao {
    public OrderMainDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<OrderMain> getOrderMainByUId() {
        return null;
    }

    @Override
    public int insertOrderMain(OrderMain om) {
        return 0;
    }

    @Override
    public int delOrderMainByOId(int oId) {
        return 0;
    }
}
