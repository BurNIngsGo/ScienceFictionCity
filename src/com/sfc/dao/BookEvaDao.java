package com.sfc.dao;

import com.sfc.entity.BookEva;

import java.util.List;

public interface BookEvaDao {
    /**
     * 根据用户id获取评论信息
     * @param uId
     * @return
     */
    public List<BookEva>getEvaByUId(int uId);

    /**
     * 根据图书id获取评论信息
     * @param bId
     * @return
     */
    public List<BookEva>getEvaByBId(int bId);

    /**
     * 用户评论了一条信息(添加一条评论)
     * @param be
     * @return
     */
    public int insertEva(BookEva be);

    /**
     * 根据图书id删除评论(删除该数所有评论)
     * @param bId
     * @return
     */
    public int delEvaByBId(int bId);

    /**
     * 删除用户评论过的信息
     * @param uId
     * @return
     */
    public int delEvaByUId(int uId);

    /**
     * 对评论分页
     * @param currentPage
     * @param curtotalSize
     * @return
     */
    public List<BookEva>getEvaPage(int currentPage,int curtotalSize);

    /**
     * 删除对应评论编号的信息
     * @param BeId
     * @return
     */
    public  int delEvaByBeId(int BeId);








}
