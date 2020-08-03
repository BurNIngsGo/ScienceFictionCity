package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.FriendRelationDao;
import com.sfc.dao.ManageEvaDao;
import com.sfc.entity.Friend;
import com.sfc.entity.FriendRelation;
import com.sfc.impl.FriendRelationDaoImpl;
import com.sfc.impl.ManageEvaDaoImpl;
import com.sfc.service.FriendRelationService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * @Description:好友信息业务逻辑实现
 * @ClassName :FriendRelationServiceImpl
 * @Author: AiGuo
 * @DATE:2020/8/3 19:42
 * @Version:1.0
 */
public class FriendRelationServiceImpl implements FriendRelationService {
    /**
     * 获取好友列表
     * @param uId
     * @return
     */
    public List<FriendRelation> getFriendByUId(int uId) throws SQLException{
        Connection conn =  BaseDaoUtil.getConnection();
        FriendRelationDao friendRelationDao = new FriendRelationDaoImpl(conn);
        try {
            return friendRelationDao.getFriendByUId(uId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 删除好友
     * @param uId
     * @param fId
     * @return
     */
    public int delFriendByUId(int uId, int fId) throws SQLException{
        Connection conn =  BaseDaoUtil.getConnection();
        FriendRelationDao friendRelationDao = new FriendRelationDaoImpl(conn);
        try {
            return friendRelationDao.delFriendByUId(uId,fId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 添加好友
     * @param uId
     * @param fid
     * @return
     */
    public int addFriendByUid(int uId, int fid) throws SQLException{
        Connection conn =  BaseDaoUtil.getConnection();
        FriendRelationDao friendRelationDao = new FriendRelationDaoImpl(conn);
        try {
            return friendRelationDao.addFriendByUid(uId,fid);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 初始化好友列表是否有好友请求
     * @param uId
     * @return
     */
    public int initFriendList(int uId) throws SQLException{
        Connection conn =  BaseDaoUtil.getConnection();
        FriendRelationDao friendRelationDao = new FriendRelationDaoImpl(conn);
        try {
            return friendRelationDao.initFriendList(uId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 获取好友详细列表
     * @param uId
     * @return
     */
    public List<Friend> showFriend(int uId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        FriendRelationDao friendRelationDao = new FriendRelationDaoImpl(conn);
        try {
            return friendRelationDao.showFriend(uId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
