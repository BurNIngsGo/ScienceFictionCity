package com.sfc.serviceImpl;

import com.sfc.entity.BookEva;
import com.sfc.service.BookEvaService;

import java.sql.SQLException;
import java.util.List;

public class BookEvaServiceImpl implements BookEvaService {
    @Override
    public List<BookEva> getEvaByUId(int uId) throws SQLException {
        return null;
    }

    @Override
    public List<BookEva> getEvaByBId(int bId) throws SQLException {
        return null;
    }

    @Override
    public int insertEva(BookEva be) throws SQLException {
        return 0;
    }

    @Override
    public int delEvaByBId(int bId) throws SQLException {
        return 0;
    }

    @Override
    public int delEvaByUId(int uId) throws SQLException {
        return 0;
    }

    @Override
    public List<BookEva> getEvaPage(int currentPage, int curtotalSize) throws SQLException {
        return null;
    }

    @Override
    public int delEvaByBeId(int beId) throws SQLException {
        return 0;
    }
}
