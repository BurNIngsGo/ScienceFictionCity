package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.BookTypeDao;
import com.sfc.entity.BookInfo;
import com.sfc.entity.BookType;

import java.sql.Connection;
import java.util.List;

public class BookTypeDaoImpl extends BaseDao implements BookTypeDao{
    public BookTypeDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<BookType> getBookTypeAll() {
        return null;
    }

    @Override
    public BookInfo getBookTypeByTId(int tId) {
        return null;
    }

    @Override
    public int delBookTypeByTId(int tId) {
        return 0;
    }

    @Override
    public int delBookTypeByTName(String tId) {
        return 0;
    }

    @Override
    public int insertBookType(BookType bk) {
        return 0;
    }

    @Override
    public int updateBookType(BookType bk) {
        return 0;
    }
}
