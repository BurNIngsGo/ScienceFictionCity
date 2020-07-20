package com.sfc.dao;

import com.sfc.entity.FriendRelation;

import java.util.List;

public interface FriendRelationDao {
    /**
     * 获取好友列表
     * @param uId
     * @return
     */
    public List<FriendRelation> getFriendByUId(int uId);

    /**
     * 删除好友
     * @param uId
     * @param fId
     * @return
     */
    public int delFriendByUId(int uId, int fId);

    /**
     * 添加好友
     * @param uId
     * @param fid
     * @return
     */
    public int addFriendByUid(int uId, int fid);

    /**
     * 初始化好友列表是否有好友请求
     * @param uId
     * @return
     */
    public int initFriendList(int uId);

}
