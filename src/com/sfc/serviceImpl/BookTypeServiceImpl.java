package com.sfc.serviceImpl;

import com.sfc.entity.BookInfo;
import com.sfc.entity.BookType;
import com.sfc.service.BookTypeService;

import java.sql.SQLException;
import java.util.List;

public class BookTypeServiceImpl implements BookTypeService {
    @Override
    public List<BookType> getBookTypeAll() throws SQLException {
        return null;
    }

    @Override
    public BookInfo getBookTypeByTId(int tId) throws SQLException {
        return null;
    }

    @Override
    public int delBookTypeByTId(int tId) throws SQLException {
        return 0;
    }

    @Override
    public int delBookTypeByTName(String tId) throws SQLException {
        return 0;
    }

    @Override
    public int insertBookType(BookType bk) throws SQLException {
        return 0;
    }

    @Override
    public int updateBookTypeByTid(BookType bk) throws SQLException {
        return 0;
    }
}
