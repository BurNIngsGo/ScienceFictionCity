package com.sfc.service;

import com.sfc.entity.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface UserInfoService {
    /**
     * 实现用户登录
     * @param uName
     * @param uPwd
     * @return UserInfo
     */
    public UserInfo userLogin(String uName, String uPwd) throws SQLException;

    /**
     *
     * @param ui
     * @return int
     */
    public int userRegist(UserInfo ui) throws SQLException;

    /**
     * 获取所有用户信息
     * @return List<UserInfo>
     */
    public List<UserInfo> getUserAll() throws SQLException;

    /**
     * 更新用户信息
     * @param ui
     * @return int
     */
    public int updateUserByuId(UserInfo ui) throws SQLException;

    /**
     * 用户注册
     * @param ui
     * @return UserInfo
     */
    public int userRegister(UserInfo ui) throws SQLException;

    /**
     * 用户升级
     * @param ui
     * @return
     */
    public int updateUserLv(UserInfo ui) throws SQLException;

    /**
     * 用户会员操作
     * @param ui
     * @return
     */
    public int updateUserMember(UserInfo ui) throws SQLException;

    /**
     * 密码更改操作
     * @param ui
     * @return
     */
    public int updateUserRePassword(UserInfo ui) throws SQLException;
}
