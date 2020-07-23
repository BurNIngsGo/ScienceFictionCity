package com.sfc.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sfc.dao.EntityClass;

/**
 * 地址信息类
 */
public class AddressInfo implements EntityClass<AddressInfo> {
    private int aid;            //地址编号

    private String aAddress;    //地址

    private String aPhone;      //联系电话

    private String aCode;       //邮编

    private int aUid;        //用户编号

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getaAddress() {
        return aAddress;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    public String getaCode() {
        return aCode;
    }

    public void setaCode(String aCode) {
        this.aCode = aCode;
    }

    public int getaUid() {
        return aUid;
    }

    public void setaUid(int aUid) {
        this.aUid = aUid;
    }

    @Override
    @JSONField(serialize = false)
    public AddressInfo getNew() {
        return new AddressInfo();
    }
}
