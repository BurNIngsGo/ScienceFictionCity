package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.FriendRelationDao;
import com.sfc.entity.ChatInfo;
import com.sfc.entity.FriendRelation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FriendRelationDaoImpl extends BaseDao implements FriendRelationDao {

    public FriendRelationDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 获取好友列表
     * @param uId
     * @return
     */
    public List<FriendRelation> getFriendByUId(int uId) throws SQLException{
        String strSql="select * from friendRelation uid=?";
        Object[] param = {uId};
        try {
            return this.getEntity(new FriendRelation(), param, strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 删除好友
     * @param uId
     * @param fId
     * @return
     */
    public int delFriendByUId(int uId, int fId) throws SQLException{
        String strSql = "delete  from friendRelation where uid=? and fid = ?";
        Object[] param = {uId, fId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 添加好友
     * @param uId
     * @param fid
     * @return
     */
    public int addFriendByUid(int uId, int fid) throws SQLException{
        String strSql = "insert  friendRelation values (?,?)";
        Object[] param = {uId,fid};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int initFriendList(int uId) {
        return 0;
    }
}
