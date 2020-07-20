package com.sfc.dao;

import com.sfc.entity.BookInfo;
import com.sfc.entity.BookType;

import java.util.List;

public interface BookTypeDao {
    /**
     * 获取所有图书类型
     * @return
     */
    public List<BookType> getBookTypeAll();

    /**
     * 根据类型id获取类型
     * @param tId
     * @return
     */
    public BookInfo getBookTypeByTId(int tId);

    /**
     * 根据类型id删除类型
     * @param tId
     * @return
     */
    public int delBookTypeByTId(int tId);

    /**
     * 根据类型名称删除类型
     * @param tId
     * @return
     */
    public int delBookTypeByTName(String tId);

    /**
     * 添加类型信息
     * @param bk
     * @return
     */
    public int insertBookType(BookType bk);

    /**
     * 更新图书类型信息
     * @param bk
     * @return
     */
    public int updateBookType(BookType bk);






}
