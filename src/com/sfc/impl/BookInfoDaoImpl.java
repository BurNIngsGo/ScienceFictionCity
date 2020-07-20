package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.BookInfoDao;
import com.sfc.entity.BookInfo;

import java.sql.Connection;
import java.util.List;

public class BookInfoDaoImpl extends BaseDao implements BookInfoDao {
    public BookInfoDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<BookInfo> getBookAll() {
        return null;
    }

    @Override
    public List<BookInfo> getBookByType(int tId) {
        return null;
    }

    @Override
    public List<BookInfo> getBookByPressId(int pId) {
        return null;
    }

    @Override
    public List<BookInfo> getBookPage(int currentPage, int curtotalSize) {
        return null;
    }

    @Override
    public int insertBook(BookInfo bi) {
        return 0;
    }

    @Override
    public int delBookByBId(int bId) {
        return 0;
    }

    @Override
    public int delBookByBName(String bName) {
        return 0;
    }

    @Override
    public List<BookInfo> getBookByBName(String bName) {
        return null;
    }

    @Override
    public BookInfo getBookByBId(String bName) {
        return null;
    }

    @Override
    public int updateBookSales(BookInfo bi) {
        return 0;
    }

    @Override
    public int updateBook(BookInfo bi) {
        return 0;
    }
}
