package com.sfc.entity;

import com.sfc.dao.EntityClass;

/**
 * 评论管理记录实体类
 */
public class ManageEva implements EntityClass<ManageEva> {
    private int beId;   //评论id

    private int supId;  //审核者id

    public int getBeId() {
        return beId;
    }

    public void setBeId(int beId) {
        this.beId = beId;
    }

    public int getSupId() {
        return supId;
    }

    public void setSupId(int supId) {
        this.supId = supId;
    }


    @Override
    public ManageEva getNew() {
        return new ManageEva();
    }
}
