package com.sfc.entity;

import com.sfc.dao.EntityClass;

import java.awt.print.Book;

/**
 * 图书类型类
 */
public class BookType implements EntityClass<BookType> {
    private int tId;        //类型编号

    private String tName;   //类型名

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Override
    public BookType getNew() {
        return new BookType();
    }
}
