package com.sfc.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sfc.dao.EntityClass;

public class Friend implements EntityClass<Friend> {
    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String headImg;
    private String userName;

    @Override
    @JSONField(serialize = false)
    public Friend getNew() {
        return new Friend();
    }
}
