package com.sfc.serviceImpl;

import com.sfc.entity.MemberInfo;
import com.sfc.service.MemberInfoService;

import java.sql.SQLException;

public class MemberInfoServiceImpl implements MemberInfoService {
    @Override
    public MemberInfo getMemberByMId(int mid) throws SQLException {
        return null;
    }

    @Override
    public int insertMember(MemberInfo mi) throws SQLException {
        return 0;
    }

    @Override
    public int updateMemberByMid(MemberInfo mi) throws SQLException {
        return 0;
    }

    @Override
    public int delMemberByMId(int mId) throws SQLException {
        return 0;
    }
}
