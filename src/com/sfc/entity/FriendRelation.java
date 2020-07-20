package com.sfc.entity;

import com.sfc.dao.EntityClass;

/**
 * 用户关系类
 */
public class FriendRelation implements EntityClass<FriendRelation> {
    private int uId;    //用户编号

    private int fId;    //好友编号

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    @Override
    public FriendRelation getNew() {
        return new FriendRelation();
    }
}
