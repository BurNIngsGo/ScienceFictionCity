package com.sfc.serviceImpl;

import com.sfc.entity.ManageEva;
import com.sfc.service.ManageEvaService;

import java.sql.SQLException;
import java.util.List;

public class ManageEvaServiceImpl implements ManageEvaService {
    @Override
    public List<ManageEva> getManageEvaBysupId(int supId) throws SQLException {
        return null;
    }

    @Override
    public int insertManageEva(ManageEva me) throws SQLException {
        return 0;
    }
}
