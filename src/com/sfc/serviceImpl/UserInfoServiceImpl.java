package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.AddressInfoDao;
import com.sfc.dao.UserInfoDao;
import com.sfc.entity.UserInfo;
import com.sfc.impl.AddressInfoDaoImpl;
import com.sfc.impl.UserInfoDaoImpl;
import com.sfc.service.UserInfoService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {
    /**
     * 实现用户登录
     * @param uName
     * @param uPwd
     * @return UserInfo
     */
    public UserInfo userLogin(String uName, String uPwd) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        UserInfoDao userInfoDao = new UserInfoDaoImpl(conn);
        try {
            return userInfoDao.userLogin(uName,uPwd);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
    /**
     * 获取所有用户信息
     * @return List<UserInfo>
     */
    public List<UserInfo> getUserAll() throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        UserInfoDao userInfoDao = new UserInfoDaoImpl(conn);
        try {
            return userInfoDao.getUserAll();
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 更新用户信息
     * @param ui
     * @return int
     */
    public int updateUserByuId(UserInfo ui) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        UserInfoDao userInfoDao = new UserInfoDaoImpl(conn);
        try {
            return userInfoDao.updateUserByuId(ui);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 用户注册
     * @param ui
     * @return UserInfo
     */
    public int userRegister(UserInfo ui) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        UserInfoDao userInfoDao = new UserInfoDaoImpl(conn);
        try {
            return userInfoDao.userRegister(ui);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 用户升级
     * @param ui
     * @return
     */
    public int updateUserLv(UserInfo ui) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        UserInfoDao userInfoDao = new UserInfoDaoImpl(conn);
        try {
            return userInfoDao.updateUserLv(ui);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 用户会员操作
     * @param ui
     * @return
     */
    public int updateUserMember(UserInfo ui) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        UserInfoDao userInfoDao = new UserInfoDaoImpl(conn);
        try {
            return userInfoDao.updateUserMember(ui);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 密码更改操作
     * @param ui
     * @return
     */
    public int updateUserRePassword(UserInfo ui) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        UserInfoDao userInfoDao = new UserInfoDaoImpl(conn);
        try {
            return userInfoDao.updateUserRePassword(ui);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
