package com.sfc.service;

import com.sfc.entity.BookInfo;
import com.sfc.entity.BookType;

import java.sql.SQLException;
import java.util.List;
/**
 * @Description:图书类型业务逻辑接口
 * @InterfaceName :BookTypeService
 * @Author: AiGuo
 * @DATE:2020/8/3 19:21
 * @Version:1.0
 */
public interface BookTypeService {
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
     * @param bName
     * @return
     * @throws SQLException
     */
    public int getBookTypeIdByTypeName(String bName) throws SQLException;

    /**
     * 根据类型名称获取类型信息
     * @param tName
     * @return
     * @throws SQLException
     */
    public List<BookType> getAllByTypeName(String tName) throws SQLException;
}
