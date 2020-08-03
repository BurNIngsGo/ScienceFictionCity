package com.sfc.service;

import com.sfc.entity.Friend;
import com.sfc.entity.FriendRelation;

import java.sql.SQLException;
import java.util.List;
/**
 * @Description:好友信息业务逻辑接口
 * @InterfaceName :FriendRelationService
 * @Author: AiGuo
 * @DATE:2020/8/3 19:22
 * @Version:1.0
 */
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

    public List<Friend> showFriend(int uId) throws SQLException;
}
