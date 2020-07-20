package com.sfc.dao;

import com.sfc.entity.Press;

import java.util.List;

public interface PressDao {
    /**
     * 获取所有出版社信息
     * @return
     */
    public List<Press> getPressAll();

    /**
     * 添加一条出版社信息
     * @param pr
     * @return
     */
    public int insertPress(Press pr);

    /**
     *  删除出版社信息
     * @param oId
     * @return
     */
    public int delPressByOId(int oId);

    /**
     * 更新出版社信息
     * @param pr
     * @return
     */
    public int updatePress(Press pr);

    /**
     * 根据出版社id获取出版社信息
     * @param id
     * @return
     */
    public Press getPressByPressById(int id);



}
