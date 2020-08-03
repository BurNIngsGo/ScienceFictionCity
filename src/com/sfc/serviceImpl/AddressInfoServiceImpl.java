package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.AddressInfoDao;
import com.sfc.entity.AddressInfo;
import com.sfc.impl.AddressInfoDaoImpl;
import com.sfc.service.AddressInfoService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * @Description:地址信息业务逻辑实现
 * @ClassName :AddressInfoServiceImpl
 * @Author: AiGuo
 * @DATE:2020/8/3 19:40
 * @Version:1.0
 */
public class AddressInfoServiceImpl implements AddressInfoService {
    /**
     * 根据用户id获取地址
     * @param uid
     * @return
     */
    public List<AddressInfo> getAddressByUserId(int uid) throws SQLException{
        Connection conn =  BaseDaoUtil.getConnection();
        AddressInfoDao addressInfoDao = new AddressInfoDaoImpl(conn);
        try {
            return addressInfoDao.getAddressByUserId(uid);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 获取所有记录的地址
     * @return
     */
    public List<AddressInfo> getAllAdddress() throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        AddressInfoDao addressInfoDao = new AddressInfoDaoImpl(conn);
        try {
            return addressInfoDao.getAllAdddress();
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 根据用户id删除地址信息
     * @param uId
     * @return
     */
    public int delAddressByUid(int uId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        AddressInfoDao addressInfoDao = new AddressInfoDaoImpl(conn);
        try {
            return addressInfoDao.delAddressByUid(uId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null, null, conn);
        }
    }

    /**
     * 根据地址id删除地址信息
     * @param aId
     * @return
     */
    public int delAddressByAid(int aId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        AddressInfoDao addressInfoDao = new AddressInfoDaoImpl(conn);
        try {
            return addressInfoDao.delAddressByUid(aId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null, null, conn);
        }
    }

    /**
     * 添加一条地址
     * @param add
     * @return
     */
    public int insertAddress(AddressInfo add) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        AddressInfoDao addressInfoDao = new AddressInfoDaoImpl(conn);
        try {
            return addressInfoDao.insertAddress(add);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null, null, conn);
        }
    }

    /**
     * 根据地址id更新地址信息
     * @param ui
     * @return
     */
    public int updateAddressByAid(AddressInfo ui) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        AddressInfoDao addressInfoDao = new AddressInfoDaoImpl(conn);
        try {
            return addressInfoDao.updateAddressByAid(ui);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null, null, conn);
        }
    }

    /**
     * 根据用户id更新地址信息
     * @param ui
     * @return
     */
    public int updateAddressByAuId(AddressInfo ui) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        AddressInfoDao addressInfoDao = new AddressInfoDaoImpl(conn);
        try {
            return addressInfoDao.updateAddressByAuId(ui);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null, null, conn);
        }
    }
}
