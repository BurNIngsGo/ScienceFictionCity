package com.sfc.dao;

import com.sfc.entity.MemberInfo;

import java.sql.SQLException;

public interface MemberInfoDao {
    /**
     * 根据会员id获取会员信息
     * @return
     */
    public MemberInfo getMemberByMId(int mid) throws SQLException;

    /**
     * 开通会员
     * @param mi
     * @return
     */
    public int insertMember(MemberInfo mi) throws SQLException;

    /**
     * 续费
     * @param mi
     * @return
     */
    public int updateMemberByMid(MemberInfo mi) throws SQLException;

    /**
     * 到期
     * @param mId
     * @return
     */
    public int delMemberByMId(int mId) throws SQLException;


}
