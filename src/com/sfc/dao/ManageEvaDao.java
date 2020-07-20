package com.sfc.dao;

import com.sfc.entity.ManageEva;

import java.util.List;

public interface ManageEvaDao {
    /**
     * 根据管理者id获取该管理者操作的评论
     * @param supId
     * @return
     */
    public List<ManageEva> getManageEvaBysupId(int supId);

    /**
     * 管理了一条评论
     * @param me
     * @return
     */
    public int insertManageEva(ManageEva me);


}
