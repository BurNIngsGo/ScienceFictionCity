package com.sfc.serviceImpl;

import com.sfc.entity.Store;
import com.sfc.service.StoreService;

import java.sql.SQLException;
import java.util.List;

public class StoreServiceImpl implements StoreService {
    @Override
    public List<Store> getStoreByUId(int uId) throws SQLException {
        return null;
    }

    @Override
    public int insertStore(Store st) throws SQLException {
        return 0;
    }

    @Override
    public int delStoreByuId(int uId) throws SQLException {
        return 0;
    }
}
