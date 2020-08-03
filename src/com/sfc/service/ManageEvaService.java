package com.sfc.service;

import com.sfc.entity.ManageEva;

import java.sql.SQLException;
import java.util.List;
/**
 * @Description:管理图书评论业务逻辑接口
 * @InterfaceName :ManageEvaService
 * @Author: AiGuo
 * @DATE:2020/8/3 19:24
 * @Version:1.0
 */
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
