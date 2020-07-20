package com.sfc.dao;

import com.sfc.entity.ChatInfo;

import java.util.List;

public interface ChatInfoDao {
    /**
     * 获取聊天信息
     * @param uId
     * @param fId
     * @return
     */
    public List<ChatInfo> getChatInfoByUId(int uId, int fId);

    /**
     * 删除聊天信息
     * @return
     */
    public int delChatInfoByDate();


}
