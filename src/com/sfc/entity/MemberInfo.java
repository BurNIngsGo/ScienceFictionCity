package com.sfc.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sfc.dao.EntityClass;

import java.util.Date;

/**
 * 会员记录实体类
 */
public class MemberInfo implements EntityClass<MemberInfo> {
    private int mid;    //会员编号

    private Date mDate; //开通时间

    private Date mEDate;//到期时间

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public Date getmEDate() {
        return mEDate;
    }

    public void setmEDate(Date mEDate) {
        this.mEDate = mEDate;
    }

    @Override
    @JSONField(serialize = false)
    public MemberInfo getNew() {
        return new MemberInfo();
    }
}
