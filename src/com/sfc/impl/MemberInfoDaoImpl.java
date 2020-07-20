package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.MemberInfoDao;
import com.sfc.entity.MemberInfo;

import java.sql.Connection;

public class MemberInfoDaoImpl extends BaseDao implements MemberInfoDao {
    public MemberInfoDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public MemberInfo getMemberByMId() {
        return null;
    }

    @Override
    public int insertMember(MemberInfo mi) {
        return 0;
    }

    @Override
    public int updateMember(MemberInfo mi) {
        return 0;
    }

    @Override
    public int delMemberByMId(int mId) {
        return 0;
    }
}
