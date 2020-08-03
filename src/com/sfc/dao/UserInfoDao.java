package com.sfc.dao;

import com.sfc.entity.UserInfo;

import java.sql.SQLException;
import java.util.List;
/**
 * @Description:用户信息接口
 * @InterfaceName :UserInfoDao
 * @Author: AiGuo
 * @DATE:2020/8/3 18:12
 * @Version:1.0
 */
public interface UserInfoDao {
    /**
     * 实现用户登录
     * @param uName
     * @param uPwd
     * @return UserInfo
     */
    public UserInfo userLogin(String uName, String uPwd) throws SQLException;


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

    /**
     * 检查是否有该用户名
     * @param name
     * @return
     */
    public int checkUserName(String name) throws SQLException;

    /**
     * 根据用户名查询会员信息
     * @param uname
     * @return
     * @throws SQLException
     */
    public List<UserInfo> selectGetUserByName(String uname) throws SQLException;

    /**
     * 根据会员编号删除会员信息
     * @param uid
     * @return
     * @throws SQLException
     */
    public int deleteUserById (int uid) throws SQLException;

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    public List<UserInfo> getUserById(int id) throws SQLException;
}
