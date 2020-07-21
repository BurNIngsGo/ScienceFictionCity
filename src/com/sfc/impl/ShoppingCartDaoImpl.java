package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.ShoppingCartDao;
import com.sfc.entity.ShoppingCart;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ShoppingCartDaoImpl extends BaseDao implements ShoppingCartDao {
    public ShoppingCartDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<ShoppingCart> getShoppingCartByUId(int uId) throws SQLException{
        String strSql = "select * from shoppingcart where uid = ?";
        Object[] param = {uId};
        try {
            return this.getEntity(new ShoppingCart(),param,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int insertShoppingCart(ShoppingCart sc) throws SQLException{
        String strSql = "insert info ShoppingCart(bid,shDate,uid,shCount) values(?,?,?,?)";
        Object[] param = {sc.getbId(),sc.getShDate(),sc.getuId(),sc.getShCount()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int updateShoppingCartCountByuId(ShoppingCart sc) throws SQLException{
        String strSql = "update ShoppingCart set shCount = ? where uid = ?";
        Object[] param = {sc.getShCount(),sc.getuId()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int delShoppingCartByShId(int shId) throws SQLException{
        String strSql = "delete from ShoppingCart where shId = ?";
        Object[] param = {shId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<ShoppingCart> getShoppingCartPage(int currentPage, int curtotalSize) {
        return null;
    }
}
