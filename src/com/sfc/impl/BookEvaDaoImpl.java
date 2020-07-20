package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.BookEvaDao;
import com.sfc.entity.BookEva;

import java.sql.Connection;
import java.util.List;

public class BookEvaDaoImpl extends BaseDao implements BookEvaDao {
    public BookEvaDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<BookEva> getEvaByUId(int uId) {
        return null;
    }

    @Override
    public List<BookEva> getEvaByBId(int bId) {
        return null;
    }

    @Override
    public int insertEva(BookEva be) {
        return 0;
    }

    @Override
    public int delEvaByBId(int bId) {
        return 0;
    }

    @Override
    public int delEvaByUId(int uId) {
        return 0;
    }

    @Override
    public List<BookEva> getEvaPage(int currentPage, int curtotalSize) {
        return null;
    }

    @Override
    public int delEvaByBeId(int BeId) {
        return 0;
    }
}
