package com.sfc.dao;

import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.sfc.entity.BookInfo;
import com.sfc.entity.BookType;

import java.sql.SQLException;
import java.util.List;

public interface BookTypeDao {
    /**
     * 获取所有图书类型
     * @return
     */
    public List<BookType> getBookTypeAll() throws SQLException;

    /**
     * 根据类型id获取类型
     * @param tId
     * @return
     */
    public BookInfo getBookTypeByTId(int tId) throws SQLException;

    /**
     * 根据类型id删除类型
     * @param tId
     * @return
     */
    public int delBookTypeByTId(int tId) throws SQLException;

    /**
     * 根据类型名称删除类型
     * @param tId
     * @return
     */
    public int delBookTypeByTName(String tId) throws SQLException;

    /**
     * 添加类型信息
     * @param bk
     * @return
     */
    public int insertBookType(BookType bk) throws SQLException;

    /**
     * 更新图书类型信息
     * @param bk
     * @return
     */
    public int updateBookTypeByTid(BookType bk) throws SQLException;

    /**
     * 根据图书类型名称获取类型id
     * @param tName
     * @return
     * @throws SQLException
     */
    public int getBookTypeIdByTypeName(String tName) throws SQLException;

    /**
     * 根据类型名称获取类型信息
     * @param tName
     * @return
     * @throws SQLException
     */
    public List<BookType> getAllByTypeName(String tName) throws SQLException;


}
