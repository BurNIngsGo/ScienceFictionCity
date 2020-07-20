package com.sfc.dao;

import com.sfc.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartDao {
    /**
     * 根据用户id获取该用户的购物车信息
     * @param uId
     * @return
     */
    public List<ShoppingCart> getShoppingCartByUId(int uId);

    /**
     * 添加商品到购物车
     * @param sc
     * @return
     */
    public int insertShoppingCart(ShoppingCart sc);

    /**
     * 更新购物车商品数量
     * @param sc
     * @return
     */
    public int updateShoppingCartCount(ShoppingCart sc);

    /**
     * 根据购物车id删除购物车信息
     * @param shId
     * @return
     */
    public int delShoppingCartByShId(int shId);

    /**
     * 获取每页信息
     * @param currentPage
     * @param curtotalSize
     * @return
     */
    public List<ShoppingCart> getShoppingCartPage(int currentPage,int curtotalSize);


}
