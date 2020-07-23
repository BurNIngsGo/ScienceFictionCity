package com.sfc.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sfc.dao.EntityClass;

import java.util.Date;

public class ChatInfo implements EntityClass<ChatInfo> {
    private int uId;            //用户编号

    private int fId;            //好友编号

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;          //时间

    private String cContent;    //聊天内容

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

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    @Override
    @JSONField(serialize = false)
    public ChatInfo getNew() {
        return new ChatInfo();
    }
}
