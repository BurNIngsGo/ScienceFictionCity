package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.PressDao;
import com.sfc.entity.Press;

import java.sql.Connection;
import java.util.List;

public class PressDaoImpl extends BaseDao implements PressDao {
    public PressDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<Press> getPressAll() {
        return null;
    }

    @Override
    public int insertPress(Press pr) {
        return 0;
    }

    @Override
    public int delPressByOId(int oId) {
        return 0;
    }

    @Override
    public int updatePress(Press pr) {
        return 0;
    }

    @Override
    public Press getPressByPressById(int id) {
        return null;
    }
}
