package com.sfc.service;

import com.sfc.entity.AddressInfo;

import java.sql.SQLException;
import java.util.List;
/**
 * @Description:地址业务逻辑接口
 * @InterfaceName :AddressInfoService
 * @Author: AiGuo
 * @DATE:2020/8/3 19:20
 * @Version:1.0
 */
public interface AddressInfoService {
    /**
     * 根据用户id获取地址
     * @param uid
     * @return
     */
    public List<AddressInfo> getAddressByUserId(int uid) throws SQLException;

    /**
     * 获取所有记录的地址
     * @return
     */
    public List<AddressInfo> getAllAdddress() throws SQLException;

    /**
     * 根据用户id删除地址信息
     * @param uId
     * @return
     */
    public int delAddressByUid(int uId) throws SQLException;

    /**
     * 根据地址id删除地址信息
     * @param aId
     * @return
     */
    public int delAddressByAid(int aId) throws SQLException;

    /**
     * 添加一条地址
     * @param add
     * @return
     */
    public int insertAddress(AddressInfo add) throws SQLException;

    /**
     * 根据地址id更新地址信息
     * @param ui
     * @return
     */
    public int updateAddressByAid(AddressInfo ui) throws SQLException;

    /**
     * 根据用户id更新地址信息
     * @param ui
     * @return
     */
    public int updateAddressByAuId(AddressInfo ui) throws SQLException;
}
