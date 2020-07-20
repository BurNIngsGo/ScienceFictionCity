package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.StoreDao;
import com.sfc.entity.Store;

import java.sql.Connection;
import java.util.List;

public class StoreDaoImpl extends BaseDao implements StoreDao {
    public StoreDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<Store> getStoreByUId(int uId) {
        return null;
    }

    @Override
    public int insertStore(Store st) {
        return 0;
    }

    @Override
    public int delStoreBybId(int uId) {
        return 0;
    }
}
