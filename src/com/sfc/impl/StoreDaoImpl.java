package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.StoreDao;
import com.sfc.entity.Store;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
/**
 * @Description:收藏实现类
 * @ClassName :StoreDaoImpl
 * @Author: AiGuo
 * @DATE:2020/8/3 19:34
 * @Version:1.0
 */
public class StoreDaoImpl extends BaseDao implements StoreDao {
    public StoreDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 根据用户id获取收藏夹
     * @param uId
     * @return
     */
    public List<Store> getStoreByUId(int uId) throws SQLException{
        String strSql = "select * from Store where uid = ?";
        Object[] param = {uId};
        try {
            return this.getEntity(new Store(),param,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 添加到收藏夹
     * @param st
     * @return
     */
    public int insertStore(Store st) throws SQLException{
        String strSql = "insert into store(bid,sDate,uid) values(?,?,?)";
        Object[] param = {st.getbId(), st.getsDate(),st.getuId()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据图书id移除图书于收藏夹
     * @param uId
     * @return
     */
    public int delStoreByuId(int uId) throws SQLException{
        String strSql = "delete from store where uid = ?";
        Object[] param = {uId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }
}
