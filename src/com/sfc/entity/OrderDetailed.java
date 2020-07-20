package com.sfc.entity;

import com.sfc.dao.EntityClass;

/**
 * 详细订单
 */
public class OrderDetailed implements EntityClass<OrderDetailed> {
    private int oid;            //详细订单编号

    private String oRderNo;     //订单号

    private int oCount;         //商品数量

    private int bId;            //图书编号

    private double oPrice;      //图书单价

    private String oBookName;   //商品名称

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getoRderNo() {
        return oRderNo;
    }

    public void setoRderNo(String oRderNo) {
        this.oRderNo = oRderNo;
    }

    public int getoCount() {
        return oCount;
    }

    public void setoCount(int oCount) {
        this.oCount = oCount;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public double getoPrice() {
        return oPrice;
    }

    public void setoPrice(double oPrice) {
        this.oPrice = oPrice;
    }

    public String getoBookName() {
        return oBookName;
    }

    public void setoBookName(String oBookName) {
        this.oBookName = oBookName;
    }

    @Override
    public OrderDetailed getNew() {
        return new OrderDetailed();
    }
}
