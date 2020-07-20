package com.sfc.entity;

import com.sfc.dao.EntityClass;

import java.util.Date;

/**
 * 收藏类
 */
public class Store implements EntityClass<Store> {
    private int sId;        //收藏编号

    private int bId;        //图书编号

    private Date sDate;     //收藏日期

    private int uId;        //收藏者

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Override
    public Store getNew() {
        return new Store();
    }
}
