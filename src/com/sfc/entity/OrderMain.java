package com.sfc.entity;

import com.sfc.dao.EntityClass;

import java.util.Date;

/**
 * 主订单实体类
 */
public class OrderMain implements EntityClass<OrderMain> {
    private int uid;        //用户id

    private int oid;        //订单编号

    private double oMoney;  //总金额

    private int aid;        //地址id

    private Date oTime;     //下单时间

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public double getoMoney() {
        return oMoney;
    }

    public void setoMoney(double oMoney) {
        this.oMoney = oMoney;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Date getoTime() {
        return oTime;
    }

    public void setoTime(Date oTime) {
        this.oTime = oTime;
    }

    public int getoDone() {
        return oDone;
    }

    public void setoDone(int oDone) {
        this.oDone = oDone;
    }

    private int oDone;      //订单状态

    @Override
    public OrderMain getNew() {
        return new OrderMain();
    }
}
