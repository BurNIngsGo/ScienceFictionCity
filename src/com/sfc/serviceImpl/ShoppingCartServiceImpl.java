package com.sfc.serviceImpl;

import com.sfc.entity.ShoppingCart;
import com.sfc.service.ShoppingCartService;

import java.sql.SQLException;
import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Override
    public List<ShoppingCart> getShoppingCartByUId(int uId) throws SQLException {
        return null;
    }

    @Override
    public int insertShoppingCart(ShoppingCart sc) throws SQLException {
        return 0;
    }

    @Override
    public int updateShoppingCartCountByuId(ShoppingCart sc) throws SQLException {
        return 0;
    }

    @Override
    public int delShoppingCartByShId(int shId) throws SQLException {
        return 0;
    }

    @Override
    public List<ShoppingCart> getShoppingCartPage(int currentPage, int curtotalSize) throws SQLException {
        return null;
    }
}
