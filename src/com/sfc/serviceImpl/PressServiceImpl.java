package com.sfc.serviceImpl;

import com.sfc.entity.Press;
import com.sfc.service.PressService;

import java.sql.SQLException;
import java.util.List;

public class PressServiceImpl implements PressService {
    @Override
    public List<Press> getPressAll() throws SQLException {
        return null;
    }

    @Override
    public int insertPress(Press pr) throws SQLException {
        return 0;
    }

    @Override
    public int delPressByOId(int prId) throws SQLException {
        return 0;
    }

    @Override
    public int updatePressByprId(Press pr) throws SQLException {
        return 0;
    }

    @Override
    public Press getPressByPressById(int id) throws SQLException {
        return null;
    }
}
