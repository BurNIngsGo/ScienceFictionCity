package com.sfc.service;

import com.sfc.entity.ChatInfo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ChatInfoService {
    /**
     * 获取聊天信息
     * @param uId
     * @param fId
     * @return
     */
    public List<ChatInfo> getChatInfoByUId(int uId, int fId) throws SQLException;

    /**
     * 删除聊天信息
     * @param date
     * @return
     * @throws SQLException
     */
    public int delChatInfoByDate(Date date) throws SQLException;
}
