package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.StoreDao;
import com.sfc.dao.UserInfoDao;
import com.sfc.entity.Store;
import com.sfc.impl.StoreDaoImpl;
import com.sfc.impl.UserInfoDaoImpl;
import com.sfc.service.StoreService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StoreServiceImpl implements StoreService {
    /**
     * 根据用户id获取收藏夹
     * @param uId
     * @return
     */
    public List<Store> getStoreByUId(int uId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        StoreDao storeDao = new StoreDaoImpl(conn);
        try {
            return storeDao.getStoreByUId(uId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 添加到收藏夹
     * @param st
     * @return
     */
    public int insertStore(Store st) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        StoreDao storeDao = new StoreDaoImpl(conn);
        try {
            return storeDao.insertStore(st);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 根据图书id移除图书于收藏夹
     * @param uId
     * @return
     */
    public int delStoreByuId(int uId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        StoreDao storeDao = new StoreDaoImpl(conn);
        try {
            return storeDao.delStoreByuId(uId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
