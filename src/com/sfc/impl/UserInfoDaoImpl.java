package com.sfc.impl;


import com.sfc.dao.BaseDao;
import com.sfc.dao.UserInfoDao;
import com.sfc.entity.UserInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {
    public UserInfoDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public UserInfo userLogin(String uName, String uPwd) throws SQLException{
        String strSql = "select * from userinfo where uName = ? and uPwd = ?";
        Object[] param = {uName, uPwd};
        List<UserInfo> list = null;
        try {
            list = this.<UserInfo>getEntity(new UserInfo(), param, strSql);
            if(list.size() > 0)
                return list.get(0);
            else
                return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int userRegist(UserInfo ui) throws SQLException{
        String strSql = "insert into userinfo(uName,uPwd,uSex) values(?,?,?)";
        Object[] param = {ui.getuName(),ui.getuPwd(),ui.getuSex()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<UserInfo> getUserAll() throws SQLException{
        String strSql = "select * from userInfo";
        try {
            return this.<UserInfo>getEntity(new UserInfo(),null,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int updateUser(UserInfo ui) {
        return 0;
    }

    @Override
    public UserInfo userRegister(int uId) {
        return null;
    }

    @Override
    public int updateUserLv(UserInfo ui) {
        return 0;
    }

    @Override
    public int updateUserMember(UserInfo ui) {
        return 0;
    }

    @Override
    public int updateUserRePassword(UserInfo ui) {
        return 0;
    }
}
