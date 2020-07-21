package com.sfc.dao;

import com.sfc.entity.Store;

import java.sql.SQLException;
import java.util.List;

public interface StoreDao {
    /**
     * 根据用户id获取收藏夹
     * @param uId
     * @return
     */
    public List<Store> getStoreByUId(int uId) throws SQLException;

    /**
     * 添加到收藏夹
     * @param st
     * @return
     */
    public int insertStore(Store st) throws SQLException;

    /**
     * 根据图书id移除图书于收藏夹
     * @param uId
     * @return
     */
    public int delStoreByuId(int uId) throws SQLException;



}
