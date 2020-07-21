package com.sfc.serviceImpl;

import com.sfc.entity.AddressInfo;
import com.sfc.service.AddressInfoService;

import java.sql.SQLException;
import java.util.List;

public class AddressInfoServiceImpl implements AddressInfoService {
    @Override
    public List<AddressInfo> getAddressByUserId(int uid) throws SQLException {
        return null;
    }

    @Override
    public List<AddressInfo> getAllAdddress() throws SQLException {
        return null;
    }

    @Override
    public int delAddressByUid(int uId) throws SQLException {
        return 0;
    }

    @Override
    public int delAddressByAid(int aId) throws SQLException {
        return 0;
    }

    @Override
    public int insertAddress(AddressInfo add) throws SQLException {
        return 0;
    }

    @Override
    public int updateAddressByAid(AddressInfo ui) throws SQLException {
        return 0;
    }

    @Override
    public int updateAddressByAuId(AddressInfo ui) throws SQLException {
        return 0;
    }
}
