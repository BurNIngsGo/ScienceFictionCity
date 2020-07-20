package com.sfc.dao;

import com.sfc.entity.Store;

import java.util.List;

public interface StoreDao {
    /**
     * 根据用户id获取收藏夹
     * @param uId
     * @return
     */
    public List<Store> getStoreByUId(int uId);

    /**
     * 添加到收藏夹
     * @param st
     * @return
     */
    public int insertStore(Store st);

    /**
     * 根据图书id移除图书于收藏夹
     * @param uId
     * @return
     */
    public int delStoreBybId(int uId);



}
