package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.ManageEvaDao;
import com.sfc.entity.ManageEva;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * @Description:管理评论实现类
 * @ClassName :ManageEvaDaoImpl
 * @Author: AiGuo
 * @DATE:2020/8/3 19:31
 * @Version:1.0
 */
public class ManageEvaDaoImpl extends BaseDao implements ManageEvaDao {
    public ManageEvaDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 根据管理者id获取该管理者操作的评论
     * @param supId
     * @return
     */
    public List<ManageEva> getManageEvaBysupId(int supId) throws SQLException{
        String strSql = "select * from ManageEva where supId = ?";
        Object[] param = {supId};
        try {
            return this.getEntity(new ManageEva(), param, strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 管理了一条评论
     * @param me
     * @return
     */
    public int insertManageEva(ManageEva me) throws SQLException{
        String strSql = "insert into manageEva values(?,?)";
        Object[] param = {me.getBeId(),me.getSupId()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }
}
