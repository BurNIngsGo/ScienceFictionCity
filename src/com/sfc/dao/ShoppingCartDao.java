package com.sfc.dao;

import com.sfc.entity.ShoppingCart;
import com.sfc.entity.ShoppingInfo;

import java.sql.SQLException;
import java.util.List;
/**
 * @Description:购物车信息
 * @InterfaceName :ShoppingCartDao
 * @Author: AiGuo
 * @DATE:2020/8/3 18:10
 * @Version:1.0
 */
public interface ShoppingCartDao {
    /**
     * 根据用户id获取该用户的购物车信息
     * @param uId
     * @return
     */
    public List<ShoppingInfo> getShoppingCartByUId(int uId) throws SQLException;

    /**
     * 添加商品到购物车
     * @param sc
     * @return
     */
    public int insertShoppingCart(ShoppingCart sc) throws SQLException;

    /**
     * 更新购物车商品数量
     * @param sc
     * @return
     */
    public int updateShoppingCartCountByuId(ShoppingCart sc) throws SQLException;

    /**
     * 根据购物车id删除购物车信息
     * @param shId
     * @return
     */
    public int delShoppingCartByShId(int shId) throws SQLException;

    /**
     * 获取每页信息
     * @param currentPage
     * @param curtotalSize
     * @return
     */
    public List<ShoppingCart> getShoppingCartPage(int currentPage,int curtotalSize) throws SQLException;


}
