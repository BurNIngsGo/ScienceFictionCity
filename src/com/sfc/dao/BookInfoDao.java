package com.sfc.dao;

import com.sfc.entity.BookInfo;

import java.util.List;

public interface BookInfoDao {
    /**
     * 获取所有图书信息
     * @return List<BookInfo>
     */
    public List<BookInfo> getBookAll();

    /**
     * 根据类型编号获取图书类型
     * @param tId
     * @return
     */
    public List<BookInfo> getBookByType(int tId);

    /**
     * 根据出版社获取图书信息
     * @param pId
     * @return
     */
    public List<BookInfo> getBookByPressId(int pId);

    /**
     * 对图书信息进行分页
     * @param currentPage
     * @param curtotalSize
     * @return
     */
    public List<BookInfo> getBookPage(int currentPage,int curtotalSize);

    /**
     * 添加图书(图书上架)
     * @param bi
     * @return
     */
    public int insertBook(BookInfo bi);

    /**
     * 根据图书id删除图书信息
     * @param bId
     * @return
     */
    public int delBookByBId(int bId);

    /**
     * 根据图书名称删除图书
     * @param bName
     * @return
     */
    public int delBookByBName(String bName);

    /**
     * 根据图书名称获取图书信息
     * @param bName
     * @return
     */
    public List<BookInfo> getBookByBName(String bName);

    /**
     * 根据图书id获取图书信息
     * @param bName
     * @return
     */
    public BookInfo getBookByBId(String bName);

    /**
     * 更新图书销量和库存
     * @param bi
     * @return
     */
    public int updateBookSales(BookInfo bi);

    /**
     * 更新图书信息
     * @param bi
     * @return
     */
    public int updateBook(BookInfo bi);


}
