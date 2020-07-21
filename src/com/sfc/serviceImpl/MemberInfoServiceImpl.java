package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.MemberInfoDao;
import com.sfc.dao.OrderDetailedDao;
import com.sfc.entity.MemberInfo;
import com.sfc.impl.MemberInfoDaoImpl;
import com.sfc.impl.OrdereDetailedDaoImpl;
import com.sfc.service.MemberInfoService;

import java.sql.Connection;
import java.sql.SQLException;

public class MemberInfoServiceImpl implements MemberInfoService {
    /**
     * 根据会员id获取会员信息
     * @return
     */
    public MemberInfo getMemberByMId(int mid) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        MemberInfoDao memberInfoDao = new MemberInfoDaoImpl(conn);
        try {
            return memberInfoDao.getMemberByMId(mid);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 开通会员
     * @param mi
     * @return
     */
    public int insertMember(MemberInfo mi) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        MemberInfoDao memberInfoDao = new MemberInfoDaoImpl(conn);
        try {
            return memberInfoDao.insertMember(mi);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 续费
     * @param mi
     * @return
     */
    public int updateMemberByMid(MemberInfo mi) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        MemberInfoDao memberInfoDao = new MemberInfoDaoImpl(conn);
        try {
            return memberInfoDao.updateMemberByMid(mi);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 到期
     * @param mId
     * @return
     */
    public int delMemberByMId(int mId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        MemberInfoDao memberInfoDao = new MemberInfoDaoImpl(conn);
        try {
            return memberInfoDao.delMemberByMId(mId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
