package com.sfc.impl;


import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
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

    /**
     * 实现用户登录
     * @param uName
     * @param uPwd
     * @return UserInfo
     */
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

    /**
     * 获取所有用户信息
     * @return List<UserInfo>
     */
    public List<UserInfo> getUserAll() throws SQLException{
        String strSql = "select * from userInfo";
        try {
            return this.<UserInfo>getEntity(new UserInfo(),null,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 更新用户信息
     * @param ui
     * @return int
     */
    public int updateUserByuId(UserInfo ui) throws SQLException{
        String strSql = "update userinfo set uName = ?,uSex = ?,uEmail = ?,uCard = ?,uPhone = ?,uHeadImg where uId = ?";
        Object[] param = {ui.getuName(),ui.getuSex(),ui.getuEmail(),ui.getuCard(),ui.getuPhone(),ui.getuHeadImg(),ui.getuId()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 用户注册
     * @param ui
     * @return UserInfo
     */
    public int userRegister(UserInfo ui) throws SQLException{
        String strSql = "insert into userinfo(uName,uPwd) values(?,?)";
        Object[] param = {ui.getuName(),ui.getuPwd()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 用户升级
     * @param ui
     * @return
     */
    public int updateUserLv(UserInfo ui) throws SQLException{
        String strSql = "update userinfo set uLv = uLv + 1 where uid = ?";
        Object[] param = {ui.getuId()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 用户会员操作
     * @param ui
     * @return
     */
    public int updateUserMember(UserInfo ui) {
        return 0;
    }

    /**
     * 密码更改操作
     * @param ui
     * @return
     */
    public int updateUserRePassword(UserInfo ui) throws SQLException{
        String strSql = "update userinfo set upwd = ? where uid = ?";
        Object[] param = {ui.getuPwd(),ui.getuId()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 检查是否有该用户名
     * @param name
     * @return
     */
    public int checkUserName(String name) throws SQLException{
        String strSql = "select count(1) form userinfo where name = ?";
        Object[] param = {name};
        try {
            Number num = (Number)this.executeQuery(strSql,param).get(0);
            return num.intValue();
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据用户名查询会员信息
     * @param uname
     * @return
     * @throws SQLException
     */
    public int selectGetUserByName(String uname) throws SQLException {
        String strSql = "select * from userinfo where uName like \"%\"?\"%\"'";
        Object[] param = {uname};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据会员编号删除会员信息
     * @param uid
     * @return
     * @throws SQLException
     */
    public int deleteUserById(int uid) throws SQLException {
        String strSql ="delete from userinfo where uid=?";
        Object[] param = {uid};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }
}
