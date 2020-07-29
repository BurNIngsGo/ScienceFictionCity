package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.PressDao;
import com.sfc.entity.Press;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PressDaoImpl extends BaseDao implements PressDao {
    public PressDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 获取所有出版社信息
     * @return
     */
    public List<Press> getPressAll() throws SQLException{
        String strSql = "select * from Press";
        try {
            return this.getEntity(new Press(),null,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 添加一条出版社信息
     * @param pr
     * @return
     */
    public int insertPress(Press pr) throws SQLException{
        String strSql = "insert into press(prName) values(?)";
        Object[] param = {pr.getPrName()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     *  删除出版社信息
     * @param prId
     * @return
     */
    public int delPressByOId(int prId) throws SQLException{
        String strSql = "delete press where PrId = ?";
        Object[] param = {prId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 更新出版社信息
     * @param pr
     * @return
     */
    public int updatePressByprId(Press pr) throws SQLException{
        String strSql = "update press set prName = ? where prid = ?";
        Object[] param = {pr.getPrName(),pr.getPrName()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据出版社id获取出版社信息
     * @param id
     * @return
     */
    public Press getPressByPressById(int id) throws SQLException{
        String strSql = "select * from Press where prId = ?";
        Object[] param = {id};
        List<Press> list = null;
        try {
            list =  this.getEntity(new Press(),param,strSql);
            if(list.size() > 0){
                return list.get(0);
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int getPressIdByPressName(String pName) throws SQLException {
        String strSql = "select * from press where prName = ?";
        Object[] param = {pName};
        try {
            return this.getEntity(new Press(),param,strSql).get(0).getPrId();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<Press> getAllByPrName(String pName) throws SQLException{
        String strSql = "select * from press where PrName like \"%\"?\"%\"";
        Object[] param = {pName};
        try {
            return this.getEntity(new Press(),param,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }
}
