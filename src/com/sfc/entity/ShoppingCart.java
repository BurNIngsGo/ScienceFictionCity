package com.sfc.entity;

import com.sfc.dao.EntityClass;

import java.util.Date;

/**
 * 购物车类
 */
public class ShoppingCart implements EntityClass<ShoppingCart> {
    private int shId;       //购物车id

    private int bId;        //图书编号

    private Date shDate;    //加入日期

    private int uId;        //用户编号

    private int shCount;    //图书商品数量

    public int getShId() {
        return shId;
    }

    public void setShId(int shId) {
        this.shId = shId;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public Date getShDate() {
        return shDate;
    }

    public void setShDate(Date shDate) {
        this.shDate = shDate;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getShCount() {
        return shCount;
    }

    public void setShCount(int shCount) {
        this.shCount = shCount;
    }

    @Override
    public ShoppingCart getNew() {
        return new ShoppingCart();
    }
}
