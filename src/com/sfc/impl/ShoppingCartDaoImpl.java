package com.sfc.impl;

import com.sfc.dao.BaseDao;
import com.sfc.dao.ShoppingCartDao;
import com.sfc.entity.ShoppingCart;
import com.sfc.entity.ShoppingInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ShoppingCartDaoImpl extends BaseDao implements ShoppingCartDao {
    public ShoppingCartDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * 根据用户id获取该用户的购物车信息
     * @param uId
     * @return
     */
    public List<ShoppingInfo> getShoppingCartByUId(int uId) throws SQLException{
        String strSql = "SELECT sh.`shId`, b.`bImg`,b.`bName`,sh.`shDate`,sh.`shCount`,sh.`shPrice`,b.`bPrice` FROM" +
                " shoppingcart sh INNER JOIN bookinfo b ON sh.`bId` = b.`bId`  WHERE sh.`uId` = ?";
        Object[] param = {uId};
        try {
            return this.getEntity(new ShoppingInfo(),param,strSql);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 添加商品到购物车
     * @param sc
     * @return
     */
    public int insertShoppingCart(ShoppingCart sc) throws SQLException{
        String strSql = "insert info ShoppingCart(bid,shDate,uid,shCount) values(?,?,?,?)";
        Object[] param = {sc.getbId(),sc.getShDate(),sc.getuId(),sc.getShCount()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 更新购物车商品数量
     * @param sc
     * @return
     */
    public int updateShoppingCartCountByuId(ShoppingCart sc) throws SQLException{
        String strSql = "update ShoppingCart set shCount = ? where uid = ?";
        Object[] param = {sc.getShCount(),sc.getuId()};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 根据购物车id删除购物车信息
     * @param shId
     * @return
     */
    public int delShoppingCartByShId(int shId) throws SQLException{
        String strSql = "delete from ShoppingCart where shId = ?";
        Object[] param = {shId};
        try {
            return this.executeUpdate(strSql,param);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * 获取每页信息
     * @param currentPage
     * @param curtotalSize
     * @return
     */
    public List<ShoppingCart> getShoppingCartPage(int currentPage, int curtotalSize) {
        return null;
    }
}
