package com.sfc.service;

import com.sfc.entity.MemberInfo;

import java.sql.SQLException;
/**
 * @Description:管理员业务逻辑接口
 * @InterfaceName :MemberInfoService
 * @Author: AiGuo
 * @DATE:2020/8/3 19:24
 * @Version:1.0
 */
public interface MemberInfoService {
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
