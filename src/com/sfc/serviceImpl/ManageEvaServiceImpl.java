package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.ManageEvaDao;
import com.sfc.dao.MemberInfoDao;
import com.sfc.entity.ManageEva;
import com.sfc.impl.ManageEvaDaoImpl;
import com.sfc.impl.MemberInfoDaoImpl;
import com.sfc.service.ManageEvaService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * @Description:管理评论业务逻辑实现
 * @ClassName :ManageEvaServiceImpl
 * @Author: AiGuo
 * @DATE:2020/8/3 19:43
 * @Version:1.0
 */
public class ManageEvaServiceImpl implements ManageEvaService {
    /**
     * 根据管理者id获取该管理者操作的评论
     * @param supId
     * @return
     */
    public List<ManageEva> getManageEvaBysupId(int supId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        ManageEvaDao manageEvaDao = new ManageEvaDaoImpl(conn);
        try {
            return manageEvaDao.getManageEvaBysupId(supId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 管理了一条评论
     * @param me
     * @return
     */
    public int insertManageEva(ManageEva me) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        ManageEvaDao manageEvaDao = new ManageEvaDaoImpl(conn);
        try {
            return manageEvaDao.insertManageEva(me);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
