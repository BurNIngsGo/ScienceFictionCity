package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.ManageEvaDao;
import com.sfc.entity.ManageEva;

import java.sql.Connection;
import java.util.List;

public class ManageEvaDaoImpl extends BaseDao implements ManageEvaDao {
    public ManageEvaDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<ManageEva> getManageEvaBysupId(int supId) {
        return null;
    }

    @Override
    public int insertManageEva(ManageEva me) {
        return 0;
    }
}
