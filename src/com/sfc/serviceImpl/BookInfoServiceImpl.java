package com.sfc.serviceImpl;

import com.sfc.entity.BookInfo;
import com.sfc.service.BookInfoService;

import java.sql.SQLException;
import java.util.List;

public class BookInfoServiceImpl implements BookInfoService {
    @Override
    public List<BookInfo> getBookAll() throws SQLException {
        return null;
    }

    @Override
    public List<BookInfo> getBookByType(int tId) throws SQLException {
        return null;
    }

    @Override
    public List<BookInfo> getBookByPressId(int pId) throws SQLException {
        return null;
    }

    @Override
    public List<BookInfo> getBookPage(int currentPage, int curtotalSize) throws SQLException {
        return null;
    }

    @Override
    public int insertBook(BookInfo bi) throws SQLException {
        return 0;
    }

    @Override
    public int delBookByBId(int bId) throws SQLException {
        return 0;
    }

    @Override
    public int delBookByBName(String bName) throws SQLException {
        return 0;
    }

    @Override
    public List<BookInfo> getBookByBName(String bName) throws SQLException {
        return null;
    }

    @Override
    public BookInfo getBookByBId(int bid) throws SQLException {
        return null;
    }

    @Override
    public int updateBookSales(BookInfo bi) throws SQLException {
        return 0;
    }

    @Override
    public int updateBookByBid(BookInfo bi) throws SQLException {
        return 0;
    }
}
