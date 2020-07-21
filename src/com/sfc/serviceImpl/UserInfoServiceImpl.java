package com.sfc.serviceImpl;

import com.sfc.entity.UserInfo;
import com.sfc.service.UserInfoService;

import java.sql.SQLException;
import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public UserInfo userLogin(String uName, String uPwd) throws SQLException {
        return null;
    }

    @Override
    public int userRegist(UserInfo ui) throws SQLException {
        return 0;
    }

    @Override
    public List<UserInfo> getUserAll() throws SQLException {
        return null;
    }

    @Override
    public int updateUserByuId(UserInfo ui) throws SQLException {
        return 0;
    }

    @Override
    public int userRegister(UserInfo ui) throws SQLException {
        return 0;
    }

    @Override
    public int updateUserLv(UserInfo ui) throws SQLException {
        return 0;
    }

    @Override
    public int updateUserMember(UserInfo ui) throws SQLException {
        return 0;
    }

    @Override
    public int updateUserRePassword(UserInfo ui) throws SQLException {
        return 0;
    }
}
