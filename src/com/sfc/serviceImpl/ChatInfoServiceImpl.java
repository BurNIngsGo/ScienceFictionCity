package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.ChatInfoDao;
import com.sfc.entity.ChatInfo;
import com.sfc.impl.ChatInfoDaoImpl;
import com.sfc.service.ChatInfoService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ChatInfoServiceImpl implements ChatInfoService {
    /**
     * 获取聊天信息
     * @param uId
     * @param fId
     * @return
     */
    public List<ChatInfo> getChatInfoByUId(int uId, int fId) throws SQLException{
        Connection conn = BaseDaoUtil.getConnection();
        ChatInfoDao bookInfoDao = new ChatInfoDaoImpl(conn);
        try{
            return bookInfoDao.getChatInfoByUId(uId,fId);
        } catch(SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 删除聊天信息
     * @param date
     * @return
     * @throws SQLException
     */
    public int delChatInfoByDate(Date date) throws SQLException{
        Connection conn = BaseDaoUtil.getConnection();
        ChatInfoDao bookInfoDao = new ChatInfoDaoImpl(conn);
        try{
            return bookInfoDao.delChatInfoByDate(date);
        } catch(SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
