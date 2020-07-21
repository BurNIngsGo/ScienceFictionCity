package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.ChatInfoDao;
import com.sfc.entity.ChatInfo;
import com.sfc.entity.ManageEva;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ChatInfoDaoImpl extends BaseDao implements ChatInfoDao {
    public ChatInfoDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 获取聊天信息
     *
     * @param uId
     * @param fId
     * @return
     */
    public List<ChatInfo> getChatInfoByUId(int uId, int fId) throws SQLException {
        String strSql = "select * from chatInfo where uid=? and fid = ?";
        Object[] param = {uId, fId};
        try {
            return this.getEntity(new ChatInfo(), param, strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 删除聊天信息
     *
     * @param date
     * @return
     * @throws SQLException
     */
    public int delChatInfoByDate(Date date) throws SQLException {
        String strSql = "delete from chatInfo where date=?";
        Object[] param = {date};
        try {
            return this.executeUpdate(strSql, param);
        } catch (SQLException e) {
            throw e;
        }
    }
}
