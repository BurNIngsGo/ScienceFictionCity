package com.sfc.dao;

import com.sfc.entity.BookInfo;

import java.sql.SQLException;
import java.util.List;
/**
 * @Description:图书信息
 * @InterfaceName :BookInfoDao
 * @Author: AiGuo
 * @DATE:2020/8/3 18:01
 * @Version:1.0
 */
public interface BookInfoDao {
    /**
     * 获取所有图书信息
     * @return List<BookInfo>
     */
    public List<BookInfo> getBookAll() throws SQLException;

    /**
     * 根据类型编号获取图书
     * @param tId
     * @return
     */
    public List<BookInfo> getBookByType(int tId) throws SQLException;

    /**
     * 根据出版社获取图书信息
     * @param pId
     * @return
     */
    public List<BookInfo> getBookByPressId(int pId) throws SQLException;

    /**
     * 对图书信息进行分页
     * @param currentPage
     * @param curtotalSize
     * @return
     */
    public List<BookInfo> getBookPage(int currentPage,int curtotalSize) throws SQLException;

    /**
     * 添加图书(图书上架)
     * @param bi
     * @return
     */
    public int insertBook(BookInfo bi) throws SQLException;

    /**
     * 根据图书id删除图书信息
     * @param bId
     * @return
     */
    public int delBookByBId(int bId) throws SQLException;

    /**
     * 根据图书名称删除图书
     * @param bName
     * @return
     */
    public int delBookByBName(String bName) throws SQLException;

    /**
     * 根据图书名称获取图书信息
     * @param bName
     * @return
     */
    public List<BookInfo> getBookByBName(String bName) throws SQLException;

    /**
     * 根据图书id获取图书信息
     * @param bid
     * @return
     */
    public BookInfo getBookByBId(int bid) throws SQLException;

    /**
     * 更新图书销量和库存
     * @param bi
     * @return
     */
    public int updateBookSales(BookInfo bi) throws SQLException;

    /**
     * 更新图书信息
     * @param bi
     * @return
     */
    public int updateBookByBid(BookInfo bi) throws SQLException;

    /**
     * 获取总数据量
     * @return
     * @throws SQLException
     */
    public int getCount() throws SQLException;

    /**
     * 根据多条件查询图书信息
     * @param bType
     * @param bPress
     * @param bBeginTime
     * @param bEndTime
     * @return
     * @throws SQLException
     */
    public List getBookByTypeAndPressAndTime(int bType, int bPress, int bBeginTime, int bEndTime) throws SQLException;


    /**
     * 根据销量排序
     * @return
     */
    public List<BookInfo> getBookAllDesc() throws SQLException;

    /**
     * 模糊查询
     * @return
     * @throws SQLException
     */
    public List<BookInfo> getBookAllByBookName(String uName) throws SQLException;

}
