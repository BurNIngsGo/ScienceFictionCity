package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.ShoppingCartDao;
import com.sfc.entity.ShoppingCart;

import java.sql.Connection;
import java.util.List;

public class ShoppingCartDaoImpl extends BaseDao implements ShoppingCartDao {
    public ShoppingCartDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<ShoppingCart> getShoppingCartByUId(int uId) {
        return null;
    }

    @Override
    public int insertShoppingCart(ShoppingCart sc) {
        return 0;
    }

    @Override
    public int updateShoppingCartCount(ShoppingCart sc) {
        return 0;
    }

    @Override
    public int delShoppingCartByShId(int shId) {
        return 0;
    }

    @Override
    public List<ShoppingCart> getShoppingCartPage(int currentPage, int curtotalSize) {
        return null;
    }
}
