package com.sfc.entity;

import com.sfc.dao.EntityClass;

/**
 * 出版社类
 */
public class Press implements EntityClass<Press> {
    private int prId;       //出版社id

    private String prName;  //出版社名称

    public int getPrId() {
        return prId;
    }

    public void setPrId(int prId) {
        this.prId = prId;
    }

    public String getPrName() {
        return prName;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    @Override
    public Press getNew() {
        return new Press();
    }
}
