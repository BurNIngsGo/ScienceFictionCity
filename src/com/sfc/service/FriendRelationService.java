package com.sfc.service;

import com.sfc.entity.FriendRelation;

import java.sql.SQLException;
import java.util.List;

public interface FriendRelationService {
    /**
     * 获取好友列表
     * @param uId
     * @return
     */
    public List<FriendRelation> getFriendByUId(int uId) throws SQLException;

    /**
     * 删除好友
     * @param uId
     * @param fId
     * @return
     */
    public int delFriendByUId(int uId, int fId) throws SQLException;

    /**
     * 添加好友
     * @param uId
     * @param fid
     * @return
     */
    public int addFriendByUid(int uId, int fid) throws SQLException;

    /**
     * 初始化好友列表是否有好友请求
     * @param uId
     * @return
     */
    public int initFriendList(int uId) throws SQLException;
}
