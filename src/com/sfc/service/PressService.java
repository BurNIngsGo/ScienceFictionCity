package com.sfc.service;

import com.sfc.entity.Press;

import java.sql.SQLException;
import java.util.List;

public interface PressService {
    /**
     * 获取所有出版社信息
     * @return
     */
    public List<Press> getPressAll() throws SQLException;

    /**
     * 添加一条出版社信息
     * @param pr
     * @return
     */
    public int insertPress(Press pr) throws SQLException;

    /**
     *  删除出版社信息
     * @param prId
     * @return
     */
    public int delPressByOId(int prId) throws SQLException;

    /**
     * 更新出版社信息
     * @param pr
     * @return
     */
    public int updatePressByprId(Press pr) throws SQLException;

    /**
     * 根据出版社id获取出版社信息
     * @param id
     * @return
     */
    public Press getPressByPressById(int id) throws SQLException;
}
