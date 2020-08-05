package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.ChatInfoDao;
import com.sfc.entity.ChatInfo;
import com.sfc.entity.ManageEva;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
/**
 * @Description:聊天信息实现
 * @ClassName :ChatInfoDaoImpl
 * @Author: AiGuo
 * @DATE:2020/8/3 19:29
 * @Version:1.0
 */
public class ChatInfoDaoImpl extends BaseDao implements ChatInfoDao {
    public ChatInfoDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 获取聊天信息
     * @param uId
     * @param fId
     * @return
     */
    public List<ChatInfo> getChatInfoByUId(int uId, int fId) throws SQLException {
        String strSql = "select * from chatInfo where uid=? and fid = ?";//根据图书的用户id跟好友id获取聊天信息
        Object[] param = {uId, fId};//创建存储参数的数组
        try {
            return this.getEntity(new ChatInfo(), param, strSql);//返回执行更新方法的返回值
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
        String strSql = "delete from chatInfo where date=?";//根据时间删除聊天信息
        Object[] param = {date};//创建存储参数的数组
        try {
            return this.executeUpdate(strSql, param);//返回执行更新方法的返回值
        } catch (SQLException e) {
            throw e;
        }
    }
}
