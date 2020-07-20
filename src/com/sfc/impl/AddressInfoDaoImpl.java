package com.sfc.impl;

import com.sfc.dao.AddressInfoDao;
import com.sfc.dao.BaseDao;
import com.sfc.entity.AddressInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AddressInfoDaoImpl extends BaseDao implements AddressInfoDao {
    public AddressInfoDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 根据用户id获取地址
     * @param uid
     * @return
     */
    public List<AddressInfo> getAddressByUserId(int uid) throws SQLException{
        String strSql = "select * from addressInfo where aUid = ?";
        Object[] param = {uid};
        try {
            return this.<AddressInfo>getEntity(new AddressInfo(),param,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 获取所有记录的地址
     * @return
     */
    public List<AddressInfo> getAllAdddress() throws SQLException{
        String strSql = "select * from addressinfo";
        try {
            return this.<AddressInfo>getEntity(new AddressInfo(), null,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据用户id删除地址信息
     * @param uId
     * @return
     */
    public int delAddressByUid(int uId) throws SQLException{
        String strSql = "delete from addressinfo where auid = ?";
        Object[] param = {uId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据地址id删除地址信息
     * @param aId
     * @return
     */
    public int delAddressByAid(int aId) throws SQLException{
        String strSql = "delete from addressinfo where aid = ?";
        Object[] param = {aId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 添加一条地址
     * @param add
     * @return
     */
    public int insertAddress(AddressInfo add) throws SQLException{
        String strSql = "insert into address values(?,?,?,?,?)";
        Object[] param = {add.getAid(),add.getaAddress(),add.getaPhone(),add.getaCode(),add.getaUid()};
        try {
            return this.executeUpdate(strSql, param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据地址id更新地址信息
     * @param ui
     * @return
     */
    public int updateAddressByAid(AddressInfo ui) throws SQLException{
        String strSql = "update address set aAddress = ?,aPhone = ?,aCode = ? where aid = ?";
        Object[] param = {ui.getaAddress(),ui.getaPhone(),ui.getaCode(),ui.getAid()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据用户id更新地址信息
     * @param ui
     * @return
     */
    public int updateAddressByAuId(AddressInfo ui) throws SQLException {
        String strSql = "update address set aAddress = ?,aPhone = ?,aCode = ? where auid = ?";
        Object[] param = {ui.getaAddress(),ui.getaPhone(),ui.getaCode(),ui.getaUid()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }
}
