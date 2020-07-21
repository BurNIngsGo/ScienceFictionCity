package com.sfc.serviceImpl;

import com.sfc.entity.OrderMain;
import com.sfc.service.OrderMainService;

import java.sql.SQLException;
import java.util.List;

public class OrderMainServiceImpl implements OrderMainService {
    @Override
    public List<OrderMain> getOrderMainByUId(int uId) throws SQLException {
        return null;
    }

    @Override
    public int insertOrderMain(OrderMain om) throws SQLException {
        return 0;
    }

    @Override
    public int delOrderMainByOId(int oId) throws SQLException {
        return 0;
    }
}
