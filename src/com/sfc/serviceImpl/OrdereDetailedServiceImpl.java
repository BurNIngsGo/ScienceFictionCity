package com.sfc.serviceImpl;

import com.sfc.entity.OrderDetailed;
import com.sfc.service.OrdereDetailedService;

import java.sql.SQLException;

public class OrdereDetailedServiceImpl implements OrdereDetailedService {
    @Override
    public OrderDetailed getOrderDetailedByOrderNo(String orderNo) throws SQLException {
        return null;
    }

    @Override
    public int insertOrderDetailed(OrderDetailed od) throws SQLException {
        return 0;
    }

    @Override
    public int delOrderDetailed(int id) throws SQLException {
        return 0;
    }
}
