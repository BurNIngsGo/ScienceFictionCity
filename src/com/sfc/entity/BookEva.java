package com.sfc.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sfc.dao.EntityClass;

import java.awt.print.Book;

/**
 * 图书评论记录表
 */
public class BookEva implements EntityClass<BookEva> {

    private int beId;       //评论编号

    private int bkStar;     //星级

    @JSONField(serialize = false)
    private String bkEva;   //用户品论内容

    private int uId;        //评论者

    private int bkLuad;     //获赞数

    private int bId;        //图书编号

    public int getBeId() {
        return beId;
    }

    public void setBeId(int beId) {
        this.beId = beId;
    }

    public int getBkStar() {
        return bkStar;
    }

    public void setBkStar(int bkStar) {
        this.bkStar = bkStar;
    }

    public String getBkEva() {
        return bkEva;
    }

    public void setBkEva(String bkEva) {
        this.bkEva = bkEva;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getBkLuad() {
        return bkLuad;
    }

    public void setBkLuad(int bkLuad) {
        this.bkLuad = bkLuad;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }


    @Override
    @JSONField(serialize = false)
    public BookEva getNew() {
        return new BookEva();
    }
}
