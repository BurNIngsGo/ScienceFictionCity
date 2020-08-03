package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.MemberInfoDao;
import com.sfc.entity.MemberInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * @Description:管理员实现类
 * @ClassName :MemberInfoDaoImpl
 * @Author: AiGuo
 * @DATE:2020/8/3 19:32
 * @Version:1.0
 */
public class MemberInfoDaoImpl extends BaseDao implements MemberInfoDao {
    public MemberInfoDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 根据会员id获取会员信息
     * @return
     */
    public MemberInfo getMemberByMId(int mid) throws SQLException{
        String strSql = "select * from memberinfo where mid = ?";
        Object[] param = {mid};
        List<MemberInfo> list = null;
        try {
            list = this.getEntity(new MemberInfo(), param, strSql);
            if(list.size() > 0) {
                return list.get(0);
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 开通会员
     * @param mi
     * @return
     */
    public int insertMember(MemberInfo mi) throws SQLException{
        String strSql = "insert into memberinfo(mDate,mEdDate) values(?,?)";
        Object[] param = {mi.getmDate(),mi.getmEDate()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 续费
     * @param mi
     * @return
     */
    public int updateMemberByMid(MemberInfo mi) throws SQLException{
        String strSql = "update memberInfo set mEdDate = ? where mid = ?";
        Object[] param = {mi.getmDate(),mi.getmEDate()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 到期
     * @param mId
     * @return
     */
    public int delMemberByMId(int mId) throws SQLException{
        String strSql = "delete memberInfo where mid = ?";
        Object[] param = {mId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }
}
