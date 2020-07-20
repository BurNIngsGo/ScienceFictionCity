package com.sfc.entity;

import com.sfc.dao.EntityClass;

import java.util.Date;

/**
 * 图书信息类
 */
public class BookInfo implements EntityClass<BookInfo> {
    private int bId;            //图书编号

    private String bName;       //图书名

    private int bType;          //图书类型

    private int bPress;         //出版社

    private String bAuthor;     //作者

    private double bPrice;      //价格

    private String bPresent;    //图书介绍

    private String bImg;        //图书图片

    private int bSales;         //图书销量

    private Date bTime;         //出版时间

    private int bCount;         //库存

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent;
    }

    private String bContent;    //图书内容

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public int getbType() {
        return bType;
    }

    public void setbType(int bType) {
        this.bType = bType;
    }

    public int getbPress() {
        return bPress;
    }

    public void setbPress(int bPress) {
        this.bPress = bPress;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public double getbPrice() {
        return bPrice;
    }

    public void setbPrice(double bPrice) {
        this.bPrice = bPrice;
    }

    public String getbPresent() {
        return bPresent;
    }

    public void setbPresent(String bPresent) {
        this.bPresent = bPresent;
    }

    public String getbImg() {
        return bImg;
    }

    public void setbImg(String bImg) {
        this.bImg = bImg;
    }

    public int getbSales() {
        return bSales;
    }

    public void setbSales(int bSales) {
        this.bSales = bSales;
    }

    public Date getbTime() {
        return bTime;
    }

    public void setbTime(Date bTime) {
        this.bTime = bTime;
    }

    public int getbCount() {
        return bCount;
    }

    public void setbCount(int bCount) {
        this.bCount = bCount;
    }

    @Override
    public BookInfo getNew() {
        return new BookInfo();
    }
}
