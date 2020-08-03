package com.sfc.serviceImpl;

import com.sfc.connpool.BaseDaoUtil;
import com.sfc.dao.ShoppingCartDao;
import com.sfc.dao.StoreDao;
import com.sfc.entity.ShoppingCart;
import com.sfc.entity.ShoppingInfo;
import com.sfc.impl.ShoppingCartDaoImpl;
import com.sfc.impl.StoreDaoImpl;
import com.sfc.service.ShoppingCartService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * @Description:购物车信息业务逻辑实现
 * @ClassName :ShoppingCartServiceImpl
 * @Author: AiGuo
 * @DATE:2020/8/3 19:47
 * @Version:1.0
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {
    /**
     * 根据用户id获取该用户的购物车信息
     * @param uId
     * @return
     */
    public List<ShoppingInfo> getShoppingCartByUId(int uId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl(conn);
        try {
            return shoppingCartDao.getShoppingCartByUId(uId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 添加商品到购物车
     * @param sc
     * @return
     */
    public int insertShoppingCart(ShoppingCart sc) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl(conn);
        try {
            return shoppingCartDao.insertShoppingCart(sc);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 更新购物车商品数量
     * @param sc
     * @return
     */
    public int updateShoppingCartCountByuId(ShoppingCart sc) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl(conn);
        try {
            return shoppingCartDao.updateShoppingCartCountByuId(sc);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 根据购物车id删除购物车信息
     * @param shId
     * @return
     */
    public int delShoppingCartByShId(int shId) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl(conn);
        try {
            return shoppingCartDao.delShoppingCartByShId(shId);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }

    /**
     * 获取每页信息
     * @param currentPage
     * @param curtotalSize
     * @return
     */
    public List<ShoppingCart> getShoppingCartPage(int currentPage, int curtotalSize) throws SQLException {
        Connection conn =  BaseDaoUtil.getConnection();
        ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl(conn);
        try {
            return shoppingCartDao.getShoppingCartPage(currentPage,curtotalSize);
        } catch (SQLException e) {
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null,null,conn);
        }
    }
}
