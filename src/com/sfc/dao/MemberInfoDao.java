package com.sfc.dao;

import com.sfc.entity.MemberInfo;

public interface MemberInfoDao {
    /**
     * 根据会员id获取会员信息
     * @return
     */
    public MemberInfo getMemberByMId();

    /**
     * 开通会员
     * @param mi
     * @return
     */
    public int insertMember(MemberInfo mi);

    /**
     * 续费
     * @param mi
     * @return
     */
    public int updateMember(MemberInfo mi);

    /**
     * 到期
     * @param mId
     * @return
     */
    public int delMemberByMId(int mId);


}
