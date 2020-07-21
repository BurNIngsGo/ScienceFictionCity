package com.sfc.serviceImpl;

import com.sfc.entity.FriendRelation;
import com.sfc.service.FriendRelationService;

import java.util.List;

public class FriendRelationServiceImpl implements FriendRelationService {
    @Override
    public List<FriendRelation> getFriendByUId(int uId) {
        return null;
    }

    @Override
    public int delFriendByUId(int uId, int fId) {
        return 0;
    }

    @Override
    public int addFriendByUid(int uId, int fid) {
        return 0;
    }

    @Override
    public int initFriendList(int uId) {
        return 0;
    }
}
