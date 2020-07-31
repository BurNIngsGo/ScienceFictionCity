package com.sfc.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sfc.dao.EntityClass;

import java.util.Date;

public class ShoppingInfo implements EntityClass<ShoppingInfo> {
    private int shId;
    private String bImg;
    private String bName;
    private String shDate;
    private int shCount;
    private double bPrice;
    private  double price;     //单价

    public int getShId() {
        return shId;
    }

    public void setShId(int shId) {
        this.shId = shId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getbImg() {
        return bImg;
    }

    public void setbImg(String bImg) {
        this.bImg = bImg;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getShDate() {
        return shDate;
    }

    public void setShDate(String shDate) {
        this.shDate = shDate;
    }

    public int getShCount() {
        return shCount;
    }

    public void setShCount(int shCount) {
        this.shCount = shCount;
    }

    public double getbPrice() {
        return bPrice;
    }

    public void setbPrice(double bPrice) {
        this.bPrice = bPrice;
    }


    @Override
    @JSONField(serialize = false)
    public ShoppingInfo getNew() {
        return new ShoppingInfo();
    }
}
