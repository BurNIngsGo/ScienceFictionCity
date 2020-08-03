package com.sfc.service;

import com.sfc.entity.BookEva;

import java.sql.SQLException;
import java.util.List;
/**
 * @Description:用户评论业务逻辑接口
 * @InterfaceName :BookEvaService
 * @Author: AiGuo
 * @DATE:2020/8/3 19:20
 * @Version:1.0
 */
public interface BookEvaService {
    /**
     * 根据用户id获取评论信息
     * @param uId
     * @return
     */
    public List<BookEva> getEvaByUId(int uId) throws SQLException;

    /**
     * 根据图书id获取评论信息
     * @param bId
     * @return
     */
    public List<BookEva>getEvaByBId(int bId) throws SQLException;

    /**
     * 用户评论了一条信息(添加一条评论)
     * @param be
     * @return
     */
    public int insertEva(BookEva be) throws SQLException;

    /**
     * 根据图书id删除评论(删除该数所有评论)
     * @param bId
     * @return
     */
    public int delEvaByBId(int bId) throws SQLException;

    /**
     * 删除用户评论过的信息
     * @param uId
     * @return
     */
    public int delEvaByUId(int uId) throws SQLException;

    /**
     * 对评论分页
     * @param currentPage
     * @param curtotalSize
     * @return
     */
    public List<BookEva>getEvaPage(int currentPage,int curtotalSize) throws SQLException;

    /**
     * 删除对应评论编号的信息
     * @param beId
     * @return
     */
    public  int delEvaByBeId(int beId) throws SQLException;
}
