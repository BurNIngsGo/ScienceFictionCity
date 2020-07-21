package com.sfc.service;

import com.sfc.entity.ManageEva;

import java.sql.SQLException;
import java.util.List;

public interface ManageEvaService {
    /**
     * 根据管理者id获取该管理者操作的评论
     * @param supId
     * @return
     */
    public List<ManageEva> getManageEvaBysupId(int supId) throws SQLException;

    /**
     * 管理了一条评论
     * @param me
     * @return
     */
    public int insertManageEva(ManageEva me) throws SQLException;
}
